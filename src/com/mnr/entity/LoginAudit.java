package com.mnr.entity;

import javax.persistence.Entity;

@Entity
public class LoginAudit extends LoginDetails {

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
