package com.techoffice.example;

/**
 * This is an Example of bitwise operators including &, |, ^, ~, <<, >>, >>>
 * @author Ben_c
 *
 */
public class Demo {
	public static void main(String[] args){
	      int a = 60;	/* 60 = 0011 1100 */
	      int b = 13;	/* 13 = 0000 1101 */

	      System.out.println("a & b = " + (a & b) ); // 0000 1100 -> 12
	      System.out.println("a & b = " + (a | b) ); // 0011 1101 -> 61
	      
	      System.out.println("a ^ b = " + (a | b) ); // 0011 0001 -> 49
	      
	      System.out.println("a ~ b = " + (~a) ); // 1100 0011  
	}
}
