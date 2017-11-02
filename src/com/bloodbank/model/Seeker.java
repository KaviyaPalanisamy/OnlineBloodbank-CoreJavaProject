package com.bloodbank.model;

public class Seeker {

	private String state;
	private String city;
	private String area;
	private String bloodGroup;
	Seeker seeker;

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Seeker(String state, String city,String bloodGroup) {

		this.state = state;
		this.city = city;
		
		this.bloodGroup = bloodGroup;
	}

}
