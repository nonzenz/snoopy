package com.uvalimised.data;

/*
 * Candidate Bean object, that defines properties of the Candidate.
 * @Author: Robert Väljur
 */
public class Candidate implements java.io.Serializable{

	private static final long serialVersionUID = 3236806654582706267L;
	private Long candidate_id;
	private String firstName;
	private String lastName;
	private String party;
	private String location;
	private boolean hasVoted = false;
	
	public Candidate (String firstName, String lastName, String party, String location){
		this.firstName = firstName;
		this.lastName = lastName;
		this.party = party;
		this.location = location;
	}
	
	public Candidate(){}
	
	public Long getId(){
		return candidate_id;
	}
	
	public void setId(Long id){
		this.candidate_id = id;
	}
	
	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String fname){
		this.firstName = fname;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lname){
		this.lastName = lname;
	}
	
	public String getParty(){
		return party;
	}
	
	public void setParty(String party){
		this.party = party;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	
	public boolean getHasVoted(){
		return hasVoted;
	}
	
	public void setHasVoted(boolean voted){
		this.hasVoted = voted;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		Candidate other = (Candidate)otherObject;
		if(other.getId() == this.candidate_id) {
			return true;
		} else {
			return false;
		}
	}
}


