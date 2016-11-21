package com.mnr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
// this annotation is mandotory for enabling second level cache|| Allows inserts
// but not updates
// READ_ONLY option throws java.lang.UnsupportedOperationException: Can't write
// to a readonly object if cached object ever get modified
// @Cache(usage=CacheConcurrencyStrategy.NONE)// NONE- Second level cache is
// disabled
// @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)// allows both
// read and write but one at a time, chance of dirty read and no lock is
// maintained on entity but asynchronous i.e., only updated after transaction is
// completed
// @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)// Read-Write always soft
// locks an entity and allows both r/w simultaneously. So any simultaneous
// access is sent to the database | asynchronous i.e., only updated after
// transaction is completed |
// @Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)//is synchronous and is
// updated within the transaction.
public class Mnr {
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mnr [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

}
