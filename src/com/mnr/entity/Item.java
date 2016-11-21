package com.mnr.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Item {

	private String iName;
	private double price;

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
