package com.mypack.criteria;
import java.util.List;
import java.util.Set;

import manyToMany.bidirection.Course1;
import manyToMany.bidirection.Student1;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class Criteria1 {
	 static Session session = null;
	 public static void main(String args[]) {
 		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();		
 
        displayStudent1();
		session.close();
		System.out.println("\nMany To Many Bi-Directional is Done..!!");
		factory.close();
 	}
	
	public static void displayStudent1() {
		/*This method copied from ManyToManyBidirectionTest*/
		
	      System.out.println("Displaying Students............");
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         //Criteria criteria = session.createCriteria(Student1.class).add(Restrictions.eq("studentId", 101));
	         Criteria criteria = session.createCriteria(Student1.class).
	         add(Restrictions.like("studentName", "%%")).setMaxResults(1);
	         
	         List<Student1> students = criteria.list();
	         for (Student1 student : students){
	        	 System.out.println("First Name: " + student.getStudentName()); 
		         Set<Course1> cources = student.getCourses();
		         for (Course1 course : cources) {
		        	 System.out.println("Course: " + course.getCourseName()); 
		         }System.out.println();
		     }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         //session.close(); 
	      }
	   
	}
	
	
}
