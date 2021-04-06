package org.project.restapi.courses;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu")
public class CourseController {
	@Autowired
	private CourseService courseService;
	private String message;
	
	@GetMapping("/{departmentName}/courses")
	public List<Course> getCourses(@PathVariable String departmentName) {
		return courseService.getAllCourses(departmentName); 
	}
	
	@GetMapping("/{departmentName}/{courseName}")
	protected ResponseEntity<Object> getCourse(@PathVariable String departmentName, @PathVariable String courseName) {
		Object obj = courseService.getCourse(departmentName, courseName);
		if (Course.class.isInstance(obj)) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		}
		 return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/{departmentName}/courses")
	public ResponseEntity<String> addCourse(@Valid @RequestBody Course course, @PathVariable String departmentName) {
		 if(courseService.addCourse(course)) {
			 message = "record created";
			 return new ResponseEntity<>(message, HttpStatus.CREATED);
		 }
		 message = "Duplicate Key..!" + course.getCourseName() + " course already exists";
		 return new ResponseEntity<>(message, HttpStatus.CONFLICT);	 
	}
	
	
	@PutMapping("/{departmentName}/{courseName}")
	public ResponseEntity<String> updateCourse(@Valid @RequestBody Course course) {
		 if(courseService.updateCourse(course)) {
			 message = "record updated";
			 return new ResponseEntity<>(message, HttpStatus.OK);
		 }
		 message = "record does not exist or coursename in the uri and the payload must be same";
		 return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

}
