package com.mnr.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TwoWheeler")
public class Bike extends Vehicle {

	private String shortHandle;
	private String cc;

	public String getShortHandle() {
		return shortHandle;
	}

	public void setShortHandle(String shortHandle) {
		this.shortHandle = shortHandle;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

}
