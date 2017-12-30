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
public class TwoObjectInSession {
    public static void main( String[] args ) {
        System.out.println("Fetching Person......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            
            Person currentPerson = (Person)session.load(Person.class, 2);
            System.out.println("Before merge : " + currentPerson.getName());
            t.commit();
            session.close();
            
            Session session2 = f.openSession();
            Transaction t2 = session2.beginTransaction();
            Person newPerson = (Person)session2.load(Person.class, 2);
            newPerson.setName("Imran Khan");
            session2.update(currentPerson);//Throws NonUniqueObjectException
            //session.merge(newPerson);
            t2.commit();
            session2.close();
            System.out.println("After merge : " + currentPerson.getName());
            System.out.println(currentPerson.hashCode() == newPerson.hashCode());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
