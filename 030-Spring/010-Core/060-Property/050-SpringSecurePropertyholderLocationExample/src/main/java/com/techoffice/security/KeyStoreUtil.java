package com.techoffice.security;

import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;

import javax.crypto.spec.SecretKeySpec;

public class KeyStoreUtil {

	private static String userFolder = System.getProperty("user.home");
	private static String defaultKeystoreFilename = ".keystore";
	private static String keyStoreSecret = "123456";
	private static String keyStoreType = "JCEKS";
	private static String alias = "myKey";
	private static String aliasSecret = "1234567";
	
	public static SecretKeySpec getSecretKey(){
		try {
			KeyStore keystore = KeyStore.getInstance(keyStoreType);
			File defaultKeystoreFile = new File(userFolder, defaultKeystoreFilename);
			FileInputStream fileInputStream = new FileInputStream(defaultKeystoreFile);
			keystore.load(fileInputStream, keyStoreSecret.toCharArray());
			Key key = keystore.getKey(alias, aliasSecret.toCharArray());
			if (key instanceof SecretKeySpec){
				return (SecretKeySpec) key;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	private KeyStoreUtil(){}
}
