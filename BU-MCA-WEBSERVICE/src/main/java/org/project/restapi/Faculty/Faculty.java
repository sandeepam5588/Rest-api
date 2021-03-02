package org.project.restapi.Faculty;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.project.restapi.model.ContactDetail;

@Entity
public class Faculty {
	@Id
	private String id;
	private String name;
	@Embedded
	private ContactDetail contact;
	private Date dateOfAppointment;
	private Date dateOfLeaving;
	public Faculty() { }
	public Faculty(String id, String name, ContactDetail contact, Date dateOfAppointment, Date dateOfLeaving) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.dateOfAppointment = dateOfAppointment;
		this.dateOfLeaving = dateOfLeaving;
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
	public ContactDetail getContact() {
		return contact;
	}
	public void setContact(ContactDetail contact) {
		this.contact = contact;
	}
	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public Date getDateOfResignation() {
		return dateOfLeaving;
	}
	public void setDateOfResignation(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", contact=" + contact + ", dateOfAppointment="
				+ dateOfAppointment + ", dateOfLeaving=" + dateOfLeaving + "]";
	}
	
}