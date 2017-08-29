package com.mypack.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class SecondLevelCache {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();
		Person person1 = (Person)session1.load(Person.class, new Integer(4));

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
		Person person2 = (Person)session2.load(Person.class, new Integer(4));

		System.out.println("Loaded object person name is___" + person2.getName());
		System.out.println("Object loaded from the database...!!");
		session2.close();

		Session session3 = factory.openSession();
		Person person3 = (Person)session3.load(Person.class, new Integer(4));

		System.out.println("Loaded object product name is___" + person3.getName());
		System.out.println("Object loaded from global cache successfully.....!!");
		session3.close();
		factory.close();
	}
}
