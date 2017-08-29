package manyToMany.bidirection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class ManyToManyBidirectionTest {
	 static Session session = null;
	public static void main(String args[]) {
 		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();		
 
		Student1 student1 = new Student1();
		student1.setStudentId(100);
		student1.setStudentName("James");
		student1.setMarks(98);
 
		Student1 student2 = new Student1();
		student2.setStudentId(101);
		student2.setStudentName("Lee");
		student2.setMarks(99);
 
		Course1 course1 = new Course1();
		course1.setCourseId(500);
		course1.setCourseName("Hibernate");
		course1.setDuration(7);
 
		Course1 course2 = new Course1();
		course2.setCourseId(501);
		course2.setCourseName("Java");
		course2.setDuration(30);
 
		Set<Course1> courses = new HashSet<Course1>();
		courses.add(course1);
		courses.add(course2);
 
		student1.setCourses(courses);
		student2.setCourses(courses);
 	    //Transaction tx = session.beginTransaction();
        //session.save(student1);
        //session.save(student2);
 	    //tx.commit();
		displayStudent1();
		displayCourse1();
		session.close();
		System.out.println("\nMany To Many Bi-Directional is Done..!!");
		factory.close();
 	}
	
	public static void displayStudent1() {

	      System.out.println("Displaying Students............");
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<Student1> students = session.createQuery("FROM manyToMany.bidirection.Student1").list();
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
	
	public static void displayCourse1() {
		System.out.println("\n\nDisplaying Courses.........");
	      
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	          Query query= session.createQuery("FROM manyToMany.bidirection.Course1");
	          List<Course1> courses = query.list();
	          for (Course1 course : courses){
	            System.out.println("Course Name: " + course.getCourseName()); 
	            Set<Student1> students = course.getStudents();
	            for (Student1 student : students){
	                  System.out.println("Course: " + student.getStudentName()); 
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
