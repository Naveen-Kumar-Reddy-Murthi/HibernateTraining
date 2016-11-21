package com.mnr.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Address;
import com.mnr.entity.Customer;
import com.mnr.util.SessionFactoryBuilder;

public class Session2 {

	public static void main(String[] args) {
		Address address = new Address();
		address.setCity("Noida");
		address.setCountry("India");
		Address address1 = new Address();
		address1.setCity("Chicago");
		address1.setCountry("USA");
		Customer cust = new Customer();
		// cust.setId(1);
		cust.setName("Naveen");
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		addressList.add(address1);
		cust.setAddressList(addressList);

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.persist(cust);
		tran.commit();
		session.close();
	}

}
