package com.uvalimised.data;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 3236806654582706267L;
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	public boolean valid;
	private boolean hasVoted = false;
	
	public User(){}
	
	public User(String fn, String ln, String un, String pw, boolean voted){
		this.lastName = ln;
		this.firstName = fn;
		this.username = un;
		this.password = pw;
		this.hasVoted = voted;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
