package com.mnr.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Consumer;
import com.mnr.entity.Stock;
import com.mnr.util.SessionFactoryBuilder;

public class ManyToMany {

	public static void main(String[] args) {
		Consumer consumer1 = new Consumer();
		consumer1.setName("Tyrion");
		Consumer consumer2 = new Consumer();
		consumer2.setName("John Snow");

		List<Consumer> consumers = new ArrayList<Consumer>();
		consumers.add(consumer1);
		consumers.add(consumer2);

		Stock stock1 = new Stock();
		stock1.setName("nucleus");

		Stock stock2 = new Stock();
		stock2.setName("infosys");

		Set<Stock> stocks = new HashSet<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);

		consumer1.setStocks(stocks);
		consumer2.setStocks(stocks);

		stock1.setConsumerList(consumers);
		stock2.setConsumerList(consumers);

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.persist(consumer1);
		session.persist(consumer2);
		txn.commit();
		session.close();

	}
}
