package org.springframework.samples.petclinic.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DonationController {

    private DonationService donationService;

    @Autowired
    public DonationController(DonationService service){
        this.donationService = service;
    }
    
}
