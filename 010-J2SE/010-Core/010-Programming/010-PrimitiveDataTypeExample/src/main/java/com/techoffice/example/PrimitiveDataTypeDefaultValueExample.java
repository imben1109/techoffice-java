package com.techoffice.example;

/**
 * This example introduce the primitive data type in Java
 * 	- int
 * 	- long
 * 	- short
 * 	- byte
 *  - double
 *  - float
 *  - char
 *  - boolean
 * 
 * @author Ben_c
 *
 */
public class PrimitiveDataTypeDefaultValueExample {
	private static int i ;			// 0
	private static long l;			// 0
	private static short s;			// 0
	private static byte b;			// 0
	private static double d;		// 0.0
	private static float f;			// 0.0
	private static char c; 			// /u0000
	private static boolean bool;	// false
	

	public static void main(String[] args){
		 System.out.println(i);
		 System.out.println(l);
		 System.out.println(s);
		 System.out.println(b);
		 System.out.println(f);
		 System.out.println(d);
		 System.out.println(c);
		 System.out.println(bool);
		 
		 // Assign Value to the primitive data type
		 i = 1;
		 l = 1;			l = 1l;
		 s = 1; 
		 b = 1;
		 d = 1;			d = 1d;
		 f = 1;			f = 1f;
		 c = 1;
		 bool = true;
		 
		 // You can observe that there are suffix for Long, Double and Float.
		 // Because the limit for integer. For the range over the limit, suffix is required to add.
		 // For Example, Long l = 6000000000 would cause compilation error. You should use Long l = 6000000000L or Long l = 6000000000l
		 // Both upper case or lower case would be used as suffix. It is better to use upper case because l is difficult to distinguish from 1  
		 l = 6000000000L;
		 f = 6000000000F;
		 d = 6000000000D;
		 
	}
}
