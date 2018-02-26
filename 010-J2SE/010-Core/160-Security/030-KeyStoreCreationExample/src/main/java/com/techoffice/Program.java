package com.techoffice;

import com.techoffice.util.CipherUtil;
import com.techoffice.util.KeyStoreUtil;

public class Program {

	public static void main(String[] args){
		KeyStoreUtil.createKeystore();
		String encryptedStr = CipherUtil.encrypt("testing");
		System.out.println(encryptedStr);
		String decryptedStr = CipherUtil.decrypt(encryptedStr);
		System.out.println(decryptedStr);
	}
	
}
