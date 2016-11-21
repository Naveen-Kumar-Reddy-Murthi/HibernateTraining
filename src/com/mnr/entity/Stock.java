package com.mnr.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "stock_seq", sequenceName = "stock_seq", initialValue = 1, allocationSize = 1)
public class Stock {
	@Id
	@Column(name = "STOCK_ID")
	@GeneratedValue(generator = "stock_seq")
	private int id;
	@Column(name = "STOCK_NAME")
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STOCK_CONSUMER_DETAILS", inverseJoinColumns = @JoinColumn(name = "CONSUMER_ID"), joinColumns = @JoinColumn(name = "STOCK_ID"))
	private List<Consumer> consumerList;

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

	public List<Consumer> getConsumerList() {
		return consumerList;
	}

	public void setConsumerList(List<Consumer> consumerList) {
		this.consumerList = consumerList;
	}

}
