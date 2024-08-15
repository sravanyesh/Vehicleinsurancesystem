package com.insurance.model;

public class Underwriter {
	private String underwriterId;
	private String name;
	private String dateOfBirth;
	private String joiningDate;
	private String password;
	
	public Underwriter(String underwriterId, String name, String dateOfBirth, String joiningDate, String password) {
		this.underwriterId = underwriterId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
		this.password = password;
	}
	
	public Underwriter() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUnderwriterId() {
		return underwriterId;
	}
	public void setUnderwriterId(String underwriterId) {
		this.underwriterId = underwriterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
