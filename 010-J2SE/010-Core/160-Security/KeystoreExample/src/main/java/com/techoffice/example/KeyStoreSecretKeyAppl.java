package com.techoffice.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import javax.crypto.spec.SecretKeySpec;

public class KeyStoreSecretKeyAppl {
	
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException{
		KeyStore keystore = KeyStore.getInstance("JCEKS");
		String userFolder = System.getProperty("user.home");
		String defaultKeystoreFilename = ".keystore";
		File defaultKeystoreFile = new File(userFolder, defaultKeystoreFilename);
		FileInputStream fileInputStream = new FileInputStream(defaultKeystoreFile);
		char[] keystorePassword = "123456".toCharArray();
		keystore.load(fileInputStream, keystorePassword);
		Enumeration<String> aliases = keystore.aliases();
		while(aliases.hasMoreElements()){
			System.out.println(aliases.nextElement());
		}		
		Key myKey = keystore.getKey("mykey", "1234567".toCharArray());
		if (myKey instanceof SecretKeySpec){
			SecretKeySpec mySecretKey = (SecretKeySpec) myKey;
			System.out.println(new String(mySecretKey.getEncoded()));
		}
	}
}
