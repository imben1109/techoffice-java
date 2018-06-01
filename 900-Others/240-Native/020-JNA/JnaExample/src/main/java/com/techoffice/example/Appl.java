package com.techoffice.example;

public class Appl {

	public static void main(String[] args){
        for (int i=0;i < args.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }

	}
}
