package com.bloodbank.model;

public class BloodBank {

	private int id;
	private String name;
	private String address;
	private String pincode;
	private String state;
	private String city;
	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BloodBank(String name, String address, String pincode, String state,
			String city, String phoneNumber) {

		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	public BloodBank(int id, String name, String address, String pincode,
			String state, String city, String phoneNumber) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

}
