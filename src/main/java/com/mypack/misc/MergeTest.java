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
public class MergeTest {
    public static void main( String[] args ) {
        System.out.println("Fetching Person......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            
            Person currentPerson = (Person)session.get(Person.class, 1);
            System.out.println("Before merge : " + currentPerson.getName());
            
            Person newPerson = new Person();
            newPerson.setId(1);
            newPerson.setName("Imran Khan");
            session.update(newPerson);//Throws NonUniqueObjectException
            //session.merge(currentPerson);
            t.commit();
            session.close();
            System.out.println("After merge : " + currentPerson.getName());
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
