package com.mnr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BookChild extends Item {

	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "item_seq")
	private int itemId;
	private String autherName;
	private String publisherName;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
