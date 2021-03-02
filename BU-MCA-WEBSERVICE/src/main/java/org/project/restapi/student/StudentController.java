package org.project.restapi.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	private String message;

	@GetMapping("/api/v1/bu/mca/students")
	protected List<Student> getAllStudents(HttpServletResponse response) {
		List<Student> studentResouce = new ArrayList<>();
	    studentResouce = studentService.getAllStudents();
	    response.addIntHeader("Total-Records", studentResouce.size());
	    return studentResouce;
	}
	
	@GetMapping("/api/v1/bu/mca/students/{id}")
	protected ResponseEntity<Object> getStudentResources(@PathVariable String id) {
		Object obj = studentService.getStudent(id);
		if (Student.class.isInstance(obj)) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		}
		 return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/api/v1/bu/mca/students")
	public ResponseEntity<String> addNewStudent(@Valid @RequestBody Student student) {
		 if(studentService.addStudent(student)) {
			 message = "record created";
			 return new ResponseEntity<>(message, HttpStatus.CREATED);
		 }
		 message = "Duplicate Key..!" + student.getRegno() + " Regno already exists";
		 return new ResponseEntity<>(message, HttpStatus.CONFLICT);	 
	}
	
	@PutMapping("/api/v1/bu/mca/students/{regno}")
	public ResponseEntity<String> updateStudent(@Valid @RequestBody Student student, @PathVariable String regno) {
		 if(studentService.updateStudent(regno, student)) {
			 message = "record updated";
			 return new ResponseEntity<>(message, HttpStatus.OK);
		 }
		 message = "record does not exist or regno in the uri and the payload must be same";
		 return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/api/v1/bu/mca/students/{regno}")
	public ResponseEntity<String> deleteStudent(@PathVariable String regno) {
		if(studentService.deleteStudent(regno)) {
			message = "record deleted successfully";
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		
		 message = "student record with the regno "+ regno + " does not exist..!";
		 return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	

}