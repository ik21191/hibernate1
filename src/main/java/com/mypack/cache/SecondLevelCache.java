package com.mypack.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class SecondLevelCache {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();
		Person person1 = (Person)session1.get(Person.class, new Integer(2));

		System.out.println("Loaded object person name is___" + person1.getName());
		System.out.println("Object Loaded successfully.....!!");
		session1.close();

		System.out.println("------------------------------");
		System.out.println("Waiting......");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		System.out.println("3 seconds compelted......!!!!!!!!");

		Session session2 = factory.openSession();
		Person person2 = (Person)session2.get(Person.class, new Integer(2));

		System.out.println("Loaded object person name is___" + person2.getName());
		System.out.println("Object loaded from the database...!!");
		session2.close();

		Session session3 = factory.openSession();
		Transaction t = session3.beginTransaction();
		Person person3 = (Person)session3.get(Person.class, new Integer(2));
		person3.setName("XXX");
		session3.update(person3);//This will throw an exception because we have set read-only in person.hbm.xml mapping

		System.out.println("Loaded object product name is___" + person3.getName());
		System.out.println("Object loaded from global cache successfully.....!!");
		t.commit();
		session3.close();
		factory.close();
	}
}
