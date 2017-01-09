package oneToOne;

public class BankEmployee{
	   private int id;
	   private String firstName; 
	   private String lastName;   
	   private int salary;
	   private BankEmployeeAddress bankEmployeeAddress;

	   public BankEmployee() {}
	   public BankEmployee(String fname, String lname, 
	                   int salary, BankEmployeeAddress bankEmployeeAddress ) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	      this.bankEmployeeAddress = bankEmployeeAddress;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }

	   public BankEmployeeAddress getAddress() {
	      return bankEmployeeAddress;
	   }
	   public void setAddress( BankEmployeeAddress bankEmployeeAddress ) {
	      this.bankEmployeeAddress = bankEmployeeAddress;
	   }
	}