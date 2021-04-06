package org.project.restapi.Result;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.project.restapi.model.ResultId;
import org.project.restapi.model.Subject;

@Entity
@Table(name="Result")
@IdClass(ResultId.class)
public class Result {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String resultID;
	@Id
	@NotNull
	@Size(min=5, message="register number should have atleast 3 characters")
	private String regno;
	
	@NotNull
	private String semester;
	
	@NotNull
	private String status;
	
	@NotNull
	@ElementCollection
	private List<Subject> subjects;
	
	public Result() {}

	public Result(String resultID,
			@NotNull @Size(min = 5, message = "register number should have atleast 3 characters") String regno,
			@NotNull String semester, @NotNull String status, @NotNull List<Subject> subjects) {
		super();
		this.resultID = resultID;
		this.regno = regno;
		this.semester = semester;
		this.status = status;
		this.subjects = subjects;
	}

	public String getResultID() {
		return resultID;
	}

	public void setResultID(String resultID) {
		this.resultID = resultID;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	};
	
}
