package com.mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Person;

public class InsertPerson {
    public static void main( String[] args ) {
        System.out.println("Persisting......." );
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory f = cfg.buildSessionFactory();
            Session session = f.openSession();
            Transaction t = session.beginTransaction();
            Person p = new Person("Vinay Kumar", 20);
            session.save(p);
            t.commit();
            System.out.println("Persisted.");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
