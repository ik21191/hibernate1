package oneToMany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class OneToMany {
	   private static SessionFactory factory; 
	   public static void main(String[] args) {
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      OneToMany ME = new OneToMany();
	      
	      System.out.println("Getting emp: start");
	      ME.getEmployee(9);
	      System.out.println("Getting emp: end");
	    
	      /* Let us have a set of certificates for the first employee  */
	      HashSet<Certificate> set1 = new HashSet<>();
	      set1.add(new Certificate("MCA"));
	      set1.add(new Certificate("MBA"));
	      set1.add(new Certificate("PMP"));
	     
	      /* Add employee records in the database */
	      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);

	      /* Another set of certificates for the second employee  */
	      HashSet<Certificate> set2 = new HashSet<>();
	      set2.add(new Certificate("BCA"));
	      set2.add(new Certificate("BA"));

	      /* Add another employee record in the database */
	      ME.addEmployee("Dilip", "Kumar", 3000, set2);

	      /* List down all the employees */
	      ME.listEmployees();

	      /* Update employee's salary records */
	      //ME.updateEmployee(empID1, 5000);

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
	         Employee employee = new Employee(fname, lname, salary);
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

	   public void getEmployee(int id) {

		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         
		         Employee emp = (Employee)session.load(Employee.class, id);
		         
		         System.out.println("Emp id: " + emp.getId() + ", EmpName: " + emp.getFirstName());
		         
		         Set<Certificate> certificates = emp.getCertificates();
		            for (Certificate certificate : certificates) {
		                  System.out.println("Certificate: " + certificate.getName()); 
		            }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   
	   }
	   
	   /* Method to list all the employees detail */
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<Employee> employees = session.createQuery("FROM oneToMany.Employee").list(); 
	         for (Employee employee : employees){
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary());
	            Set<Certificate> certificates = employee.getCertificates();
	            for (Certificate certificate : certificates) {
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
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
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
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
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
