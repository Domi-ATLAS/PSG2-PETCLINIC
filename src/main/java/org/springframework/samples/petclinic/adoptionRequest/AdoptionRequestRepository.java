package org.springframework.samples.petclinic.adoptionRequest;

import java.util.List;

import javax.persistence.Entity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdoptionRequestRepository extends CrudRepository<AdoptionRequest, Integer>{

    List<AdoptionRequest> findAll();

}
