package com.techoffice.example;

import java.io.IOException;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class Appl {
	public static void main(String[] args) throws IOException {
		SimpleRegression regression = new SimpleRegression();
		for (int i=0; i<10; i++){
			regression.addData(i, i*2);
		}
		System.out.println("Slope: " + regression.getSlope());
		System.out.println("Mean Square Error: " + regression.getRSquare());
	}
}
