package com.mnr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "sal_seq", sequenceName = "sal_seq", initialValue = 1, allocationSize = 1)
public class SalaryAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sal_seq")
	@Column(name = "ACCOUNT_ID")
	private int id;
	@Column(name = "ACCOUNT_NO")
	private int acNo;

	// @OneToOne // bi-directional
	// @JoinColumn(name="EMP_ID")
	// private Employee employee; //for bidirectional oneToOne
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcNo() {
		return acNo;
	}

	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}

	/*
	 * public Employee getEmployee() {//for bidirectional oneToOne return
	 * employee; } public void setEmployee(Employee employee) { this.employee =
	 * employee; }
	 */
	@Override
	public String toString() {
		return "SalaryAcount [id=" + id + ", acNo=" + acNo + "]";
	}

}
