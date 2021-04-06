package org.project.restapi.Result;

import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, String> {

	Result findByRegnoAndSemester(String regno, String sem);

	Iterable<Result> findByRegno(String regno);

	void deleteByRegnoAndSemester(String regno, String sem);

}
