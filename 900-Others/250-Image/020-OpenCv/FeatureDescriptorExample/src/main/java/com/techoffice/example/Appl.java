package com.techoffice.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.DMatch;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
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
		// Image 1
		File imageFile1 = new File("box.png");
		Mat grayMat1 = getGrayMat(imageFile1);
		
		FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.ORB);
		DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.ORB);
		
		// Detect Keypoint
		MatOfKeyPoint keypoints1 = new MatOfKeyPoint();
		featureDetector.detect(grayMat1, keypoints1);

		// Draw Key Point on the original image
		Mat featuredMat1 = new Mat();
		Features2d.drawKeypoints(grayMat1, keypoints1, featuredMat1);
		Imgcodecs.imwrite("feature.png", featuredMat1);
		
		Mat descriptors1 = new Mat();
		descriptorExtractor.compute(grayMat1, keypoints1, descriptors1);
		
		
		// Image 2
		File imageFile2 = new File("box_in_scene.png");
		Mat grayMat2 = getGrayMat(imageFile2);
		
		MatOfKeyPoint keypoints2 = new MatOfKeyPoint();
		featureDetector.detect(grayMat2, keypoints2);
		
		Mat descriptors2 = new Mat();
		descriptorExtractor.compute(grayMat2, keypoints2, descriptors2);
		
		// Matching
        MatOfDMatch matches = new MatOfDMatch();
		DescriptorMatcher descriptorMatcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE);
		descriptorMatcher.match(descriptors1, descriptors1, matches);
		
//		Mat found = new Mat();
//		Features2d.drawMatches(grayMat1, keypoints1, grayMat2, keypoints2, matches, found);
//		Imgcodecs.imwrite("match.png", found);

		// 
		List<DMatch> matchesList = matches.toList();
        List<DMatch> bestMatchesList = new ArrayList<DMatch>();
        MatOfDMatch bestMatches = new MatOfDMatch();

        for (int i = 0; i < matchesList.size(); i++) {
            float dist =  matchesList.get(i).distance;
            if(dist != 0 ){
            	System.out.println(dist);
            	bestMatchesList.add(matchesList.get(i));
            }

        }
        bestMatches.fromList(bestMatchesList);
        
		Mat filtered = new Mat();
		Features2d.drawMatches(grayMat1, keypoints1, grayMat2, keypoints2, bestMatches, filtered);
		Imgcodecs.imwrite("filter.png", filtered);
	}
}
