package com.ui.pojo;

public class User {

	public User(String emailAddress, String passwrod) {
		super();
		this.emailAddress = emailAddress;
		this.passwrod = passwrod;
	}

	private String emailAddress;
	private String passwrod ;
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", passwrod=" + passwrod + "]";
	}
	
}
