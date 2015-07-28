package com.sree.intercom.util;

public class User implements Comparable<User>{
	
	String name;
	int user_id;
	double latitude;
	double longitude;
	double distance;
	

	public User(String name, int id, double lattitude, double langitude, double distance) {
		super();
		this.name = name;
		this.user_id = id;
		this.latitude = lattitude;
		this.longitude = langitude;
		this.distance = distance;
	}
	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public double getLattitude() {
		return latitude;
	}
	public void setLattitude(double lattitude) {
		this.latitude = lattitude;
	}
	public double getLangitude() {
		return longitude;
	}
	public void setLangitude(double langitude) {
		this.longitude = langitude;
	}
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + user_id + ", lattitude=" + latitude
				+ ", langitude=" + longitude + "]";
	}

	@Override
	public int compareTo(User user) {
	        if (this.distance < user.distance) {
	            return -1;
	        } else if (this.distance > user.distance) {
	            return 1;
	        } else {
	            return 0;
	        }
	}
	
}
