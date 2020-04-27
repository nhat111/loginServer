package com.javacode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "register")
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_name")
	 @NonNull
	@Size(min = 3, max = 20)
        @Pattern(regexp="^[a-zA-Z0-9_]+$")
	private String userName;

	@Column(name = "password")
	@Pattern(regexp = "(?=.*?[~`!@#$%^&*()-+]).{8,}")
	private String password;

	@Column(name = "first_name")
	@NonNull
	private String firstName;

	@Column(name = "last_name")
	@NonNull
	private String lastName;

	@Column(name = "birth_day")
	private Date birthDay;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	@NonNull
	private Gender gender;

	@Column(name = "address")
	private String address;

	public Register(String userName, String password, String firstName, String lastName, Date birthDay, Gender gender,
			String address) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.address = address;
	}

	public Register(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Register() {
	}

	

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
