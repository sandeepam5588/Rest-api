package org.project.restapi.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.project.restapi.department.Department;

@Entity
public class Course {
	
	@Id
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String courseName;
	
	@NotNull
	private int duration;
	
	@NotNull
	private int yearOfCommencement;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department dept; 
	
	public Course() {}
	
	public Course(String courseName, int duration, int yearOfCommencement) {
		super();
		this.courseName = courseName;
		this.duration = duration;
		this.yearOfCommencement = yearOfCommencement;
		
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
	public int getYearOfCommencement() {
		return yearOfCommencement;
	}
	public void setYearOfCommencement(int yearOfCommencement) {
		this.yearOfCommencement = yearOfCommencement;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	
}
