package org.project.restapi.department;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	private String id;
	@Id
	private String name;
	private int yearOfCommencement;
	private int numberOfStudents;
	private int numberOfProfessors;
	private int numberOfGuestFaculty;
	private int numberOfOfficeStaff;
	
	public Department() {}

	public Department(String id, String name, int yearOfCommencement, int numberOfStudents, int numberOfProfessors,
			int numberOfGuestFaculty, int numberOfOfficeStaff) {
		super();
		this.id = id;
		this.name = name;
		this.yearOfCommencement = yearOfCommencement;
		this.numberOfStudents = numberOfStudents;
		this.numberOfProfessors = numberOfProfessors;
		this.numberOfGuestFaculty = numberOfGuestFaculty;
		this.numberOfOfficeStaff = numberOfOfficeStaff;
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

	public int getYearOfCommencement() {
		return yearOfCommencement;
	}

	public void setYearOfCommencement(int yearOfCommencement) {
		this.yearOfCommencement = yearOfCommencement;
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", yearOfCommencement=" + yearOfCommencement
				+ ", numberOfStudents=" + numberOfStudents + ", numberOfProfessors=" + numberOfProfessors
				+ ", numberOfGuestFaculty=" + numberOfGuestFaculty + ", numberOfOfficeStaff=" + numberOfOfficeStaff
				+ "]";
	}
	
	
}