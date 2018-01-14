package com.mypack.select;

import org.apache.log4j.Logger;
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
public class Select {
	private static final Logger log = Logger.getLogger(Select.class);
    public static void main( String[] args ) {
    	log.info("Fetching Person......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            Person p1 = (Person)session.load(Person.class, 10);// Assume this id is not available in DB
            
            t.commit();
            log.info(p1.getId());// Database is not hit here
            //System.out.println("ID: " + p1.getId() + " Name: " + p1.getName() + " Age " + p1.getAge());//DB hit
            
        }
        catch(Exception e) {
            log.error(e);
        }
    }
}
