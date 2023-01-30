package edu.wccnet.emeyer.springMVC.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import edu.wccnet.emeyer.validation.CourseName;

public class Customer {
	
	@NotBlank(message = "field is required")
	@Size (min = 4, message = "name has to be at least 4 characters long")
	
	private String name;
	
	@Min(value = 18, message = "must be 18 or older")
	private int age;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{5}", message = "zipcode should be 5 digits")
	private String zipcode;
	
	@CourseName(value = "CIS")
	private String favoriteCourse;
	
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getFavoriteCourse() {
		return favoriteCourse;
	}
	public void setFavoriteCourse(String favoriteCourse) {
		this.favoriteCourse = favoriteCourse;
	}
	
	

}
