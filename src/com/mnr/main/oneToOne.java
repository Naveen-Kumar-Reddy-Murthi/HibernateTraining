package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Employee;
import com.mnr.entity.SalaryAccount;
import com.mnr.util.SessionFactoryBuilder;

public class oneToOne {

	public static void main(String[] args) {   

		Employee emp = new Employee();
		emp.setName("Naveen");
		SalaryAccount acc = new SalaryAccount();
		acc.setAcNo(1234567896);
		emp.setSalaryAccount(acc);
		// acc.setEmployee(emp); //for bidirectional oneToOne
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		// session.persist(emp);// wrong way, this generates extra update
		// statement
		// session.persist(acc);// first persist acc the emp.
		session.persist(acc);
		session.persist(emp);

		txn.commit();
		session.close();

	}

}
