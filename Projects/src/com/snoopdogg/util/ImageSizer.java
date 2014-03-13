package com.snoopdogg.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class ImageSizer {
	
	public final static Color PLAYINGCOLOR = new Color(10, 81, 2);
	
	public Dimension getSize(BufferedImage image) {
		return new Dimension(image.getMinX(),image.getMinY());
		
	}

}
