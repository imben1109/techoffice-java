package com.techoffice.example;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

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
		Mat mat = getGrayMat(new File("lena.jpg"));
		File haarcascadeFrontalFaceDefaultXml = new File("haarcascade_frontalface_default.xml");
		File harrcascadeEyeXml = new File("haarcascade_eye.xml");
		
		CascadeClassifier faceCascade = new CascadeClassifier(haarcascadeFrontalFaceDefaultXml.getAbsolutePath());
		CascadeClassifier eyeCascade = new CascadeClassifier(harrcascadeEyeXml.getAbsolutePath());
		
		// Detect face
		MatOfRect faces = new MatOfRect();
		faceCascade.detectMultiScale(mat, faces);								
		for (Rect rect : faces.toArray()) {
			Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 100, 0),3);
		}
		
		// Detect Eye
		MatOfRect eyes = new MatOfRect();
		eyeCascade.detectMultiScale(mat, eyes);
		for (Rect rect: eyes.toArray()){
			Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 100, 0),3);
		}

		// Write Image with detected face and eye
		Imgcodecs.imwrite("face.png", mat);

	}
}
