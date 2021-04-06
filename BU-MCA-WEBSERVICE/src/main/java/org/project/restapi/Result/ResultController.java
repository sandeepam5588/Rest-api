package org.project.restapi.Result;

import java.util.List;

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
@RequestMapping("/api/v1/bu/results")
public class ResultController {
	String message;
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/mca/{regno}") 
	public List<Result> getAllSemResult(@PathVariable String regno) {
		return resultService.getAllSemResult(regno);
		
	}
	@GetMapping("/mca/{regno}/{sem}")
	public Result getSemResult(@PathVariable String regno, @PathVariable String sem) {
		return (Result) resultService.getResult(regno, sem);
	}
	
	@PostMapping("/mca")
    public ResponseEntity<String> addResult(@Valid @RequestBody Result result) {
		 
		if(resultService.addResult(result)) {
			 message = "record created";
			 return new ResponseEntity<>(message, HttpStatus.CREATED);
		 }
		 message = "Duplicate Result..!" + result.getRegno() + " results already exists";
		 return new ResponseEntity<>(message, HttpStatus.CONFLICT);	 
	}
	
	
	@PutMapping("/mca/{regno}")
	public ResponseEntity<String> updateResult(@Valid @RequestBody Result result, @PathVariable String regno) {
		 if(resultService.updateResult(result, regno, result.getSemester())) {
			 message = "record updated";
			 return new ResponseEntity<>(message, HttpStatus.OK);
		 }
		 message = "record does not exist or regno in the uri and the payload must be same";
		 return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/mca/{regno}/{sem}")
	public ResponseEntity<String> deleteResult(@PathVariable String regno, @PathVariable String sem) {
		if(resultService.deleteResult(regno, sem)) {
			message = "record deleted successfully";
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		
		 message = "student result with the regno "+ regno + " does not exist..!";
		 return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	
}
