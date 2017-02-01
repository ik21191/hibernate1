package com.mypack.hql;

import java.util.List;
import java.util.Set;

import manyToMany.bidirection.Course1;
import manyToMany.bidirection.Student1;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class Update {
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
	         String selectQuery = "FROM manyToMany.bidirection.Student1 student where student.studentId=100";
	         String updateQuery = "update manyToMany.bidirection.Student1 student set student.studentName = :name where " +
      		"student.studentId = :id";
	         Query query = session.createQuery(updateQuery);
	         query.setString("name", "Vinay Kumar");
	         query.setInteger("id", 100);
	         int recordsUpdated = query.executeUpdate();
	         if(recordsUpdated > 0) {
	        	 System.out.println("Records updated.");
	         } else {
	        	 System.out.println("Not updated.");
	         }
	         
	         List<Student1> students = session.createQuery(selectQuery).list();
	         for (Student1 student : students){
	            System.out.println("First Name: " + student.getStudentName()); 
	            Set<Course1> cources = student.getCourses();
	            for (Course1 course : cources){
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
