package org.project.restapi.student;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@NotNull
	private String regno;
	
	@NotNull
	@Size(min=3, message="Name should have atleast 3 characters")
	private String name;
	
	@NotNull
	@Size(min=2, message="course name should have atleast 2 characters")
	private String course;
	
	@NotNull
	@Past
	@Basic
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public Student() { }
	
	

	public Student(@NotNull String regno,
			@NotNull @Size(min = 3, message = "Name should have atleast 3 characters") String name,
			@NotNull @Size(min = 2, message = "course name should have atleast 2 characters") String course,
			@NotNull @Past Date dateOfBirth) {
		super();
		this.regno = regno;
		this.name = name;
		this.course = course;
		this.dateOfBirth = dateOfBirth;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
