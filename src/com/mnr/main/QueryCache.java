package com.mnr.main;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Mnr;
import com.mnr.util.SessionFactoryBuilder;

public class QueryCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery("from Mnr");
		query.setCacheable(true);
		query.setCacheMode(CacheMode.REFRESH);
		List<Mnr> mnrList = query.list();
		System.out.println("first call=" + mnrList.toString());

		List<Mnr> mnrList1 = query.list();
		System.out.println("second call=" + mnrList1.toString());

		List<Mnr> mnrList2 = query.list();
		System.out.println("third call=" + mnrList2.toString());
	}

}
