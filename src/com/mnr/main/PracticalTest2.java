package com.mnr.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.mnr.entity.Worker;
import com.mnr.util.SessionFactoryBuilder;

public class PracticalTest2 {

	public static void main(String[] args) {

		/*
		 * Area area = new Area(); area.setName("Noida");
		 * 
		 * Worker worker = new Worker(); worker.setName("worker2");
		 * worker.setArea(area);
		 */
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();

		Worker worker = (Worker) session.get(Worker.class, 1);

		Query query = session
				.createQuery("select worker.id, worker.name, area.name from Worker worker, Area area  where worker.area.id=area.id");

		List<Object[]> rows = query.list();

		for (Object[] row : rows) {
			System.out.println();

			int id = Integer.parseInt(row[0].toString());
			System.out.println("worker_id: " + id);
			System.out.println("worker_name:" + row[1]);
			System.out.println("area_name:" + row[2]);
			System.out.println();
		}

		session.close();

	}

}
