package manyToMany.bidirection;

import java.util.Set;

public class Course1 {
	 
	private int courseId;
	private String courseName;
	private int duration;
 
	private Set<Student1> students;
 
	public int getCourseId() {
		return courseId;
	}
 
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
 
	public String getCourseName() {
		return courseName;
	}
 
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
 
	public int getDuration() {
		return duration;
	}
 
	public void setDuration(int duration) {
		this.duration = duration;
	}
 
	public Set<Student1> getStudents() {
		return students;
	}
 
	public void setStudents(Set<Student1> students) {
		this.students = students;
	}	
 
}
