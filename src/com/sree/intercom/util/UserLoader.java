package com.sree.intercom.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Using org.json library
 * @author I310383
 *
 */
public class UserLoader {
	
	/**
	 * Loads to user data from the data corpus to memory
	 * Load only the user whose distance comes within the distance limit
	 * @return
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	public static List<User> LoadUserData(float distanceLimit, String unit, String dumpFile) throws JsonSyntaxException, IOException{

		List<User> desiredUsers = new ArrayList<User>();
		
		URL url = new URL(dumpFile);
		InputStream is = url.openStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
				
		while ((line = br.readLine()) != null) {
		User user = new Gson().fromJson(line, User.class);
		float distance = getGreatCircleDistance(user, unit);
		user.setDistance(distance);
		if(distanceLimit >= distance)
			desiredUsers.add(user);
		}
		return desiredUsers;
	}

	/**
	 * To find the great circle distance for the given Latitude and Longitude values
	 * @param user User details
	 * @param unit Distance unit
	 * @return	returns the distance of the user from the given location 53.3381985 -6.2592576
	 */
	private static float getGreatCircleDistance(User user, String unit) {
	        double x1 = Math.toRadians(Double.parseDouble(Constants.SOURCE_LATITUDE));
	        double y1 = Math.toRadians(Double.parseDouble(Constants.SOURCE_LONGITUDE));
	        double x2 = Math.toRadians(user.getLattitude());
	        double y2 = Math.toRadians(user.getLangitude());

	        double angle = Math.acos(Math.sin(x1) * Math.sin(x2)
	                      + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

	        angle = Math.toDegrees(angle);

	        // each degree on a great circle of Earth is 60 nautical miles
	        double distance = 60 * angle;
	        
	        // distance in kilo meters : 1nm = 1.852km
	        distance = distance * 1.852;
	        return (float)distance;
	}
	
}
