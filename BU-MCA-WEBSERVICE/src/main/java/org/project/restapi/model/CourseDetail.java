package org.project.restapi.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.project.restapi.department.Department;

@Entity
public class CourseDetail {
	@Id
	private String courseName;
	private String scheme;
	private String duration;
	 @ManyToOne()
	// @JoinColumn(name = "department_name")
	private Department dept;
	
	public CourseDetail() {}

	public CourseDetail(String courseName, String scheme, String duration) {
		super();
		this.courseName = courseName;
		this.scheme = scheme;
		this.duration = duration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}