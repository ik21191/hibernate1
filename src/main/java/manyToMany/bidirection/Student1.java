package manyToMany.bidirection;

import java.util.Set;

public class Student1 {
	 
	private int studentId;
	private String studentName;
	private int marks;
 
	private Set<Course1> courses;
 
	public int getStudentId() {
		return studentId;
	}
 
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
 
	public String getStudentName() {
		return studentName;
	}
 
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
 
	public int getMarks() {
		return marks;
	}
 
	public void setMarks(int marks) {
		this.marks = marks;
	}
 
	public Set<Course1> getCourses() {
		return courses;
	}
 
	public void setCourses(Set<Course1> courses) {
		this.courses = courses;
	}
 
}