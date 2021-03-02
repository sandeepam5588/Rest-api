package org.project.restapi.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;


	public List<Course> getAllCourses(String departmentName) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByDepartment(departmentName).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String departmentName, String courseName) {
		return courseRepository.findByDepartment(departmentName).get(0);
		
	}

	public String addCourse(Course course) {
		 courseRepository.save(course);
		 return "Record addes successfully";
	}

	public String updateCourse(Course course) {
		courseRepository.save(course);
		return "Record updated successfully";
	}
	
 
}