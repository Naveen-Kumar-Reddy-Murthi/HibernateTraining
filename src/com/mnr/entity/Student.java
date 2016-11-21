package com.mnr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
@SequenceGenerator(name = "stu_seq", sequenceName = "stu_seq", initialValue = 1, allocationSize = 1)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "stu_seq")
	@Column(name = "STUDENT_ID")
	private int id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@OneToMany(/* mappedBy="student", */cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @Fetch(FetchMode.SELECT)// this fires one query per one customer to fetch
	// its subject collection
	// @Fetch(FetchMode.JOIN)// this fires only one query to fetch whole data in
	// one go.
	// @Fetch(FetchMode.SELECT) // select with batch size annotation
	// @BatchSize(size=2)
	// @Fetch(FetchMode.SUBSELECT)
	private Set<Subject> subjects;

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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subjects="
				+ subjects + "]";
	}

}
