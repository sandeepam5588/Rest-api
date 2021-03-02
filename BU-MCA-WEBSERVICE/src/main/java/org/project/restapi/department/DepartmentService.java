package org.project.restapi.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
    public List<Department> getAllDepartments() {
    	List<Department> depts = new ArrayList<>();
    	departmentRepository.findAll().forEach(depts::add);
    	return depts;
    }

	public Department getDepartment(String departmentName) {
		return departmentRepository.findByName(departmentName);
	}

	public String addDepartment(Department dept) {
		if(departmentRepository.findByName(dept.getName()) != null) {
			return dept.getName() + " record already exist...!";
		}
		departmentRepository.save(dept);
		return "record added successfully";
	}

	public String updateDepartment(String departmentName, Department dept) {
		if(dept.getName().equalsIgnoreCase(departmentName)) {
			departmentRepository.save(dept);
			return "record updated successfully";
		}
		return "department name cant be altered";
	}

	public String deleteDepartment(String id) {
		try {
		departmentRepository.deleteById(id);
		}catch(EmptyResultDataAccessException | InvalidDataAccessApiUsageException ex) {
			return "record does not exist..!";
		}
		return "record deleted successfully";
	}
	
	
}
