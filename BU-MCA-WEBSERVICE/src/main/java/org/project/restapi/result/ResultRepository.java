package org.project.restapi.result;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ResultRepository extends CrudRepository<Result, String>{

	@Query("FROM Result r WHERE r.regno = :regno AND r.semester = :sem")
    List<Result> findByRegnoAndSemester(@Param("regno") String regno, @Param("sem") String sem);
	@Query("FROM Result r WHERE r.regno = :regno")
	List<Result> findAllByRegno(@Param("regno") String regno);
	
	@Query("FROM Result r WHERE r.academicYear = :academicYear AND r.semester = :sem")
	List<Result> findAllByAcademicYearAndSemester(String academicYear, String sem);
}
