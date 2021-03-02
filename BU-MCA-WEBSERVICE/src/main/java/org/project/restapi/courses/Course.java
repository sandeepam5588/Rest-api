package org.project.restapi.courses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	private String id;
	@Id
	private String courseName;
	private int duration;
	private String scheme;
	private int yearOfCommencement;
	private String department;
	public Course() {}
	public Course(String id, String courseName, int duration, String scheme, int yearOfCommencement, String department) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.duration = duration;
		this.scheme = scheme;
		this.yearOfCommencement = yearOfCommencement;
		this.department = department;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public int getYearOfCommencement() {
		return yearOfCommencement;
	}
	public void setYearOfCommencement(int yearOfCommencement) {
		this.yearOfCommencement = yearOfCommencement;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", duration=" + duration + ", Scheme=" + scheme
				+ ", yearOfCommencement=" + yearOfCommencement + ", department=" + department + "]";
	}
	
}
