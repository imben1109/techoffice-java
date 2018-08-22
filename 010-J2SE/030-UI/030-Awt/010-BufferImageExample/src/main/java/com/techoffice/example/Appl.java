package com.techoffice.example;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Appl {

	public static void main(String[] args){
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(){
			public void paint(Graphics g){
				BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
				Graphics bufferedImageGraphics = bufferedImage.getGraphics();
				bufferedImageGraphics.drawString("Testing", 20,20);
				g.drawImage(bufferedImage, 20, 20, this);
			}
		};
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);

	}
	
}
