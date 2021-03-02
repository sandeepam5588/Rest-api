package org.project.restapi.result;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
	@Autowired
	private ResultRepository resultRepository;


	public List<Result> getResult(String regno, String sem) {
		return resultRepository.findByRegnoAndSemester(regno, sem);
	}

	public String addResult(Result result) {
		resultRepository.save(result);
		return "record added successfully";
	}

	public String updateResult(Result result) {
		resultRepository.save(result);
		return "record updated successfully";
	}
	public List<Result> getResultByRegno(String regno) {
		return resultRepository.findAllByRegno(regno);
	}

	public List<Result> getResultByAcademicYearAndSemester(String academicYear, String sem) {
		return resultRepository.findAllByAcademicYearAndSemester(academicYear, sem);
	}
}
