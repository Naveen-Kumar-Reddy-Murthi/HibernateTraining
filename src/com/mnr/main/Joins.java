package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.util.SessionFactoryBuilder;

public class Joins {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

	}

}
