package com.techoffice.example;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CipherAppl {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{
		SecretKey secretKey = KeyGenerator.getInstance("DESede").generateKey();
	    Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    byte[] encryptText = cipher.doFinal("This is a testing".getBytes());
	    System.out.println("======");
	    System.out.println("Encrypted Text: ");
	    System.out.println("======");
	    System.out.println(new String(encryptText));

	    cipher.init(Cipher.DECRYPT_MODE, secretKey);
	    byte[] decryptText = cipher.doFinal(encryptText);
	    System.out.println("======");
	    System.out.println("Decrypted Text:");
	    System.out.println("======");
	    System.out.println(new String(decryptText));
	}
}
