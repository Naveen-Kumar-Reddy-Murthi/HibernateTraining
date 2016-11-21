package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Mnr;
import com.mnr.util.SessionFactoryBuilder;

public class SecondLevelCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();

		Session session1 = sessionFactory.openSession();

		Mnr mnr = (Mnr) session1.get(Mnr.class, 1);
		System.out.println("session1 Mnr=" + mnr.toString());
		session1.close();

		mnr = null;

		Session session2 = sessionFactory.openSession();
		Transaction txn = session2.beginTransaction();
		mnr = (Mnr) session2.get(Mnr.class, 1);
		System.out.println("session2 Mnr=" + mnr.toString());
		// mnr.setName("mnr222");

		mnr = (Mnr) session2.get(Mnr.class, 1);
		System.out.println("session2 Mnr=" + mnr.toString());

		Mnr mnr2 = new Mnr();
		mnr2.setName("mnr3");
		session2.persist(mnr2);

		txn.commit();
		session2.close();

	}

}
