package com.techoffice.example;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Appl {

	public static void main(String[] args) throws IOException{
		File imageFile = new File(Appl.class.getClassLoader().getResource("image-1x-md.jpg").getFile());
        BufferedImage image = ImageIO.read(imageFile);
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("Width: " + width + "    Height:" + height);
        
        for(int i=0; i<height; i++){
            
            for(int j=0; j<width; j++){
               Color c = new Color(image.getRGB(j, i));
               System.out.println("Red: " + c.getRed() + " Green: " + c.getGreen() + " Blue: " + c.getBlue());
            }
         }

	}
}
