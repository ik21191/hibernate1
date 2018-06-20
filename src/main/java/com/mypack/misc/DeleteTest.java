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
public class DeleteTest {
    public static void main( String[] args ) {
        System.out.println("Fetching Person......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            
            //Person person = (Person)session.get(Person.class, 1);
            Person person = new Person();
            person.setId(2);
            
            
            session.delete(person);//Throws NonUniqueObjectException
            t.commit();
            session.close();
            System.out.println("Deeted.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
