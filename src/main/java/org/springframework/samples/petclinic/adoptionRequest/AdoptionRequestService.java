package org.springframework.samples.petclinic.adoptionRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionRequestService {

    private AdoptionRequestRepository adoptionRequestRepositorio;

    @Autowired
    public AdoptionRequestService(AdoptionRequestRepository repo){
        this.adoptionRequestRepositorio = repo;
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> getAll(){
        return adoptionRequestRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<AdoptionRequest> getById(Integer id){
        return adoptionRequestRepositorio.findById(id);
    }
    
    @Transactional
    public void deleteAdoptionRequest(AdoptionRequest ar){
        adoptionRequestRepositorio.delete(ar);
    }

    @Transactional
    public void saveAdoptionRequest(AdoptionRequest ar){
        adoptionRequestRepositorio.save(ar);
    }

    
}
