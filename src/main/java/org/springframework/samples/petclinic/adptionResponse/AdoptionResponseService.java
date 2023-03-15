package org.springframework.samples.petclinic.adptionResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionResponseService {


    private AdoptionResponseRepository adoptionApplicationRepository;

    @Autowired
    public AdoptionResponseService(AdoptionResponseRepository br){
        this.adoptionApplicationRepository=br;
    }

    @Transactional(readOnly = true)
    public List<AdoptionResponse> getAllApplications(){
        return (List<AdoptionResponse>) adoptionApplicationRepository.findAll();
    }

      @Transactional(readOnly = true)
      public Optional<AdoptionResponse> getApplicationById(Integer id){
        return adoptionApplicationRepository.findById(id);
      }

      @Transactional(readOnly = true)
      public void deleteApplicationById(Integer id){
        adoptionApplicationRepository.deleteById(id);
      }


    
}
