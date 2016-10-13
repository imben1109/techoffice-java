package com.ittechoffice.example.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Sha512HashingExample {
	
	public Sha512HashingExample() throws NoSuchAlgorithmException, NoSuchProviderException{
		Security.addProvider(new BouncyCastleProvider());

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digestedData = md.digest("Hello World".getBytes());
        System.out.println(digestedData.hashCode());
        
        MessageDigest md2 = MessageDigest.getInstance("SHA512");
        byte[] digestedData2 = md2.digest("Hello World".getBytes());
        System.out.println(digestedData2.hashCode());
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException{
		new Sha512HashingExample();
	}
}
