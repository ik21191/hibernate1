package com.mypack.nativeSql;



import java.util.List;
import java.util.Set;

import manyToMany.bidirection.Course1;
import manyToMany.bidirection.Student1;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class NativeSql1 {
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
	         String query = "select {student.*} from student1 student where student.studentid=100";
	         SQLQuery sqlQuery = session.createSQLQuery(query);
	         sqlQuery.addEntity("student", Student1.class);
	         List<Student1> students = sqlQuery.list();
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
