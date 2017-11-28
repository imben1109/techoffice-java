package com.techoffice.example;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Appl {
	
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public static Mat convertGrayMat(Mat mat){
		Mat grayMat = new Mat();
	    Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_BGR2GRAY);
	    return grayMat;
	}
	
	public static Mat cornerHarris(Mat grayMat){
		  int blockSize = 2;
		  int apertureSize = 3;
		  double k = 0.04;
		  
		  Mat cornerMat = new Mat();
		  Imgproc.cornerHarris(grayMat, cornerMat, blockSize, apertureSize, k);

		  return cornerMat;
	}
	
	public static Mat normalize(Mat mat){
		  Mat normalizedMat = new Mat();
		  Core.normalize(mat, normalizedMat, 0, 255, Core.NORM_MINMAX);
		  
		  Mat absMat = new Mat();
		  Core.convertScaleAbs(normalizedMat, absMat);
		  return absMat;
	}
	
	public static void main(String[] args){
		File imageFile = new File("home.jpg");
	    Mat m = Imgcodecs.imread(imageFile.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
	    if (m.empty()){
	    	throw new RuntimeException("Cannot read image file: " + imageFile.getAbsolutePath());
	    }
		
		Mat grayMat = convertGrayMat(m);
	    Imgcodecs.imwrite("gray.png", grayMat);
	    
	    Mat cornerMat = cornerHarris(grayMat);
	    Imgcodecs.imwrite("corner.png", cornerMat);
	    
	    Mat normalizedCornerMat = normalize(cornerMat);
	    Imgcodecs.imwrite("normalized_corner.png", normalizedCornerMat);

	    for (int j=0; j<normalizedCornerMat.rows(); j++){
	    	for (int i=0; i<normalizedCornerMat.cols(); i++){
	    		int value = (int) normalizedCornerMat.get(j, i)[0];
	    		if (value > 200){
	    			Imgproc.circle(m, new Point(i,j), 5, new Scalar(255, 0, 0));
	    		}
	    	}
	    }
	    
	    Imgcodecs.imwrite("result.png", m);

	}
}
