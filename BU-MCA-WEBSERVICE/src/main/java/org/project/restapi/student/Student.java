package org.project.restapi.student;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	private String semester;
	
	@NotNull
	@Past
	@Basic
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@NotNull
	@Min(19)
	@Max(99)
	private int age;
	
	@NotNull
	@Past
	@Basic
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	private Date dateOfLeaving;
	
	public Student() { }
	
	public Student(String regno, String name, String course, String semester, Date dateOfBirth, int age,
			Date dateOfJoining, Date dateOfLeaving) {
		super();
		this.regno = regno;
		this.name = name;
		this.course = course;
		this.semester = semester;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.dateOfLeaving = dateOfLeaving;
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
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	@Override
	public String toString() {
		return "Student [regno=" + regno + ", name=" + name + ", course=" + course + ", semester=" + semester
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfLeaving=" + dateOfLeaving + "]";
	}
}
