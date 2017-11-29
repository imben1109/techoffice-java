package com.techoffice;

import java.awt.image.BufferedImage;
import java.net.URL;

import boofcv.alg.feature.detect.edge.CannyEdge;
import boofcv.factory.feature.detect.edge.FactoryEdgeDetectors;
import boofcv.gui.ListDisplayPanel;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.gui.image.ShowImages;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayS16;
import boofcv.struct.image.GrayU8;

public class App {
	
	public static void main(String[] args){
		
		URL url = App.class.getClassLoader().getResource("simple_objects.jpg");
		BufferedImage image = UtilImageIO.loadImage(url);
		GrayU8 gray = ConvertBufferedImage.convertFrom(image,(GrayU8)null);
		
		// Create a canny edge by image gradient
		GrayU8 edgeImage = gray.createSameShape();
		CannyEdge<GrayU8,GrayS16> canny = FactoryEdgeDetectors.canny(2, true, true, GrayU8.class, GrayS16.class);
		canny.process(gray,0.1f,0.3f,edgeImage);

		// display the results
		BufferedImage visualBinary = VisualizeBinaryData.renderBinary(edgeImage, false, null);
		ListDisplayPanel panel = new ListDisplayPanel();
		panel.addImage(visualBinary,"Binary Edges from Canny");

		ShowImages.showWindow(panel,"Canny Edge", true);
	}
}
