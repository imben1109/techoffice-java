package com.techoffice.example;

import java.math.BigDecimal;

public class Demo {

	public static void main(String[] args){
		Double a1 = 2.0;
		Double a2 = 1.1;
		System.out.println("Double Calculation");
		System.out.println(a1 - a2);
		
		BigDecimal b1 = BigDecimal.valueOf(2.0);
		BigDecimal b2 = BigDecimal.valueOf(1.1);
		System.out.println("Big Decimal Calculation");
		System.out.println(b1.subtract(b2));
	}
	
}
