package org.springframework.samples.petclinic.donation;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DonationService {

    private DonationRepository donationRepo;

    @Autowired
    public DonationService(DonationRepository repo){
        this.donationRepo = repo;
    }
    

    @Transactional(readOnly = true)
    public List<Donation> getAllDonations(){
        return (List<Donation>) donationRepo.findAll();
    } 

    @Transactional
    public Optional<Donation> getDonatioById(Integer id){
        return donationRepo.findById(id);
    }

    @Transactional
    public void saveDonation(Donation d){
        donationRepo.save(d);
    }

    @Transactional
    public void deleteDonation(Donation d){
        donationRepo.delete(d);
    }
}
