package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mnr.entity.Mnr;
import com.mnr.util.SessionFactoryBuilder;

public class EvictVsClearVsRefresh {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();

		Session session = sessionFactory.openSession();

		Mnr mnr = null;

		mnr = (Mnr) session.load(Mnr.class, 1);
		System.out.println("before evict using load=" + mnr.toString());
		session.clear();

		mnr = (Mnr) session.get(Mnr.class, 1);
		System.out.println("after evict using get=" + mnr.toString());

		session.close();

	}

}
