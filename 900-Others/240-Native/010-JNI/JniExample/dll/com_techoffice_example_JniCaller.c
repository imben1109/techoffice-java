#include <jni.h>
#include <stdio.h>
#include "com_techoffice_example_JniCaller.h"

JNIEXPORT void JNICALL 
Java_com_techoffice_example_JniCaller_print(JNIEnv *env, jobject obj)
{
	printf("Hello World!\n");
	return;
}
