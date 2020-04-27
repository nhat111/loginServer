package com.javacode.request;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.javacode.model.Gender;

public class SignupForm {
	

	@Size(min = 3,max = 20)
        @Pattern(regexp="^[a-zA-Z0-9_]+$")
	private String userName;

	@Pattern(regexp = "(?=.*?[~`!@#$%^&*()-+]).{8,}")
	private String password;
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
	
	private Date birthDay;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
