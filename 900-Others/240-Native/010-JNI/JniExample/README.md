1. Create Java Class
```
package com.techoffice.example;

public class JniCaller {
	static {
		System.loadLibrary("dll/JniCaller");
	}
	
	private native void print();
	
	public static void main(String[] args){
		(new JniCaller()).print();
	}
}
```
2. User Javah -jni com.techoffice.example.JniCaller to generate com_techoffice_example_JniCaller.h

3. create com_techoffice_example_JniCaller.c 
```
#include <jni.h>
#include <stdio.h>
#include "com_techoffice_example_JniCaller.h"

JNIEXPORT void JNICALL 
Java_com_techoffice_example_JniCaller_print(JNIEnv *env, jobject obj)
{
	printf("Hello World!\n");
	return;
}
```

4. compile it to shared library

Fianlly, Java Program would call the shared library