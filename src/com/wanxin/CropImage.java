package com.wanxin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CropImage {

	public static void main(String[] args) {
		String csvFile = "/Users/Wanxin/Documents/Java_workspace/CropImage/Resources/hunter2.csv";
		String line = "";
		String cvsSplitBy = ",";
		int i = 1;

		//read CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				
				// use comma as separator
				String[] image = line.split(cvsSplitBy);
				String input_addr = "/Users/Wanxin/Documents/Java_workspace/CropImage/Resources/m49_images/" + image[0];
				String output_addr = "/Users/Wanxin/Documents/Java_workspace/CropImage/Resources/results/" + i + "-" + image[0];

				int x = (int) Float.parseFloat(image[1]) - 100;
				if (x < 0) {
					x = 0;
				}
				if (x > (1280 - 200)) {
					x = (1280 - 200);
				}
				int y = (int) Float.parseFloat(image[2]) - 100;
				if (y < 0) {
					y = 0;
				}
				if (y > (960 - 200)) {
					y = (960 - 200);
				}
				
				//Crop
				try {
					BufferedImage originalImgage = ImageIO.read(new File(input_addr));
					BufferedImage SubImgage = originalImgage.getSubimage(x, y, 200, 200);

					File outputfile = new File(output_addr);
					ImageIO.write(SubImgage, "jpg", outputfile);

					originalImgage.flush();
					SubImgage.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Image " + i + " is cropped successfully!");
				i++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nTotal cropped image numbers: "+ (i-1));

	}

}
