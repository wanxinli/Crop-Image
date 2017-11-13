package com.wanxin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "/Users/Wanxin/Desktop/hunter2.csv";
        String line = "";
        String cvsSplitBy = ",";
        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] image = line.split(cvsSplitBy);

                System.out.println("Image [name= " +image[0] + " , x=" + image[1] + ", y=" + image[2] + "]");
                i++;
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(i);

    }

}