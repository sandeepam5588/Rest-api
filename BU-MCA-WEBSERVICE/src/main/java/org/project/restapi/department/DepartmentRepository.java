package org.project.restapi.department;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, String> {

	Department findByName(String departmentName);

	void deleteByName(String name);

}
