package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Loan;
import com.mnr.util.SessionFactoryBuilder;

public class Session1 {  

	public static void main(String[] args) {
		Loan loan = new Loan();   
		loan.setLoanId(3);
		loan.setLoanName("loan3");
		loan.setIsNew("N");
		loan.setTest(3);
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(loan);
		transaction.commit();
		session.close();

		sessionFactory = null;

		loan.setLoanId(4);
		loan.setLoanName("loan4");
		loan.setIsNew("Y");
		loan.setTest(4);
		SessionFactory sessionFactory1 = SessionFactoryBuilder
				.getSessionFactory();
		Session session1 = sessionFactory1.openSession();
		Transaction transaction1 = session1.beginTransaction();
		session1.persist(loan);
		transaction1.commit();
		session1.close();
		// System.out.println("sessionFactory  Hashcode:"+sessionFactory.hashCode());
		// System.out.println("sessionFactory1 Hashcode:"+sessionFactory1.hashCode());
	}

}
