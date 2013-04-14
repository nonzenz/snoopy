package com.uvalimised.data;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 3236806654582706267L;
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	public boolean isCandidate;
	private boolean hasVoted = false;
	private boolean isValid;
	private String email;
	
	public User(){}
	
	public User(String fn, String ln, String email){
		this.lastName = ln;
		this.firstName = fn;
		this.email = email;
	}
	
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
	public boolean getHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	public boolean getIsCandidate() {
		return isCandidate;
	}
	public void setIsCandidate(boolean isCandidate) {
		this.isCandidate = isCandidate;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
