package org.project.restapi.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		List<Student> studentResouce = new ArrayList<>();
		studentRepository.findAll().forEach(studentResouce::add);
		return studentResouce;
	}
	
	
	public Object getStudent(String regno) {
		Optional<Student> singleStudentRecord = studentRepository.findById(regno);
		if(singleStudentRecord.isPresent()) return singleStudentRecord;
		return "record not found";
	}
	
	public boolean addStudent(Student student) {
		try {
			if(studentRepository.findByRegno(student.getRegno()) == null)
		       studentRepository.save(student);
			else
				throw new DataIntegrityViolationException("duplicate key");
		} catch(DataIntegrityViolationException ex) {
			return false;
		}
		return true;
	}
	public boolean updateStudent(String regno, Student student) {
		Student isRecordExist = studentRepository.findByRegno(regno);
		if(isRecordExist == null) {
			return false;
		}
		
		if(student.getRegno().equalsIgnoreCase(regno)) {
			studentRepository.save(student);
			return true;	
		}
		return false;
		
	}
	public boolean deleteStudent(String regno) {
		try {
		studentRepository.deleteById(regno);
		} catch(EmptyResultDataAccessException ex) {
			return false;
		}
		return true;
	}

	
}
