package com.techoffice.example;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Signer {

    public static void main(String[] args){
        PGPSecretKey                secretKey = getSecretKey("");
        PGPPrivateKey               pgpPrivKey = getPrivateKey(secretKey);
        PGPSignatureGenerator       sGen = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(pgpSec.getPublicKey().getAlgorithm(), PGPUtil.SHA1).setProvider("BC"));

    }

    public static PGPSecretKey getSecretKey(String secretKeyFile, long keyId) throws IOException, PGPException {
        InputStream inputStream = new FileInputStream(new File(secretKeyFile));
        PGPSecretKeyRingCollection secretKeyRingCollection = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new JcaKeyFingerprintCalculator());
        log.info("Secret Key Collection Size: {}", secretKeyRingCollection.size());
        PGPSecretKey pgpSecretKey = secretKeyRingCollection.getSecretKey(keyId);
        if (pgpSecretKey == null){
            log.info("cannot find secret key with public key id: {}", keyId);
            return null;
        }
        return pgpSecretKey;
    }

    public static PGPPrivateKey getPrivateKey(PGPSecretKey pgpSecretKey) throws PGPException {
        JcePBESecretKeyDecryptorBuilder secretKeyDecryptorBuilder = new JcePBESecretKeyDecryptorBuilder();
        secretKeyDecryptorBuilder.setProvider(BouncyCastleProvider.PROVIDER_NAME);
        PBESecretKeyDecryptor secretKeyDecryptor = secretKeyDecryptorBuilder.build("password".toCharArray());
        return pgpSecretKey.extractPrivateKey(secretKeyDecryptor);
    }
}
