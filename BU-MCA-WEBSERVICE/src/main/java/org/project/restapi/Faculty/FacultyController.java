package org.project.restapi.Faculty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu/computerscience/mca")
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping("/faculty")
	public List<Faculty> getAllFaculty() {
		return facultyService.getAllFaculty();
	}
	
	@RequestMapping("/faculty/{id}")
	public Optional<Faculty> getFaculty(@PathVariable String id) {
		return facultyService.getFaculty(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "/faculty")
	public String addFaculty(@RequestBody Faculty faculty) {
		return facultyService.addFaculty(faculty);
	}
	@PutMapping("/faculty/{id}")
	//@RequestMapping(method = RequestMethod.PUT, value="/faculty/{id}")
	public String updateFaculty(@RequestBody Faculty faculty, @PathVariable String id) {
		return facultyService.updateFaculty(faculty, id);
	}
	
	@DeleteMapping("/faculty/{id}")
	//@RequestMapping(method = RequestMethod.DELETE, value="/faculty/{id}")
	public String deleteFaculty(@PathVariable String id) {
		return facultyService.deleteFaculty(id);
	}

}
