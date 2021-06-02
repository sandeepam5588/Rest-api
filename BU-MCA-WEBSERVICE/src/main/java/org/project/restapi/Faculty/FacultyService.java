package org.project.restapi.Faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Object getFaculty(String id) {
		Optional<Faculty> singleFacultyRecord = facultyRepository.findById(id);
		if(singleFacultyRecord.isPresent()) return singleFacultyRecord;
		return "record not found";
	}

//	public boolean addFaculty(Faculty faculty) {
//		try {
//			if(facultyRepository.findById(faculty.getId()) == null)
//				facultyRepository.save(faculty);
//			else
//				throw new DataIntegrityViolationException("duplicate key");
//		} catch(DataIntegrityViolationException ex) {
//			return false;
//		}
//		return true;
//	}
	public boolean addFaculty(Faculty faculty) {
				facultyRepository.save(faculty);
				return true;
	}

	public boolean updateFaculty(Faculty faculty, String id) {
		Optional<Faculty> isRecordExist = facultyRepository.findById(id);
		if(isRecordExist == null) {
			return false;
		}
		
		if(faculty.getId().equalsIgnoreCase(id)) {
			facultyRepository.save(faculty);
			return true;	
		}
		return false;
		
	}

	public boolean deleteFaculty(String id) {
		try {
			facultyRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			return false;
		}
		return true;
		
	}
	
	

}