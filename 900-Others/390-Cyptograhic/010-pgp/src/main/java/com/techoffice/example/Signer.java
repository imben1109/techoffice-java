package com.techoffice.example;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

import java.io.*;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

@Slf4j
public class Signer {

    public static void main(String[] args) throws IOException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        String singedMessage = signMessage("testing");
        log.info("Singed Message: {}", singedMessage);

    }

    public static String signMessage(String message) throws IOException, PGPException {
        byte[] messageCharArray = message.getBytes();

        PGPSecretKey secretKey = getSecretKey("secretKey.key");
        PGPPrivateKey pgpPrivKey = getPrivateKey(secretKey, "password");

        PGPContentSignerBuilder signerBuilder = new JcaPGPContentSignerBuilder(
                secretKey.getPublicKey().getAlgorithm(),
                PGPUtil.SHA1).setProvider("BC");

        PGPSignatureGenerator signatureGenerator = new PGPSignatureGenerator(signerBuilder);
        signatureGenerator.init(PGPSignature.BINARY_DOCUMENT, pgpPrivKey);

        Iterator userIds = secretKey.getPublicKey().getUserIDs();
        if (userIds.hasNext()) {
            PGPSignatureSubpacketGenerator spGen = new PGPSignatureSubpacketGenerator();
            spGen.setSignerUserID(false, (String) userIds.next());
            signatureGenerator.setHashedSubpackets(spGen.generate());
        }

        PGPCompressedDataGenerator compressedDataGenerator = new PGPCompressedDataGenerator(
                PGPCompressedData.ZLIB);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BCPGOutputStream bcpgOutputStream = new BCPGOutputStream(compressedDataGenerator.open(out));

        signatureGenerator.generateOnePassVersion(false).encode(bcpgOutputStream);
        PGPLiteralDataGenerator literalDataGernateor = new PGPLiteralDataGenerator();

        OutputStream laterOutStream = literalDataGernateor.open(bcpgOutputStream, PGPLiteralData.BINARY,
                PGPLiteralData.CONSOLE, messageCharArray.length, new Date());

        for (byte c : messageCharArray) {
            laterOutStream.write(c);
            signatureGenerator.update(c);
        }

        laterOutStream.close();
        literalDataGernateor.close();

        signatureGenerator.generate().encode(bcpgOutputStream);

        compressedDataGenerator.close();
        return out.toString();
    }

    public static PGPSecretKey getSecretKey(String secretKeyFile) throws IOException, PGPException {
        InputStream inputStream = new FileInputStream(new File(secretKeyFile));
        PGPSecretKeyRingCollection secretKeyRingCollection = new PGPSecretKeyRingCollection(
                PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator());
        log.info("Secret Key Collection Size: {}", secretKeyRingCollection.size());
        Iterator<PGPSecretKeyRing> keyRingIterator = secretKeyRingCollection.getKeyRings();
        while (keyRingIterator.hasNext()){
            PGPSecretKeyRing pgpSecretKeyRing = keyRingIterator.next();
            Iterator<PGPSecretKey> secretKeyIterator = pgpSecretKeyRing.getSecretKeys();
            while (secretKeyIterator.hasNext()){
                PGPSecretKey secretKey = secretKeyIterator.next();
                if (secretKey.isSigningKey()){
                    return secretKey;
                }
            }
        }
        return null;
    }

    public static PGPPrivateKey getPrivateKey(PGPSecretKey pgpSecretKey, String password) throws PGPException {
        JcePBESecretKeyDecryptorBuilder secretKeyDecryptorBuilder = new JcePBESecretKeyDecryptorBuilder();
        secretKeyDecryptorBuilder.setProvider(BouncyCastleProvider.PROVIDER_NAME);
        PBESecretKeyDecryptor secretKeyDecryptor = secretKeyDecryptorBuilder.build(password.toCharArray());
        return pgpSecretKey.extractPrivateKey(secretKeyDecryptor);
    }
}
