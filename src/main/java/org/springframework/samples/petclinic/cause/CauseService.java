package org.springframework.samples.petclinic.cause;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CauseService {

    private CauseRepository causeRepository;

    @Autowired
    public CauseService(CauseRepository cr){
        this.causeRepository = cr;

    }

    @Transactional
    public void save(Cause cause){
        causeRepository.save(cause);
    }

    @Transactional(readOnly = true)
    public List<Cause> getAllCauses(){
        return causeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cause> getCauseById(Integer id){
        return causeRepository.findById(id);
    }


    @Transactional
    public void deleteCauseById(Integer id){
        causeRepository.deleteById(id);
    }

    @Transactional

    public void editCause(Cause c) throws DataAccessException{
        Cause toUpdate = causeRepository.findById(c.getId()).orElse(null);
        if(!toUpdate.equals(null)){
            toUpdate.setId(c.getId());
            toUpdate.setBudgetTarget(c.getBudgetTarget());
            toUpdate.setDescription(c.getDescription());
            toUpdate.setDonations(c.getDonations());
            toUpdate.setIsClosed(c.getIsClosed());
            toUpdate.setName(c.getName());
            toUpdate.setNonProfitOrganization(c.getNonProfitOrganization());
        }
        causeRepository.save(toUpdate);
    }
    
}
