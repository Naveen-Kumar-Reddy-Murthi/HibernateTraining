package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.BUDto;
import com.mnr.util.SessionFactoryBuilder;

public class CRUDops {

	public static void main(String[] args) {

		BUDto bu1 = new BUDto();
		bu1.setName("GCC");
		bu1.setCity("Noida");

		BUDto bu2 = new BUDto();
		bu2.setName("GMAC");
		bu2.setCity("Hyderabad");

		BUDto bu3 = new BUDto();
		bu3.setName("NPD");
		bu3.setCity("Delhi");

		BUDto bu4 = new BUDto();
		bu4.setName("BDG");
		bu4.setCity("Jaipur");

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		session.persist(bu1);
		session.persist(bu2);
		session.persist(bu3);
		session.persist(bu4);

		/*
		 * BUDto bu =(BUDto)session.get(BUDto.class, 1); System.out.println(bu);
		 * bu.setName("GCC BU3"); session.persist(bu);
		 */

		txn.commit();
		session.close();

	}

}
