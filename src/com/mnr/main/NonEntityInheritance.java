package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.LoginAudit;
import com.mnr.util.SessionFactoryBuilder;

public class NonEntityInheritance {

	public static void main(String[] args) {

		LoginAudit audit = new LoginAudit();
		audit.setLogonDate("08-03-2016");
		audit.setCountryId(1);
		audit.setUserId(1);

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.persist(audit);
		txn.commit();
		session.close();

	}

}
