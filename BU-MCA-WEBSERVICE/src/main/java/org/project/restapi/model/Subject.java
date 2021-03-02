package org.project.restapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {
	private String subjectCode;
	private String subjectName;
	private int minimumMarks;
	private int maximumMarks;
	private int marksObtained;
	private String status;
	public Subject() {}
	
	
	public Subject(String subjectCode, String subjectName, int minimumMarks, int maximumMarks,
			int marksObtained, String status) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.minimumMarks = minimumMarks;
		this.maximumMarks = maximumMarks;
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
	public int getMinimumMarks() {
		return minimumMarks;
	}
	public void setMinimumMarks(int minimumMarks) {
		this.minimumMarks = minimumMarks;
	}
	public int getMaximumMarks() {
		return maximumMarks;
	}
	public void setMaximumMarks(int maximumMarks) {
		this.maximumMarks = maximumMarks;
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
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", minimumMarks=" + minimumMarks
				+ ", maximumMarks=" + maximumMarks + ", marksObtained=" + marksObtained + ", status=" + status + "]";
	}
}