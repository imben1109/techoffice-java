package com.ittechoffice.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * This class help format Getter Value of Java Bean.
 * It only support the following return type
 * - String 
 * - Date
 * - Boolean
 * 
 * @author Ben_c
 *
 */
public class PojoHelper {
	public static void printf(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method[] methods = obj.getClass().getMethods();
		for (int i=0; i<methods.length; i++){
			Method method = methods[i];
			if (method.getName().startsWith("get") && !method.getName().equals("getClass")){
				System.out.print(method.getName().substring(3) + ": " +  method.invoke(obj));
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Test test = new Test();
		test.setName("Testing");
		PojoHelper.printf(test);
	}
}
