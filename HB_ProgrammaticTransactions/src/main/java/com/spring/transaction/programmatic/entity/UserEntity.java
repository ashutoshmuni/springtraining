package com.spring.transaction.programmatic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int phone;

	public UserEntity() { }
	public UserEntity(String name, int phone) { 
		this.name = name;
		this.phone = phone;
	}
	public UserEntity(int id, String name, int phone) {
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
