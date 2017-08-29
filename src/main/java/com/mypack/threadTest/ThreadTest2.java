package com.mypack.threadTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class ThreadTest2 {
	static Configuration cfg = null;
	static SessionFactory f = null;
	static Session session = null;
	static Transaction t = null;
	public static void main(String[] args) {
		cfg = new Configuration().configure();
        f = cfg.buildSessionFactory();
        session = f.openSession();
        System.out.println("Fetching Person......." );
        try {
             final Person person1 = new Person();
             person1.setId(2);
             person1.setName("PPP");
             person1.setAge(12);
             final Person person2 = new Person();
             person2.setId(3);
             person2.setName("QQQ");
             person2.setAge(12);
             Thread t1 = new Thread(new Runnable(){
            	 @Override
            	 public void run() {
            		 System.out.println("Saving.........");
                     updatePerson(person1);
                     System.out.println("Saved.");
            	} 
             }, "T1");
             Thread t2 = new Thread(new Runnable(){
            	 @Override
            	 public void run() {
            		 System.out.println("Saving.........");
                     updatePerson(person2);
                     System.out.println("Saved.");
            	} 
             }, "T2");
             t1.start();
             t2.start();
             
        }
        catch(Exception e) {
            System.out.println(e);
        }
    
	}
	
	public static void updatePerson(Person person) {
		t = session.beginTransaction();
		try {
			session.update(person);
			Thread.sleep(3000);
		}catch(HibernateException e) {
			System.out.println("Some exceptions occured, rolling back...");
			t.rollback();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        t.commit();
	}

}
