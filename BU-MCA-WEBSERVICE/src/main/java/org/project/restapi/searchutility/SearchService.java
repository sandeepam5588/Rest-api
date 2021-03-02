package org.project.restapi.searchutility;

import java.util.ArrayList;
import java.util.List;

import org.project.restapi.Faculty.FacultyRepository;
import org.project.restapi.courses.CourseRepository;
import org.project.restapi.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private CourseRepository courseRepository;
	private List<Object> searchResults; 

	public List<Object> getRecordByName(String name) {
		searchResults = new ArrayList<>();
		studentRepository.findByName(name).forEach(searchResults::add);
		facultyRepository.findByName(name).forEach(searchResults::add);
		courseRepository.findByCourseName(name).forEach(searchResults::add);
		return searchResults;
	}
	public List<Object> getRecordById(String id) {
		searchResults = new ArrayList<>();
		searchResults.add((Object)studentRepository.findByRegno(id));
		//if record not found null is added
		searchResults.add((Object)facultyRepository.findById(id));
		searchResults.add((Object)courseRepository.findById(id));
		return searchResults;
	}

	
}