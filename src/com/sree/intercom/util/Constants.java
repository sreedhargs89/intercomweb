package com.sree.intercom.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	public static String SOURCE_LATITUDE;
	public static String SOURCE_LONGITUDE;
	
	public static String USER_DATA_SOURCE_FILE;
	public static float COVERAGE_DISTANCE;
	public static String DISTANCE_UNIT;
	
	static{
		Properties prop = new Properties();
    	InputStream input = null;
 
    	try {
 
    		String filename = "config.prop";
    		input = Constants.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		}
 
    		prop.load(input);
    		SOURCE_LATITUDE = prop.getProperty("source_latitude");
    		SOURCE_LONGITUDE = prop.getProperty("source_longtude");
    		USER_DATA_SOURCE_FILE= prop.getProperty("user_data_dump");
    		COVERAGE_DISTANCE = Float.parseFloat(prop.getProperty("coverage_distance"));
    		DISTANCE_UNIT = prop.getProperty("distance_unit");

 	} catch (IOException ex) {
 		ex.printStackTrace();
     } finally{
     	if(input!=null){
     		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
     	}
     }
		
	}
}
