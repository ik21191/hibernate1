package com.mypack.insert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class InsertPerson {
    public static void main( String[] args ) {
    	Integer identifier = 0;
        System.out.println("Persisting......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            Person p = new Person("Vijay Kumar", 83);
            p.setId(1);
            identifier = (Integer)session.save(p);
            System.out.println(identifier);
            session.flush();//This will insert the data in the DB but will not be visible, means it will synch with DB
            t.rollback();//It will roll back the data inserted into DB or synched with DB
            
            Transaction t2 = session.beginTransaction();
            Person p2 = new Person("Imran Khan", 32);
            p2.setId(1);
            identifier = (Integer)session.save(p2);
            t2.commit();
            System.out.println("Persisted.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
