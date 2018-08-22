package com.techoffice.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Appl {

	public static void showImage(final BufferedImage bufferedImage){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(){
			public void paint(Graphics g){
				g.drawImage(bufferedImage, 20, 20, this);
			}
		};
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
	
	public static Color convertToGrayScale(Color color){
		int greyRgb = (int) (color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() * 0.114);
		return new Color(greyRgb, greyRgb, greyRgb);
	}
	
	public static void main(String[] args) throws IOException{
		File imageFile = new File(Appl.class.getClassLoader().getResource("image-1x-md.jpg").getFile());
        BufferedImage image = ImageIO.read(imageFile);
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("Width: " + width + "    Height:" + height);
        
		for(int i=0; i<height; i++){
		    for(int j=0; j<width; j++){
		       Color c = new Color(image.getRGB(j, i));
		       Color greyColor = convertToGrayScale(c);
		       image.setRGB(j, i, greyColor.getRGB());
		    }
		 }
		showImage(image);
	}
}
