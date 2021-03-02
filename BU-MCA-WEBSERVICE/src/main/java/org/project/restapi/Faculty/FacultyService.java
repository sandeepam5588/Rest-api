package org.project.restapi.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;

	public List<Faculty> getAllFaculty() {
		List<Faculty> totalStaff = new ArrayList<>();
		facultyRepository.findAll().forEach(totalStaff::add);
		return totalStaff;
	}

	public Optional<Faculty> getFaculty(String id) {
		return facultyRepository.findById(id);
	}

	public String addFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
		return "record created successfully";
	}

	public String updateFaculty(Faculty faculty, String id) {
		facultyRepository.save(faculty);
		return "record updated successfully";
	}

	public String deleteFaculty(String id) {
		try {
			facultyRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			return "record does not exist..!";
		}
		return "record deleted successfully";
		
	}
	
	

}