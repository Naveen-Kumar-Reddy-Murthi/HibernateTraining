package com.mnr.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mnr.entity.Student;
import com.mnr.entity.Subject;
import com.mnr.util.SessionFactoryBuilder;

public class OneToMany {

	public static void main(String[] args) {
		Subject s1 = new Subject();
		s1.setName("Subject1");

		Subject s2 = new Subject();
		s2.setName("Subject2");

		Subject s3 = new Subject();
		s3.setName("Subject3");

		Subject s4 = new Subject();
		s4.setName("Subject4");

		Subject s5 = new Subject();
		s5.setName("Subject5");

		Subject s6 = new Subject();
		s6.setName("Subject6");

		Subject s7 = new Subject();
		s7.setName("Subject7");

		Subject s8 = new Subject();
		s8.setName("Subject8");

		Subject s9 = new Subject();
		s9.setName("Subject9");

		Subject s10 = new Subject();
		s10.setName("Subject10");

		Subject s11 = new Subject();
		s11.setName("Subject11");

		Subject s12 = new Subject();
		s12.setName("Subject12");

		Set<Subject> subjects1 = new HashSet<Subject>();
		subjects1.add(s1);
		subjects1.add(s2);

		Set<Subject> subjects2 = new HashSet<Subject>();
		subjects2.add(s3);
		subjects2.add(s4);

		Set<Subject> subjects3 = new HashSet<Subject>();
		subjects3.add(s5);
		subjects3.add(s6);

		Set<Subject> subjects4 = new HashSet<Subject>();
		subjects4.add(s7);
		subjects4.add(s8);

		Set<Subject> subjects5 = new HashSet<Subject>();
		subjects5.add(s9);
		subjects5.add(s10);

		Set<Subject> subjects6 = new HashSet<Subject>();
		subjects6.add(s11);
		subjects6.add(s12);

		Student student = new Student();
		student.setName("Khal Drogo");
		student.setSubjects(subjects1);

		Student student1 = new Student();
		student1.setName("Robb Stark");
		student1.setSubjects(subjects2);

		Student student2 = new Student();
		student2.setName("John Snow");
		student2.setSubjects(subjects3);

		Student student3 = new Student();
		student3.setName("Stannis Barathion");
		student3.setSubjects(subjects4);

		Student student4 = new Student();
		student4.setName("Tyrion Lannister");
		student4.setSubjects(subjects5);

		Student student5 = new Student();
		student5.setName("Ned Stark");
		student5.setSubjects(subjects6);

		// s1.setStudent(student);
		// s2.setStudent(student);
		//
		// s3.setStudent(student1);
		// s4.setStudent(student1);

		SessionFactory sessionFactory = SessionFactoryBuilder
				.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		// session.persist(s1);
		// session.persist(s2);
		session.persist(student);
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		session.persist(student4);
		session.persist(student5);

		txn.commit();

	}

}
