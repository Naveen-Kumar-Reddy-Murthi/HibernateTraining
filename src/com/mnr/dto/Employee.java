package com.mnr.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
// this helps in avoiding update stmt if object hasn't change from existing
@NamedQuery(query = "from Employee where id=?", name = "Employee.byId")
@NamedNativeQuery(query = "select * from employee where emp_name=?", resultClass = Employee.class, name = "Employee.byName")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1181736190761367667L;
	@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "SEQ_EMP")
	@Id
	@GeneratedValue(generator = "idgen", strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private int id;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "phone")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append("]");
		return builder.toString();
	}

}
