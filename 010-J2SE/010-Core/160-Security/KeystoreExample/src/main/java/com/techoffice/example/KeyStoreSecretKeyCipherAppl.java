package com.techoffice.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class KeyStoreSecretKeyCipherAppl {

	public static void main(String[] args) throws Exception{
		KeyStore keystore = KeyStore.getInstance("JCEKS");
		String userFolder = System.getProperty("user.home");
		String defaultKeystoreFilename = ".keystore";
		File defaultKeystoreFile = new File(userFolder, defaultKeystoreFilename);
		FileInputStream fileInputStream = new FileInputStream(defaultKeystoreFile);
		char[] keystorePassword = "123456".toCharArray();
		keystore.load(fileInputStream, keystorePassword);
		Key myKey = keystore.getKey("mykey", "1234567".toCharArray());
		if (myKey instanceof SecretKeySpec){
			SecretKeySpec mySecretKey = (SecretKeySpec) myKey;
			Cipher cipher = Cipher.getInstance(mySecretKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, mySecretKey);
			byte[] encryptedText = cipher.doFinal("This is testing".getBytes());
			System.out.println("Encrypted Text: " + new String(encryptedText));
			cipher.init(Cipher.DECRYPT_MODE, mySecretKey);
			byte[] decryptedText = cipher.doFinal(encryptedText);
			System.out.println("Decrypted Text: " + new String(decryptedText));
		}
	}
}
