package com.techoffice.example;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Appl {
	public static void main(String[] args) throws IOException, URISyntaxException, AWTException{
//		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		Rectangle screenRect = new Rectangle(15, 52, 200, 100);
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		ImageIO.write(capture, "png", new File("test.png"));
	}
}
