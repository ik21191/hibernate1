package com.mypack.transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class TransactionTest1 {
	
	static Configuration cfg = null;
	static SessionFactory factory = null;
	static Session session = null;
	
	public static void save() {
		//Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Person p1 = new Person("Imran Khan", 32);
        System.out.println("Persisting......." );
        identifier = (Integer)session.save(p1);
        
        //Person p2 = new Person("Vijay Kumar", 45);
        //identifier = (Integer)session.save(p2);
        
        System.out.println("save() : " + identifier);
        try {
        	session.flush();
        	int a = 0;
        	if(a == 0) {
        		throw new Exception();
        	}
        	System.out.println("save() : " + Thread.currentThread().getName() + " is sleeping for 3 seconds");
        	Thread.currentThread().sleep(3000);
        	System.out.println("save() : " + Thread.currentThread().getName() + " is now wake up.");
		} catch (Exception e) {
			t.rollback();//This will do nothing if session.flush() is not called, means data will be inserted if any transaction is commited
			System.out.println("save() : " + Thread.currentThread().getName() + " is sleeping for 3 seconds");
			try {
				Thread.currentThread().sleep(3000);
			} catch (Exception e1) {
				System.out.println("save() : " + e1);
			}
			System.out.println("save() : " + Thread.currentThread().getName() + " is now wake up.");
			
			System.out.println("save() : " + e);
		}
        //t.commit();
        System.out.println("Persisted." );
 	}
	
	public static void load() {
		System.out.println("load() : " + "Loading..........");
		//Session session = factory.openSession();
        Transaction t2 = session.beginTransaction();
		Person p2 = (Person)session.load(Person.class, identifier);
        System.out.println("load() : " + "---------" + p2.getName());
        t2.commit();
        System.out.println("load() : Loaded.");
	}
	
	static Integer identifier = 0;
    public static void main( String[] args ) {
    	cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
        session = factory.openSession();
        try {
            Thread thread1 = new Thread(new Runnable() {
            	@Override
            	public void run() {
            		save();
            	}
            }, "Thread1");
            
            Thread thread2 = new Thread(new Runnable() {
            	@Override
            	public void run() {
            		load();
            	}
            }, "Thread2");
            
            thread1.start();
            Thread.sleep(2000);
            thread2.start();
        }
        catch(Exception e) {
            System.out.println("main() " + e);
        }
    }
}
