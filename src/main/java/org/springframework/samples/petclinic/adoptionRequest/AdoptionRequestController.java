package org.springframework.samples.petclinic.adoptionRequest;

import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdoptionRequestController {
    public static final String CREATE_ADOPTION_REQUEST= "adoption/adoptionRequestForm";
    private AdoptionRequestService adoptionRequestService;
    
    private PetService petService;
    @Autowired
    public AdoptionRequestController(AdoptionRequestService adoptionRequestService,PetService petService){
        this.adoptionRequestService = adoptionRequestService;
        this.petService=petService;
    }


    @Transactional(readOnly=true)
    @GetMapping(value="adoptionRequest/new")
    public ModelAndView initCreationAdoptionRequestForm(Principal principal){

        AdoptionRequest request = new AdoptionRequest();
        ModelAndView res = new ModelAndView(CREATE_ADOPTION_REQUEST);
        List<Pet> petsFiltered = petService.getPetsByOwnerUsername(principal.getName());
        res.addObject("pets", petsFiltered);
        res.addObject("request", request);
        return res;
    
    }


    @PostMapping("adoptionRequest/new")
    public ModelAndView saveBooking(@Valid AdoptionRequest adoptionRequest,BindingResult br,Principal principal){
        ModelAndView res = new ModelAndView(CREATE_ADOPTION_REQUEST,br.getModel());
        List<Pet> petsFiltered = petService.getPetsByOwnerUsername(principal.getName());
        res.addObject("pets",petsFiltered);
        if(br.hasErrors()){
            res.addObject("pets",petsFiltered);
        }else{
                this.adoptionRequestService.saveAdoptionRequest(adoptionRequest);
                res = new ModelAndView("redirect:/");  
        }
        return res;
    }







   
}
