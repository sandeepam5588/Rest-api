package org.project.restapi.result;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bu")
public class ResultController {
	@Autowired
	private ResultService resultService;
	/**
	 * 
	 * 1. based on regno no sem
	 * 2. based on regno and given sem
	 * 3. based on year and sem(all records)
	 */
	
	//1. based on regno no semester
	@GetMapping("/results/mca/regno/{regno}")
	public List<Result> getAllSemResult(@PathVariable String regno) {
		return resultService.getResultByRegno(regno);
	}
	
	//2. based on regno and given sem
	@GetMapping("/results/mca/{regno}")
	public List<Result> getResult(@PathVariable String regno, @RequestParam(value = "sem") String sem) {
		return resultService.getResult(regno, sem);
	}
	//3. based on year and sem(all records)
	@GetMapping("/results/mca/yearAndSem")
	public List<Result> getAllSemResult(@RequestParam(value = "academicYear") String academicYear,@RequestParam(value = "sem") String sem) {
	    return resultService.getResultByAcademicYearAndSemester(academicYear, sem);
	}
	
	@PostMapping("/results/mca")
	public String addResult(@RequestBody Result result) {
		return resultService.addResult(result);
	}
	@PutMapping("/results/mca/{regno}")
	public String updateResult(@RequestBody Result result) {
		return resultService.updateResult(result);
	}

}
