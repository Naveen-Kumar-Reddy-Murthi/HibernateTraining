package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Bike;
import com.mnr.entity.Car;
import com.mnr.entity.Vehicle;
import com.mnr.util.SessionFactoryBuilder;

public class InheritanceAllStrategies {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("MODEL");

		Car car = new Car();
		car.setName("i20");
		car.setPowerSteering("Y");
		car.setCc("680");

		Bike bike = new Bike();
		bike.setName("FZ");
		bike.setShortHandle("Y");
		bike.setCc("220");

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		session.persist(vehicle);
		session.persist(car);
		session.persist(bike);
		txn.commit();
		session.close();
	}

}
