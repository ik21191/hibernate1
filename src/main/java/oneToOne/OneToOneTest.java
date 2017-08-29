package oneToOne;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class OneToOneTest {
	   private static SessionFactory factory; 
	   public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      OneToOneTest ME = new OneToOneTest();

	      /* Let us have one address object */
	      BankEmployeeAddress address1 = ME.addAddress("Kondapur","Hyderabad","AP","532");

	      /* Add employee records in the database */
	      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, address1);

	      /* Let us have another address object */
	      BankEmployeeAddress address2 = ME.addAddress("Saharanpur","Ambehta","UP","111");
	  
	    /* Add another employee record in the database */
	      ME.addEmployee("Dilip", "Kumar", 3000, address2);

	      /* List down all the employees */
	      ME.listEmployees();

	      /* Update employee's salary records */
	      ME.updateEmployee(empID1, 5000);

	      /* List down all the employees */
	      ME.listEmployees();

	   }

	   /* Method to add an address record in the database */
	   public BankEmployeeAddress addAddress(String street, String city, 
	                             String state, String zipcode) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer addressID = null;
	      BankEmployeeAddress address = null;
	      try{
	         tx = session.beginTransaction();
	         address = new BankEmployeeAddress(street, city, state, zipcode);
	         addressID = (Integer) session.save(address); 
	         System.out.println(addressID);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return address;
	   }

	   /* Method to add an employee record in the database */
	   public Integer addEmployee(String fname, String lname, 
	                              int salary, BankEmployeeAddress address){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         BankEmployee employee = new BankEmployee(fname, lname, salary, address);
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
	         List<BankEmployee> bankEmployees = session.createQuery("FROM oneToOne.BankEmployee").list(); 
	         for (BankEmployee bankEmployee : bankEmployees){
	             
	            System.out.print("First Name: " + bankEmployee.getFirstName()); 
	            System.out.print("  Last Name: " + bankEmployee.getLastName()); 
	            System.out.println("  Salary: " + bankEmployee.getSalary());
	            BankEmployeeAddress add = bankEmployee.getAddress();
	            System.out.println("Address ");
	            System.out.println("\tStreet: " +  add.getStreet());
	            System.out.println("\tCity: " + add.getCity());
	            System.out.println("\tState: " + add.getState());
	            System.out.println("\tZipcode: " + add.getZipcode());
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
	         BankEmployee employee = (BankEmployee)session.get(BankEmployee.class, EmployeeID); 
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
	}