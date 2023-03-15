package org.springframework.samples.petclinic.adoptionRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionRequestService {

    private AdoptionRequestRepository adoptionRequestRepository;

    @Autowired
    public AdoptionRequestService(AdoptionRequestRepository repo){
        this.adoptionRequestRepository = repo;
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> getAll(){
        return adoptionRequestRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AdoptionRequest> getById(Integer id){
        return adoptionRequestRepository.findById(id);
    }
    
    @Transactional
    public void deleteAdoptionRequest(AdoptionRequest ar){
        adoptionRequestRepository.delete(ar);
    }

    @Transactional
    public void saveAdoptionRequest(AdoptionRequest ar){
        adoptionRequestRepository.save(ar);
    }

    
}
