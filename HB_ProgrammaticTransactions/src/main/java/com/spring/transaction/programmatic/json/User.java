package com.spring.transaction.programmatic.json;

public class User {
	private int id;
	private String name;
	private int phone;

	public User() { }
	public User(String name, int phone) { 
		this.name = name;
		this.phone = phone;
	}
	public User(int id, String name, int phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String toString() {
		return id + " - " + name + " - " + phone;
	}
}
