package org.springframework.samples.petclinic.adptionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdoptionResponseController {
    
    AdoptionResponseService adoptionApplicationService;
    
    @Autowired
    public AdoptionResponseController(AdoptionResponseService adoptionApplicationService){
        this.adoptionApplicationService = adoptionApplicationService;
        
    }
}
