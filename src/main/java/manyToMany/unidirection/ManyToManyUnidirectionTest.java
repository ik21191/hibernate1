package manyToMany.unidirection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class ManyToManyUnidirectionTest {
	   private static SessionFactory factory; 
	   public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      ManyToManyUnidirectionTest ME = new ManyToManyUnidirectionTest();
	      /* Let us have a set of certificates for the first employee  */
	      HashSet<Certificate> certificates = new HashSet<Certificate>();

	      certificates.add(new Certificate("MCA"));
	      certificates.add(new Certificate("MBA"));
	      certificates.add(new Certificate("PMP"));
	     
	      /* Add employee records in the database */
	      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, certificates);

	      /* Add another employee record in the database */
	      ME.addEmployee("Dilip", "Kumar", 3000, certificates);

	      /* List down all the employees */
	      ME.listEmployees();

	      /* Update employee's salary records */
	      ME.updateEmployee(empID1, 5000);

	      /* Delete an employee from the database */
	      //ME.deleteEmployee(empID2);

	      /* List down all the employees */
	      ME.listEmployees();

	   }

	   /* Method to add an employee record in the database */
	   public Integer addEmployee(String fname, String lname, 
	                                            int salary, Set<Certificate> cert){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Student employee = new Student(fname, lname, salary);
	         employee.setCertificates(cert);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }

	   /* Method to list all the employees detail */
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<Student> students = session.createQuery("FROM manyToMany.unidirection.Student").list(); 
	         for (Student student : students ){
	            System.out.print("First Name: " + student.getFirstName()); 
	            System.out.print("  Last Name: " + student.getLastName()); 
	            System.out.println("  Salary: " + student.getSalary());
	            Set<Certificate> certificates = student.getCertificates();
	            for (Certificate certificate : certificates ) {
	                  System.out.println("Certificate: " + certificate.getName()); 
	            }
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to update salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student employee = (Student)session.get(Student.class, EmployeeID); 
	         employee.setSalary( salary );
	         session.update(employee);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to delete an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student employee = (Student)session.get(Student.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	}