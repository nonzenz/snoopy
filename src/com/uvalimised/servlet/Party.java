package com.uvalimised.servlet;

public class Party {

	private Integer id_party;
	private String name;
	private Long votes;

	public Party() {

	}

	public Party(int id, String name) {
		super();
		this.id_party = id;
		this.name = name;
	}

	public Party(String name, long vote) {
		super();
		this.name = name;
		this.votes = vote;
	}
}