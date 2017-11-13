package com.wanxin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCropper {

	public static void main(String[] args) {
		try {
			BufferedImage originalImgage = ImageIO.read(new File("/Users/Wanxin/Downloads/m49_images/frame000001_1436665298_727733.jpg"));
			
	//		System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());

			BufferedImage SubImgage = originalImgage.getSubimage(282, 109, 200, 200);
	//		System.out.println("Cropped Image Dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

			File outputfile = new File("/Users/Wanxin/Desktop/results/croppedImage.jpg");
			ImageIO.write(SubImgage, "jpg", outputfile);

			originalImgage.flush();
			SubImgage.flush();
	//		System.out.println("Image cropped successfully: "+outputfile.getPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
