package com.mnr.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mnr.entity.Student;
import com.mnr.util.SessionFactoryBuilder;

public class FetchTypesnProxyObjects {

	public static void main(String[] args) {

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();

		Student student = (Student) session.get(Student.class, 1); // if
																	// FetchType
																	// of
																	// association
																	// in
																	// Student
																	// specified
																	// as Lazy,
																	// this
																	// won't
																	// load
																	// subjects.
																	// check
																	// query
		// System.out.println(student.getSubjects().size());//this wont give
		// exception here if fetch type is lazy
		session.close();

		// System.out.println(student.getSubjects().size()); // this will give
		// exception outside session if fetch type is lazy

		System.out.println(student.getSubjects().size());// with fetch type
															// eagar

	}

}
