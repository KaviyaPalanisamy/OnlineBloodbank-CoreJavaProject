package com.bloodbank.model;

public class Donar {

	private int donarId;
	private String name;
	private int age;
	private int weight;
	private String gender;
	private String bloodGroup;
	private String phoneNumber;
	private String emailId;
	private String state;
	private String city;
	private String area;
	private String password;

	Donar donar;

	public int getDonarId() {
		return donarId;
	}

	public void setDonarId(int donarId) {
		this.donarId = donarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Donar(String name, int age, int weight, String gender,
			String bloodGroup, String phoneNumber, String emailId,
			String state, String city, String area,String password) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.state = state;
		this.city = city;
		this.area = area;
		this.password = password;
	}

	

	public Donar(String state, String city,String bloodGroup) {

		this.state = state;
		this.city = city;
		
		this.bloodGroup = bloodGroup;
	}

}
