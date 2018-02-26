package com.techoffice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static final Properties properties = new Properties();
	
	private static String keystoreType                  ;
	private static String keystorePath                  ;
	private static String keystoreName                  ;
	private static String keystoreAlias                 ;
	private static String keystoreSecret                ;
	private static char[] keystoreSecretCharArray       ;
	private static String keystoreAliasSecret           ;
	private static char[] keystoreAliasSecretCharArray  ;
	private static String keygeneratorAlgorithm         ; 
	
	static {
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(ConfigConstant.propertiesFileName);
		
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		keystoreType          = properties.getProperty(ConfigConstant.keystoreType         , "");
		keystorePath          = properties.getProperty(ConfigConstant.keystorePath         , "");
		keystoreName          = properties.getProperty(ConfigConstant.keystoreName         , "");
		keystoreAlias         = properties.getProperty(ConfigConstant.keystoreAlias        , "");
		keystoreSecret        = properties.getProperty(ConfigConstant.keystoreSecret       , "");
		keystoreAliasSecret   = properties.getProperty(ConfigConstant.keystoreAliasSecret  , "");
		keygeneratorAlgorithm = properties.getProperty(ConfigConstant.keygeneratorAlgorithm, "");
		
		if ("./".equals(keystorePath)){
			keystorePath = "";
		}
		
		keystoreSecretCharArray        = keystoreSecret.toCharArray();
		keystoreAliasSecretCharArray   = keystoreAliasSecret.toCharArray(); 
	}

	public static Properties getProperties() {
		return properties;
	}

	public static String getKeystoreType() {
		return keystoreType;
	}

	public static String getKeystorePath() {
		return keystorePath;
	}

	public static String getKeystoreName() {
		return keystoreName;
	}

	public static String getKeystoreAlias() {
		return keystoreAlias;
	}

	public static String getKeystoreSecret() {
		return keystoreSecret;
	}

	public static String getKeystoreAliasSecret() {
		return keystoreAliasSecret;
	}
	
	public static String getKeygeneratorAlgorithm(){
		return keygeneratorAlgorithm;
	}

	public static char[] getKeystoreSecretCharArray() {
		return keystoreSecretCharArray;
	}

	public static char[] getKeystoreAliasSecretCharArray() {
		return keystoreAliasSecretCharArray;
	}
	
	
}
