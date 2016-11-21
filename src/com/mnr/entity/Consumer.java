package com.mnr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONSUMER")
@SequenceGenerator(name = "con_seq", sequenceName = "con_seq", initialValue = 1, allocationSize = 1)
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "con_seq")
	@Column(name = "CONSUMER_ID")
	private int id;
	@Column(name = "CONSUMER_NAME")
	private String name;
	@ManyToMany(cascade = CascadeType.ALL/* ,mappedBy="consumerList" */)
	// mappedBy won't let create table owned by consumer i.e., primary keyed.
	// @JoinTable(name="CONSUMER_STOCK_DETAILS", these can't be active if
	// mappedBy is specified
	// inverseJoinColumns=@JoinColumn(name="STOCK_ID"),
	// joinColumns=@JoinColumn(name="CONSUMER_ID"))
	private Set<Stock> stocks;

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

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}
