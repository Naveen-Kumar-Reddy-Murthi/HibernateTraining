package com.mnr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
@SequenceGenerator(name = "sub_seq", sequenceName = "sub_seq", initialValue = 1, allocationSize = 1)
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sub_seq")
	private int id;
	private String name;

	// @ManyToOne // Bi-directional in oneToMany becomes ManyToOne
	// private Student student;

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
