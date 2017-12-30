package com.mypack.misc;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

/*
 * 	The entity can be retrieved in 2 ways.
	load() - returns the proxy object with an identifier.
	get() - returns the complete object from database.
*/
public class UpdateTest {
    public static void main( String[] args ) {
        try {
        	System.out.println("Before update...");
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            
            Person person = new Person();
            //person.setId(1);//If identifier is set then it will try to update the object and if this id is not present in DB then will throw exception
            System.out.println(person.getName() + "  " + person.getAge());
            System.out.println("After update...");
            person.setName("Immran khan");
            person.setAge(2);
            session.saveOrUpdate(person);
            t.commit();
            session.close();
            System.out.println(person.getName() + "  " + person.getAge());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
