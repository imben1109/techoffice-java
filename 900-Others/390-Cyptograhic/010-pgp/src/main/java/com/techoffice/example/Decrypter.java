package com.techoffice.example;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

import java.io.*;
import java.security.Security;
import java.util.Iterator;

@Slf4j
public class Decrypter {

    public static void main(String[] args) throws IOException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        OutputStream out = new FileOutputStream(new File("decryptedFile.txt"));
        InputStream in = PGPUtil.getDecoderStream(new FileInputStream(new File("chiperedFile.txt")));
        PGPObjectFactory pgpObjectFactory = new PGPObjectFactory(in, new JcaKeyFingerprintCalculator());
        PGPEncryptedDataList encryptedDataList;
        Object pgpObject = pgpObjectFactory.nextObject();
        if (pgpObject instanceof PGPEncryptedDataList){
            encryptedDataList = (PGPEncryptedDataList) pgpObject;
        }else {
            encryptedDataList = (PGPEncryptedDataList) pgpObjectFactory.nextObject();
        }
        Iterator<PGPEncryptedData> encryptedDataObjects = encryptedDataList.getEncryptedDataObjects();
        while(encryptedDataObjects.hasNext()){
            PGPEncryptedData pgpEncryptedData = encryptedDataObjects.next();
            if (pgpEncryptedData instanceof PGPPublicKeyEncryptedData){
                PGPPublicKeyEncryptedData pgpPublicKeyEncryptedData = (PGPPublicKeyEncryptedData) pgpEncryptedData;
                log.info("public key id: {}", pgpPublicKeyEncryptedData.getKeyID());
                PGPPrivateKey privateKey = getSecretKey("secretKey.key", pgpPublicKeyEncryptedData.getKeyID());

                InputStream clear = pgpPublicKeyEncryptedData.getDataStream(new BcPublicKeyDataDecryptorFactory(privateKey));
                PGPObjectFactory plainFact = new PGPObjectFactory(clear, new BcKeyFingerprintCalculator());
                Object message = plainFact.nextObject();

                if (message instanceof PGPCompressedData) {
                    PGPCompressedData compressedData = (PGPCompressedData) message;
                    PGPObjectFactory pgpFact = new PGPObjectFactory(compressedData.getDataStream(), new BcKeyFingerprintCalculator());
                    message = pgpFact.nextObject();
                }

                if (message instanceof PGPLiteralData) {
                    PGPLiteralData data = (PGPLiteralData) message;

                    InputStream unc = data.getInputStream();
                    int ch;

                    while ((ch = unc.read()) >= 0) {
                        out.write(ch);
                    }
                }
            }
        }
        out.close();
    }

    public static PGPPrivateKey getSecretKey(String secretKeyFile, long keyId) throws IOException, PGPException {
        InputStream inputStream = new FileInputStream(new File(secretKeyFile));
        PGPSecretKeyRingCollection secretKeyRingCollection = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator());
        log.info("Secret Key Collection Size: {}", secretKeyRingCollection.size());
        PGPSecretKey pgpSecretKey = secretKeyRingCollection.getSecretKey(keyId);
        if (pgpSecretKey == null){
            log.info("cannot find secret key with public key id: {}", keyId);
            return null;
        }
        JcePBESecretKeyDecryptorBuilder secretKeyDecryptorBuilder = new JcePBESecretKeyDecryptorBuilder();
        secretKeyDecryptorBuilder.setProvider(BouncyCastleProvider.PROVIDER_NAME);
        PBESecretKeyDecryptor secretKeyDecryptor = secretKeyDecryptorBuilder.build("password".toCharArray());
        return pgpSecretKey.extractPrivateKey(secretKeyDecryptor);
    }
}
