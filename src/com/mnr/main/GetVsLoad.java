package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Mnr;
import com.mnr.util.SessionFactoryBuilder;

public class GetVsLoad {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();

		Session session = sessionFactory.openSession();
		Mnr mnr1 = null;
		Transaction transaction = session.beginTransaction();

		// mnr1 =(Mnr)session.load(Mnr.class, 2); //this gives exception as id 2
		// doesn't exists
		// System.out.println("session.load()="+mnr1.toString());
		//
		// mnr1=null;

		mnr1 = (Mnr) session.get(Mnr.class, 2); // this gives null as id 2
												// doesn't exists
		System.out.println("session.get()=" + mnr1.toString());

		session.close();

	}

}
