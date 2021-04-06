package org.project.restapi.Faculty;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu/computerscience/mca")
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	private String message;
	
	@GetMapping("/faculty")
	protected List<Faculty> getAllFaculty(HttpServletResponse response) {
		List<Faculty> facultyResource = new ArrayList<>();
		facultyResource = facultyService.getAllFaculty();
	    response.addIntHeader("Total-Records", facultyResource.size());
	    return facultyResource;
	}
	
	@GetMapping("/faculty/{id}")
	protected ResponseEntity<Object> getFacultyResources(@PathVariable String id) {
		Object obj = facultyService.getFaculty(id);
		if (Faculty.class.isInstance(obj)) {
			return new ResponseEntity<>(obj, HttpStatus.FOUND);
		}
		 return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/faculty")
	public ResponseEntity<String> addFaculty(@Valid @RequestBody Faculty faculty) {
		 if(facultyService.addFaculty(faculty)) {
			 message = "record created";
			 return new ResponseEntity<>(message, HttpStatus.CREATED);
		 }
		 message = "Duplicate Key..!" + faculty.getId() + " ID already exists";
		 return new ResponseEntity<>(message, HttpStatus.CONFLICT);	 
	}
	
	
	@PutMapping("/faculty/{id}")
	public ResponseEntity<String> updateFaculty(@Valid @RequestBody Faculty faculty, @PathVariable String id) {
		 if(facultyService.updateFaculty(faculty, id)) {
			 message = "record updated";
			 return new ResponseEntity<>(message, HttpStatus.OK);
		 }
		 message = "record does not exist or ID in the uri and the payload must be same";
		 return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/faculty/{id}")
	public ResponseEntity<String> deleteFaculty(@PathVariable String id) {
		if(facultyService.deleteFaculty(id)) {
			message = "record deleted successfully";
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		
		 message = "faculty record with the ID "+ id + " does not exist..!";
		 return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}
