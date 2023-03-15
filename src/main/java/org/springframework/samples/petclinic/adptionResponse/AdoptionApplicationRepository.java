package org.springframework.samples.petclinic.adptionResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionApplicationRepository extends CrudRepository <AdoptionApplication,Integer>{
    
}
