package com.techoffice.example;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;

import java.io.*;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

@Slf4j
public class Encrypter {

    public static void main(String[] args) throws IOException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        PGPPublicKey pgpPublicKey = getPublicKey(new File("publicKey.key"));

        FileOutputStream cipheredFileIs = new FileOutputStream(new File("chiperedFile.txt"));

        ByteArrayOutputStream processingStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator compressedDataGenerator = new PGPCompressedDataGenerator(PGPCompressedData.ZIP);
        PGPUtil.writeFileToLiteralData(
                compressedDataGenerator.open(processingStream),
                PGPLiteralData.BINARY,
                new File("originalFile.txt")
        );
        compressedDataGenerator.close();

        JcePGPDataEncryptorBuilder dataEncryptorBuilder = new JcePGPDataEncryptorBuilder(PGPEncryptedData.CAST5)
                .setSecureRandom(new SecureRandom())
                .setProvider("BC");
        PGPEncryptedDataGenerator encryptedDataGenerator = new PGPEncryptedDataGenerator(dataEncryptorBuilder);
        JcePublicKeyKeyEncryptionMethodGenerator publicKeyKeyEncryptionMethodGenerator = new JcePublicKeyKeyEncryptionMethodGenerator(pgpPublicKey)
                .setProvider(new BouncyCastleProvider())
                .setSecureRandom(new SecureRandom());
        encryptedDataGenerator.addMethod(publicKeyKeyEncryptionMethodGenerator);

        byte[] bytes = processingStream.toByteArray();
        log.info("processing byte array size: {}", Integer.toString(bytes.length));

        OutputStream chippedStream = encryptedDataGenerator.open(cipheredFileIs, bytes.length);

        chippedStream.write(bytes);
        chippedStream.close();

        cipheredFileIs.close();
    }

    public static PGPPublicKey getPublicKey(File publicKeyFile) throws IOException, PGPException {
        InputStream pubKeyIs = new FileInputStream(publicKeyFile);
        InputStream decoderStream = PGPUtil.getDecoderStream(pubKeyIs);
        PGPPublicKeyRingCollection pgpPublicKeyRingCollection = new PGPPublicKeyRingCollection(decoderStream, new JcaKeyFingerprintCalculator());

        log.info("Size of Collection: {}", pgpPublicKeyRingCollection.size());

        Iterator<PGPPublicKeyRing> keyRings = pgpPublicKeyRingCollection.getKeyRings();
        int keyCount = 0;
        while(keyRings.hasNext()){
            PGPPublicKeyRing keyRing = keyRings.next();
            Iterator<PGPPublicKey> publicKeyIterator = keyRing.getPublicKeys();
            while (publicKeyIterator.hasNext()){
                PGPPublicKey publicKey = publicKeyIterator.next();
                if (publicKey.isEncryptionKey()){
                    return publicKey;
                }
            }
        }
        return null;
    }
}
