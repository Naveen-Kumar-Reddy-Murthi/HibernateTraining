package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Mnr;
import com.mnr.util.SessionFactoryBuilder;

public class SaveVsPersist {

	public static void main(String[] args) {

		Mnr mnr1 = new Mnr();
		Mnr mnr2 = new Mnr();

		mnr1.setName("Naveen");

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.persist(mnr1);
		transaction.commit();

		mnr1 = null;
		mnr1 = (Mnr) session.get(Mnr.class, 1);
		mnr1.setName("omg");
		session.persist(mnr1);
		session.close();

		// Session session1 = sessionFactory.openSession();
		//
		// Transaction transaction1 = session1.beginTransaction();
		// mnr1.setName("shit");
		// session1.save(mnr1);
		// transaction1.commit();
		//
		// session1.close();

	}

}
