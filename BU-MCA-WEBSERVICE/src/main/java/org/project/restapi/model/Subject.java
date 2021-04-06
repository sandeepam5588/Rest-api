package org.project.restapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Subject {
	
	
	@Column(name="subjectCode")
	private String subjectCode;
	
	@Column(name="subjectName")
	private String subjectName;
	
	@Column(name="marksObtained")
	private int marksObtained;
	
	@Column(name="status")
	private String status;
	
	public Subject() {};
		
	public Subject(String subjectCode, String subjectName, int marksObtained, String status) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
		this.status = status;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
