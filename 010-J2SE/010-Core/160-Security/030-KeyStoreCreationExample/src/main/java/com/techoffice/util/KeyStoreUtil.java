package com.techoffice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.techoffice.config.Config;

public class KeyStoreUtil {
	
	public static SecretKeySpec getSecretKey(){
		KeyStore keystore = getKeystore();
		if (keystore != null){
			try {
				Key key = keystore.getKey(Config.getKeystoreAlias(), Config.getKeystoreAliasSecretCharArray());
				if (key instanceof SecretKeySpec){
					return (SecretKeySpec) key;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	public static KeyStore getKeystore(){
		String keystoreName = Config.getKeystoreName();
		
		File keystoreFile = null;
		if (Config.getKeystorePath() == null || Config.getKeystorePath().equals("")){
			keystoreFile = new File(keystoreName);	
		}else {
			keystoreFile = new File(Config.getKeystorePath(), keystoreName);
		}
		
		if (!keystoreFile.exists()){
			System.err.println("Keystore does not exist on " + keystoreFile.getAbsolutePath());
			return null;
		}
		
		KeyStore keystore = null;;
		try {
			keystore = KeyStore.getInstance(Config.getKeystoreType());
		} catch (KeyStoreException e) {
			e.printStackTrace();
			return null;
		}

		try {
			FileInputStream fileInputStream = new FileInputStream(keystoreFile);
			keystore.load(fileInputStream, Config.getKeystoreSecretCharArray());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return keystore;
	}
	
	public static void createKeystore(){
		try {
			KeyStore keystore = KeyStore.getInstance(Config.getKeystoreType());
			String keystoreName = Config.getKeystoreName();
			
			File keystoreFile = null;
			if (Config.getKeystorePath() == null || Config.getKeystorePath().equals("")){
				keystoreFile = new File(keystoreName);	
			}else {
				keystoreFile = new File(Config.getKeystorePath(), keystoreName);
			}
			
			if (!keystoreFile.exists()){
				System.out.println(keystoreName + " is generating on " + keystoreFile.getAbsolutePath());
				
				FileOutputStream fileOutputStream = new FileOutputStream(keystoreFile);
				keystore.load(null, null);
				KeyGenerator keyGenerator = KeyGenerator.getInstance(Config.getKeygeneratorAlgorithm());
				SecretKey SecretKey = keyGenerator.generateKey();
				KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(SecretKey);
				keystore.setEntry(Config.getKeystoreAlias(), secretKeyEntry, new KeyStore.PasswordProtection(Config.getKeystoreAliasSecretCharArray()));
				keystore.store(fileOutputStream, Config.getKeystoreSecretCharArray());
			}else {
				System.out.println("KeyStore alredy exits in " + keystoreFile.getAbsolutePath());
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

}
