package com.spring.rest.entity;

public class Stock {
	private String name;
	private double price;
	public Stock() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return name + " - " + price;
	}
}
