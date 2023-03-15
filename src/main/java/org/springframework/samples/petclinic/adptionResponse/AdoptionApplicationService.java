package org.springframework.samples.petclinic.adptionResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionApplicationService {


    private AdoptionApplicationRepository adoptionApplicationRepository;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationRepository br){
        this.adoptionApplicationRepository=br;
    }

    @Transactional(readOnly = true)
    public List<AdoptionApplication> getAllApplications(){
        return (List<AdoptionApplication>) adoptionApplicationRepository.findAll();
    }

      @Transactional(readOnly = true)
      public Optional<AdoptionApplication> getApplicationById(Integer id){
        return adoptionApplicationRepository.findById(id);
      }

      @Transactional(readOnly = true)
      public void deleteApplicationById(Integer id){
        adoptionApplicationRepository.deleteById(id);
      }


    
}
