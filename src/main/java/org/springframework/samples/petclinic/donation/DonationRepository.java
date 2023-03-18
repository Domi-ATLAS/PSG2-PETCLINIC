package org.springframework.samples.petclinic.donation;

import org.springframework.stereotype.Repository;


import org.springframework.data.repository.CrudRepository;

@Repository
public interface DonationRepository extends CrudRepository<Donation,Integer>{
    
}
