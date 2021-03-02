package org.project.restapi.Faculty;


import org.springframework.data.repository.CrudRepository;

public interface FacultyRepository extends CrudRepository<Faculty, String>{

	Iterable<Object> findByName(String name);

	Iterable<Object> findAllById(String id);


}
