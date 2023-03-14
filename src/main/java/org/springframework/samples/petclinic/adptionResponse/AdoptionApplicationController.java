package org.springframework.samples.petclinic.adptionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdoptionApplicationController {
    
    AdoptionApplicationService adoptionApplicationService;
    
    @Autowired
    public AdoptionApplicationController(AdoptionApplicationService adoptionApplicationService){
        this.adoptionApplicationService = adoptionApplicationService;
        
    }
}
