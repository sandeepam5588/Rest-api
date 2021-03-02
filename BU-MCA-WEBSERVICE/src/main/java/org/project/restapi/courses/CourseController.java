package org.project.restapi.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{departmentName}/courses")
	public List<Course> getCourses(@PathVariable String departmentName) {
		return courseService.getAllCourses(departmentName); 
	}
	
	@GetMapping("/{departmentName}/{courseName}")
	public Course getCourse(@PathVariable String departmentName, @PathVariable String courseName) {
		return courseService.getCourse(departmentName, courseName);
	}
	@PostMapping("/{departmentName}/courses")
	public String addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	@PutMapping("/{departmentName}/{courseName}")
	public String updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	

}
