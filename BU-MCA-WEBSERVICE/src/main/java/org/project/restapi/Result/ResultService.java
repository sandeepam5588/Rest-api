package org.project.restapi.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
	@Autowired
	private ResultRepository resultRepository;

	public List<Result> getAllSemResult(String regno) {
		List<Result> results = new ArrayList<>();
		resultRepository.findByRegno(regno).forEach(results::add);
		return results;
	}
	
	public Object getResult(String regno, String sem) {
		Optional<Result> singleResultRecord = Optional.of(resultRepository.findByRegnoAndSemester(regno, sem));
		if(singleResultRecord.isPresent()) return singleResultRecord;
		return "record not found";
	}

	public boolean addResult(Result result) {
		try {
			if(resultRepository.findByRegnoAndSemester(result.getRegno(), result.getSemester()) == null)
				resultRepository.save(result);
			else
				throw new DataIntegrityViolationException("duplicate record");
		} catch(DataIntegrityViolationException ex) {
			return false;
		}
		return true;
	}

	public boolean updateResult(Result result, String regno, String sem) {
		Result isRecordExist = resultRepository.findByRegnoAndSemester(regno, result.getSemester());
		if(isRecordExist == null) {
			return false;
		}
		
		if(result.getRegno().equalsIgnoreCase(regno) && result.getSemester().equalsIgnoreCase(sem)) {
			resultRepository.save(result);
			return true;	
		}
		return false;
	}
	
	public boolean deleteResult(String regno, String sem) {
		try {
			resultRepository.deleteByRegnoAndSemester(regno, sem);
			} catch(EmptyResultDataAccessException ex) {
				return false;
			}
			return true;
	}
	
}
