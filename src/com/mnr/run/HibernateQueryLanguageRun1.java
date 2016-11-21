package com.mnr.run;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mnr.dto.Employee;

public class HibernateQueryLanguageRun1 {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		// Employee emp= new Employee();
		// emp=(Employee)session.get(Employee.class,new Integer(2));
		// session.getTransaction().commit();
		// Query query =session.createQuery("from Employee");
		// Query query =session.createQuery("from Employee");
		// query.setFirstResult(5);
		// query.setMaxResults(4);
		// Query query
		// =session.createQuery("select new map(id,name) from Employee");
		// Query query =session.createQuery("select max(id) from Employee");

		// Query query =session.createQuery("from Employee where id>?");
		// query.setInteger(0, 5);
		// Query query =session.createQuery("from Employee where id>:id");
		// query.setInteger("id", 5);
		// Query query
		// =session.createQuery("from Employee where id>:id and name=:name");
		// query.setInteger("id", 5);
		// query.setString("name", "EMPLOYEE 10");
		// Query query =session.getNamedQuery("Employee.byId");
		// query.setInteger(0, 5);
		// List<Employee> empList = query.list();
		// System.out.println("Named Query empList:"+empList);
		// query=session.getNamedQuery("Employee.byName");
		// query.setString(0,"EMPLOYEE 10");
		// List<Employee> empList1 = query.list();
		// System.out.println("Named Native Query empList:"+empList1);

		Criteria criteria = session.createCriteria(Employee.class);
		// criteria.add(Restrictions.eq("id", 10));

		// criteria.add(Restrictions.eq("id", 10)).
		// add(Restrictions.eq("name","EMPLOYEE 10")).
		// add(Restrictions.like("name", "EMPLOYEE 1%"));

		// criteria.add(Restrictions.or(Restrictions.between("id", 1, 5),
		// Restrictions.between("id", 6, 10)));
		Query query = session.createQuery("select id from Employee where id=1");
		List<Employee> empList1 = query.list();
		System.out.println("criteria empList:" + empList1);

		session.close();

	}

}
