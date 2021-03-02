package org.project.restapi.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{departmentName}")
	public Department getDepartment(@PathVariable String departmentName) {
		return departmentService.getDepartment(departmentName);
	}
	
	@PostMapping("/departments")
	public String addDepartment(@RequestBody Department dept) {
		return departmentService.addDepartment(dept);
	}
	@PutMapping("/{departmentName}")
	public String updateDepartment(@RequestBody Department dept, @PathVariable String departmentName) {
		return departmentService.updateDepartment(departmentName, dept);
	}
	@DeleteMapping( "/{departmentName}")
	public String deleteDepartment(@PathVariable String departmentName) {
		return departmentService.deleteDepartment(departmentName);
	}
	
	
}