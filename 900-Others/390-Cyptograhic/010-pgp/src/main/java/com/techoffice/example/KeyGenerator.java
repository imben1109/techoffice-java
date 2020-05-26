package com.techoffice.example;


import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPGPKeyPair;

import javax.crypto.NoSuchPaddingException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

@Slf4j
public class KeyGenerator {

	public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, NoSuchPaddingException, PGPException, IOException {
		Security.addProvider(new BouncyCastleProvider());

		String userId = "tester";
		String password = "password";

		PGPKeyRingGenerator pgpKeyRingGenerator = getPgpGenerator(userId, password);
		PGPPublicKeyRing pgpPublicKeyRing = pgpKeyRingGenerator.generatePublicKeyRing();
		PGPSecretKeyRing pgpSecretKeyRing = pgpKeyRingGenerator.generateSecretKeyRing();

		String publicKeyFilename = "publicKey.key";
		String secretKeyFilename = "secretKey.key";

		ArmoredOutputStream publicKeyOutputStream = new ArmoredOutputStream(new FileOutputStream(publicKeyFilename));
		ArmoredOutputStream secretKeyOutputStream = new ArmoredOutputStream(new FileOutputStream(secretKeyFilename));

		int keyCount = 0;
		Iterator<PGPPublicKey>  pgpPublicKeyIterator = pgpPublicKeyRing.getPublicKeys();;
		while(pgpPublicKeyIterator.hasNext()){
			PGPPublicKey pgpPublicKey = pgpPublicKeyIterator.next();
			if (pgpPublicKey.isEncryptionKey()){
				log.info("have encryption key");
			}
//			pgpPublicKey.encode(publicKeyOutputStream);
			keyCount++;
		}
		log.info("Num of Public Key in key ring: {}", keyCount);

		pgpPublicKeyRing.encode(publicKeyOutputStream);
		pgpSecretKeyRing.encode(secretKeyOutputStream);

		publicKeyOutputStream.close();
		secretKeyOutputStream.close();
	}

	public static PGPKeyRingGenerator getPgpGenerator(String userId, String password) throws PGPException {
		int keySize = 1024;

		RSAKeyPairGenerator rsaKeyPairGenerator = new RSAKeyPairGenerator();
		rsaKeyPairGenerator.init(new RSAKeyGenerationParameters(BigInteger.valueOf(0x10001), new SecureRandom(), keySize, 12));

		BcPGPKeyPair signingKeyPair = new BcPGPKeyPair(PGPPublicKey.RSA_SIGN, rsaKeyPairGenerator.generateKeyPair(), new Date());

		PGPDigestCalculator pgpDigestCalculator = new BcPGPDigestCalculatorProvider().get(HashAlgorithmTags.SHA1);

		PGPSignatureSubpacketGenerator signatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
		signatureSubpacketGenerator.setKeyFlags(false, KeyFlags.SIGN_DATA | KeyFlags.CERTIFY_OTHER);
		signatureSubpacketGenerator.setPreferredSymmetricAlgorithms(false, new int[] {SymmetricKeyAlgorithmTags.AES_256});
		signatureSubpacketGenerator.setPreferredHashAlgorithms(false, new int[] {HashAlgorithmTags.SHA256});
		signatureSubpacketGenerator.setPreferredCompressionAlgorithms(false, new int[] {CompressionAlgorithmTags.ZIP});

		BcPGPContentSignerBuilder bcPGPContentSignerBuilder = new BcPGPContentSignerBuilder(PGPPublicKey.RSA_SIGN, HashAlgorithmTags.SHA256);
		BcPBESecretKeyEncryptorBuilder secretKeyEncryptorBuilder = new BcPBESecretKeyEncryptorBuilder(SymmetricKeyAlgorithmTags.AES_256);
		PBESecretKeyEncryptor pbeSecretKeyEncryptor = secretKeyEncryptorBuilder.build(password.toCharArray());


		PGPKeyRingGenerator generator = new PGPKeyRingGenerator(PGPPublicKey.RSA_SIGN, signingKeyPair, userId,
				pgpDigestCalculator,
				signatureSubpacketGenerator.generate(),
				null,
				bcPGPContentSignerBuilder,
				pbeSecretKeyEncryptor);

		BcPGPKeyPair encryptionKeyPair = new BcPGPKeyPair(PGPPublicKey.RSA_ENCRYPT, rsaKeyPairGenerator.generateKeyPair(), new Date());
		PGPSignatureSubpacketGenerator encryptionSubpacketGenerator = new PGPSignatureSubpacketGenerator();
		encryptionSubpacketGenerator.setKeyFlags(false, KeyFlags.ENCRYPT_COMMS | KeyFlags.ENCRYPT_STORAGE);
		generator.addSubKey(encryptionKeyPair, encryptionSubpacketGenerator.generate(), null);

		return generator;
	}

}
