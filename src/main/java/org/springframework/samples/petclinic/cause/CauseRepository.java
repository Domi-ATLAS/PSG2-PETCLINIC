package org.springframework.samples.petclinic.cause;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseRepository extends CrudRepository<Cause, Integer>{

	@Query("select c from Cause c")
	List<Cause> findAll();
	
	Cause findById(int id) throws DataAccessException;

    
}
