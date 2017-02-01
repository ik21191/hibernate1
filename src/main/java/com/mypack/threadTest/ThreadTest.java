package com.mypack.threadTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import beans.Person;

public class ThreadTest implements Runnable {
	static Configuration cfg = null;
	static SessionFactory factory = null;
	public void run() {
		save();
	}
	public static void save() {
		try {
			Thread.sleep(3000);
			System.out.println("Persisting.......");
			System.out.println(Thread.currentThread().getName());
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			Person p = new Person("Vinay Kumar", 20);
			session.save(p);
			t.commit();
			session.close();
			System.out.println("Persisted.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
		Thread t1 = new Thread(new ThreadTest(), "Thread1");
		t1.start();
		
		Thread t2 = new Thread(new ThreadTest(), "Thread2");
		t2.start();
		
		Thread t3 = new Thread(new ThreadTest(), "Thread3");
		t3.start();
		
		Thread t4 = new Thread(new ThreadTest(), "Thread4");
		t4.start();
		
		Thread t5 = new Thread(new ThreadTest(), "Thread5");
		t5.start();
		
		Thread t6 = new Thread(new ThreadTest(), "Thread6");
		t6.start();
		
		Thread t7 = new Thread(new ThreadTest(), "Thread7");
		t7.start();
		
		Thread t8 = new Thread(new ThreadTest(), "Thread8");
		t8.start();
	}
}
