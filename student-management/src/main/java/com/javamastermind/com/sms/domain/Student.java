package com.javamastermind.com.sms.domain;

import java.util.Set;

public class Student {

	private String firstName;
	private String LastName;
	private String age;
	private String city;
	private String height;
	private String weight;
	private Set<Hobby> hobbySet;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Set<Hobby> getHobbySet() {
		return hobbySet;
	}

	public void setHobbySet(Set<Hobby> hobbySet) {
		this.hobbySet = hobbySet;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", LastName=" + LastName + ", age=" + age + ", city=" + city
				+ ", height=" + height + ", weight=" + weight + ", hobbySet=" + hobbySet + "]";
	}

}
