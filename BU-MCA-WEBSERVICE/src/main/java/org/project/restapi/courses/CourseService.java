package org.project.restapi.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;


	public List<Course> getAllCourses(String departmentName) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByDept(departmentName).forEach(courses::add);
		return courses;
	}

	public Object getCourse(String departmentName, String courseName) {
		Optional<Course> singleCourseRecord = Optional.of(courseRepository.findByDept(departmentName).get(0));
		if(singleCourseRecord.isPresent()) return singleCourseRecord;
		return "record not found";
	}
	
    public boolean addCourse(Course course) {
//		try {
//			if(courseRepository.findByCourseName(course.getCourseName()) == null)
//				courseRepository.save(course);
//			else
//				throw new DataIntegrityViolationException("duplicate key");
//		} catch(DataIntegrityViolationException ex) {
//			return false;
//		}
//		return true;
//	}
    	
		courseRepository.save(course);
		return true;
	}

     public boolean  updateCourse(Course course) {
		Course isRecordExist = (Course) courseRepository.findByCourseName(course.getCourseName());
		if(isRecordExist == null) {
			return false;
		}
		
		if(course.getCourseName().equalsIgnoreCase(course.getCourseName())) {
			courseRepository.save(course);
			return true;	
		}
		return false;
	}
	
 
}