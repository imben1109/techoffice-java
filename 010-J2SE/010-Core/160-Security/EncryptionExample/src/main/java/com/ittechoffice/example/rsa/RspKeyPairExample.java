package com.ittechoffice.example.rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RspKeyPairExample {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeySpecException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		// Get an instance of the RSA key generator
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		// Generate the keys ¡X might take sometime on slow computers
		KeyPair myPair = kpg.generateKeyPair();
		PrivateKey privateKey = myPair.getPrivate();
		PublicKey publicKey = myPair.getPublic();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		String content = "Hello World";
	    byte[] encryptedTextBytes = cipher.doFinal(content.getBytes());
	    cipher.init(Cipher.DECRYPT_MODE, privateKey);
	    byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
	    System.out.println("Original Content: " + new String(content.getBytes()));
	    System.out.println("");
	    System.out.println("Encrypted Content: " + new String(encryptedTextBytes));
	    System.out.println("");
	    System.out.println("Decrypted Content: " + new String(decryptedTextBytes));
	    System.out.println("");

	}
}
