package com.techoffice.example;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.Features2d;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Appl {
	
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public static Mat getGrayMat(File imageFile){
	    Mat mat = Imgcodecs.imread(imageFile.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
	    if (mat.empty()){
	    	throw new RuntimeException("Cannot read image file: " + imageFile.getAbsolutePath());
	    }
		Mat grayMat = new Mat();
	    Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_BGR2GRAY);
	    return grayMat;
	}
	
	public static void main(String[] args){
		File imageFile = new File("home.jpg");
		Mat grayMat = getGrayMat(imageFile);
		
		// Detect Keypoint
		MatOfKeyPoint keypoints = new MatOfKeyPoint();
		FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.ORB);
		featureDetector.detect(grayMat, keypoints);

		// Draw Key Point on the original image
		Mat featuredMat = new Mat();
		Features2d.drawKeypoints(grayMat, keypoints, featuredMat);
		Imgcodecs.imwrite("feature.png", featuredMat);
		

	}
}
