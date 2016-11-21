package com.mnr.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mnr.util.SessionFactoryBuilder;

public class HQL {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();

		// Query query =session.createQuery("from BUDto order by id desc");

		// Query query =session.createQuery("from BUDto where id=?");
		// query.setParameter(0,1);

		// Query query =session.createQuery("from BUDto where id=:id");
		// query.setParameter("id",4);

		/*
		 * Query query
		 * =session.createSQLQuery("select * from BUDto where rownum<2"
		 * );//native query List<Object[]> rows = query.list(); for (Object[]
		 * row: rows) { System.out.println(); System.out.println("id: " +
		 * row[0]); System.out.println("name: " + row[1]);
		 * System.out.println("city: " + row[2]); System.out.println(); }
		 */

		/*
		 * Query query =session.getNamedQuery("All_SELECT");
		 * query.setParameter("id", 4); System.out.println(query.list());
		 */

		/*
		 * Query query =session.getNamedQuery("All_SELECT_WOF");
		 * System.out.println(query.list());
		 */

		/*
		 * Query query =session.getNamedQuery("All_SELECT_WF");
		 * query.setParameter("id", 3); System.out.println(query.list());
		 */

		Query query = session
				.createQuery("select id,name,city from BUDto order by id desc");
		System.out.println(query.list().get(1));
		List<Object[]> rows = query.list();

		for (Object[] row : rows) {
			System.out.println();
			System.out.println("id: " + row[0]);
			System.out.println("name: " + row[1]);
			System.out.println("city: " + row[2]);
			System.out.println();
		}

	}

}
