package com.techoffice.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;
import java.util.Enumeration;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyStoreAppl {

	public static void main(String[] args) throws Exception{
		KeyStore keystore = KeyStore.getInstance("JCEKS");
		String userFolder = System.getProperty("user.home");
		String defaultKeystoreFilename = "test.keystore";
		String aliasName = "myKey";
		char[] aliasPassword = "1234567".toCharArray();
		
		File defaultKeystoreFile = new File(userFolder, defaultKeystoreFilename);
		char[] keystorePassword = "123456".toCharArray();
		if (!defaultKeystoreFile.exists()){
			FileOutputStream fileOuputStream = new FileOutputStream(defaultKeystoreFile);
			keystore.load(null, null);
			keystore.store(fileOuputStream, keystorePassword);
		}
		FileInputStream fileInputStream = new FileInputStream(defaultKeystoreFile);
		keystore.load(fileInputStream, keystorePassword);
		fileInputStream.close();
		if (keystore.containsAlias(aliasName)){
			System.out.println(aliasName + " already exists in the keystore." );
		}else {
			System.out.println(aliasName + " is adding to keystore" );
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			SecretKey key = keyGenerator.generateKey();
			KeyStore.SecretKeyEntry keyEntry = new KeyStore.SecretKeyEntry(key);
			keystore.setEntry(aliasName, keyEntry, new KeyStore.PasswordProtection(aliasPassword));
			FileOutputStream fileOuputStream = new FileOutputStream(defaultKeystoreFile);
			keystore.store(fileOuputStream, keystorePassword);
			fileOuputStream.close();
		}
		Key key = keystore.getKey(aliasName, aliasPassword);
		System.out.println(new String(Base64.getEncoder().encode(key.getEncoded()), StandardCharsets.UTF_8));
	}
}
