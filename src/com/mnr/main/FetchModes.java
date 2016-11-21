package com.mnr.main;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mnr.entity.Student;
import com.mnr.entity.Subject;
import com.mnr.util.SessionFactoryBuilder;

public class FetchModes {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		Set<Subject> subjects = null;
		for (Student std : students) {
			System.out.println("Student Name:" + std.getName() + "\t Subjects:"
					+ std.getSubjects());
		}

		session.close();
	}

}
