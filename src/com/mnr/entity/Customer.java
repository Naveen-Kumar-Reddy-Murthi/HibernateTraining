package com.mnr.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity(name = "CUSTOMER")
@SequenceGenerator(name = "nav_seq", sequenceName = "nav_seq", allocationSize = 1)
// if sequenceName="cust_seq" is not defined it will work as normal
// strategy=GenerationType.AUTO
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nav_seq")
	@Column(name = "CUST_ID")
	private int id;
	@Column(name = "CUST_NAME")
	private String name;
	@ElementCollection
	@CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "CUST_ID"))
	private List<Address> addressList;

	/*
	 * @Embedded
	 * 
	 * @AttributeOverrides({// This annotation can override embeded object's
	 * properties
	 * 
	 * @AttributeOverride(name="city",column=@Column(name="CITY_NAME")),
	 * 
	 * @AttributeOverride(name="country",column=@Column(name="COUNTRY_NAME")) })
	 * private Address address;
	 */

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	/*
	 * public Address getAddress() { return address; } public void
	 * setAddress(Address address) { this.address = address; }
	 */
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

}
