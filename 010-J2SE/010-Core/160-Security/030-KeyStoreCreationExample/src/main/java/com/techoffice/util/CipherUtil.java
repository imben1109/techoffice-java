package com.techoffice.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtil {

	private static final Charset CHARSET_ENCODING = StandardCharsets.UTF_8;
	
	public static String encrypt(String text){
		SecretKeySpec secretKey = KeyStoreUtil.getSecretKey();
		if (secretKey != null){
			try {
				Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] ciperText = cipher.doFinal(text.getBytes());
				byte[] encodedCiperText = Base64.getEncoder().encode(ciperText);
				return new String(encodedCiperText, CHARSET_ENCODING);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return null;
	}
	
	public static String decrypt(String text){
		SecretKeySpec secretKey = KeyStoreUtil.getSecretKey();
		if (secretKey != null){
			try {
				Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				byte[] decodedCiperText = Base64.getDecoder().decode(text.getBytes(CHARSET_ENCODING));
				byte[] ciperText = cipher.doFinal(decodedCiperText);
				return new String(ciperText, CHARSET_ENCODING);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
