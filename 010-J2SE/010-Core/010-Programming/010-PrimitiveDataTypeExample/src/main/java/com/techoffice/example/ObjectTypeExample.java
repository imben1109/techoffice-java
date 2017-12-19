package com.techoffice.example;

/**
 * This example introduce wrapper class for primitive data type
 *  - int		: Integer
 *  - long		: Long
 *  - short		: Short
 *  - byte 		: Byte
 *  - float 	: Float
 *  - double	: Double 
 *  - char		: Character
 *  - boolean	: Boolean
 * 
 * The wrapper would provide additional function to primitive data type.
 * 
 * @author Ben_c
 *
 */
public class ObjectTypeExample {
	
	private static int i ;			// 0
	private static long l;			// 0
	private static short s;			// 0
	private static byte b;			// 0
	private static double d;		// 0.0
	private static float f;			// 0.0
	private static char c; 			// /u0000
	private static boolean bool;	// false
	
	public static void main(String[] args){
		i = new Integer(1);
		Integer iVal = i;
		
		l = new Long(1);
		Long lVal = l;
		
		s = new Short((short) 1);
		Short sVal = s;
		
		b = new Byte((byte) 1);
		Byte bVal = b;
		
		d = new Double(1);
		Double dVl = d;
		
		f = new Float(1);
		Float fVal = f;
		
		c = new Character('a');
		Character cVal = c;
		
		bool = new Boolean("true");
		Boolean boolVal = bool;
	}
}
