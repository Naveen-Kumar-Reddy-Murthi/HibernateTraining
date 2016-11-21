package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.BookChild;
import com.mnr.util.SessionFactoryBuilder;

public class PracticalTest1 {

	public static void main(String[] args) {

		BookChild book = new BookChild();
		book.setAutherName("Naveen Reddy");
		book.setPublisherName("MNR Publications");
		book.setPrice(458.268);
		book.setiName("My Book4");

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		session.persist(book);

		tran.commit();
		session.close();

	}

}
