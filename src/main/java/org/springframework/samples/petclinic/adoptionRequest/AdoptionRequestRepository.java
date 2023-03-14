package org.springframework.samples.petclinic.adoptionRequest;

import java.util.List;

import javax.persistence.Entity;


import org.springframework.data.repository.CrudRepository;


@Entity
public interface AdoptionRequestRepository extends CrudRepository<AdoptionRequest, Integer>{

    List<AdoptionRequest> findAll();

}
