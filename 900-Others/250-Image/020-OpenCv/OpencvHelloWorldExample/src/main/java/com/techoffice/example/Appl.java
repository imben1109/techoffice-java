package com.techoffice.example;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class Appl {
	public static void main(String[] args){
	
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
	    System.out.println("OpenCV Mat: " + m.dump());
	}
}
