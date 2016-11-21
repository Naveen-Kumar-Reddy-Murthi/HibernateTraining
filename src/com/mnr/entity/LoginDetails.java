package com.mnr.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class LoginDetails {

	private String logonDate;
	private int countryId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int logonId;

	public String getLogonDate() {
		return logonDate;
	}

	public void setLogonDate(String logonDate) {
		this.logonDate = logonDate;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getLogonId() {
		return logonId;
	}

	public void setLogonId(int logonId) {
		this.logonId = logonId;
	}

}
