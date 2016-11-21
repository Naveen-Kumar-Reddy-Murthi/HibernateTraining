package com.mnr.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FourWheeler")
public class Car extends Vehicle {

	private String powerSteering;
	private String cc;

	public String getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(String hasSteering) {
		this.powerSteering = hasSteering;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

}
