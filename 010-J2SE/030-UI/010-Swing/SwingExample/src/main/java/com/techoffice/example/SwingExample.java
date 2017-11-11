package com.techoffice.example;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This is a Hello World Example for Swing. 
 * 
 * Top-level containers: JFrame, JDialog and JApplet. 
 * @author Ben_c
 *
 */
public class SwingExample {
	public static void main(String[] args){
		// Construct The JFrame Container for Swing
        JFrame frame = new JFrame("Tech Office Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 260);
        
        // Create a Swing Label and add it into Swing Container 
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        
        // Set the Container Visible and resize the Container.
        frame.setVisible(true);
        frame.pack();

	}
}
