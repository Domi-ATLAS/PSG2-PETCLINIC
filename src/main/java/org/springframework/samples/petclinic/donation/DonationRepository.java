package org.springframework.samples.petclinic.donation;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.owner.Owner;

@Repository
public interface DonationRepository extends CrudRepository<Donation,Integer>{

    List<Donation> findAllDonation();
    
    @Query("SELECT o FROM Donation o WHERE o.donante == ?1")
    List<Donation> findByOwner(Owner o);
    
}
