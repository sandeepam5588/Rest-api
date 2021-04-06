package org.project.restapi.department;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.project.restapi.courses.Course;

@Entity
@Table(name = "Department")
@SecondaryTable(name = "DepartmentDetails", pkJoinColumns = @PrimaryKeyJoinColumn(name = "department_id"))
public class Department {
	
	@Id
	private String id;
	
	@NotNull
	@Size(min=2, message="Department Name should have atleast 2 characters")
	@Column(name = "department_name")
	private String name;
	
	@NotNull
	@Column(name = "year", table ="DepartmentDetails")
	private int year;
	
	@NotNull
	@Column(name = "numberOfStudents", table ="DepartmentDetails")
	private int numberOfStudents;
	
	@NotNull
	@Column(name = "numberOfProfessors", table ="DepartmentDetails")
	private int numberOfProfessors;
	
	@NotNull
	@Column(name = "numberOfGuestFaculty", table ="DepartmentDetails")
	private int numberOfGuestFaculty;
	
	@NotNull
	@Column(name = "numberOfOfficeStaff", table ="DepartmentDetails")
	private int numberOfOfficeStaff;
	
	@NotNull
	@Column(name = "scheme", table ="DepartmentDetails")
	private String scheme;
	
	@OneToMany(mappedBy = "dept") // mappedBy should not refer to class name
	private List<Course> courses;
		
	public Department() {}

	
	public Department(String id, String name, int year, int numberOfStudents, int numberOfProfessors,
			int numberOfGuestFaculty, int numberOfOfficeStaff, String scheme) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.numberOfStudents = numberOfStudents;
		this.numberOfProfessors = numberOfProfessors;
		this.numberOfGuestFaculty = numberOfGuestFaculty;
		this.numberOfOfficeStaff = numberOfOfficeStaff;
		this.scheme = scheme;
	
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public int getNumberOfProfessors() {
		return numberOfProfessors;
	}

	public void setNumberOfProfessors(int numberOfProfessors) {
		this.numberOfProfessors = numberOfProfessors;
	}

	public int getNumberOfGuestFaculty() {
		return numberOfGuestFaculty;
	}

	public void setNumberOfGuestFaculty(int numberOfGuestFaculty) {
		this.numberOfGuestFaculty = numberOfGuestFaculty;
	}

	public int getNumberOfOfficeStaff() {
		return numberOfOfficeStaff;
	}

	public void setNumberOfOfficeStaff(int numberOfOfficeStaff) {
		this.numberOfOfficeStaff = numberOfOfficeStaff;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	
}