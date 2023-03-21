package org.springframework.samples.petclinic.adoptionRequest;

import java.security.Principal;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdoptionRequestController {
    public static final String CREATE_ADOPTION_REQUEST= "adoption/adoptionRequestForm";
    public static final String LIST_ADOPTION_REQUEST= "adoption/adoptionRequestList";
    public static final String SHOW_ADOPTION_REQUEST= "adoption/adoptionRequestResponses";
    private AdoptionRequestService adoptionRequestService;
    
    private PetService petService;
    @Autowired
    public AdoptionRequestController(AdoptionRequestService adoptionRequestService,PetService petService){
        this.adoptionRequestService = adoptionRequestService;
        this.petService=petService;
    }


    @GetMapping(value="adoptionRequest/new")
    public ModelAndView initCreationAdoptionRequestForm(Principal principal){
        AdoptionRequest request = new AdoptionRequest();
        ModelAndView res = new ModelAndView(CREATE_ADOPTION_REQUEST);
        List<Pet> petByowner = petService.getPetsByOwnerUsername(principal.getName());
        List<Pet> petsFiltered = filterPestToCreateAdoptionRequest(petByowner, principal.getName());
        res.addObject("pets", petsFiltered);
        res.addObject("adoptinoRequest", request);
        return res;
    }

    public List<Pet> filterPestToCreateAdoptionRequest(List<Pet> pets,String principal){
        List<AdoptionRequest> adoptionRequests= adoptionRequestService.getAll();
        for(int i = 0;i<pets.size();i++ ){
            Pet p = pets.get(i);
            Boolean aux = adoptionRequests.stream().anyMatch(x->x.getPet().equals(p) && x.getAuthor().equals(p.getOwner()));
            if(aux){
                pets.remove(p);
            }
        }
        return pets;
    }


    @PostMapping("adoptionRequest/new")
    public ModelAndView saveBooking(@Valid AdoptionRequest adoptionRequest,BindingResult br,Principal principal){
        ModelAndView res = new ModelAndView(CREATE_ADOPTION_REQUEST,br.getModel());
        if(br.hasErrors()){
            List<Pet> petByowner = petService.getPetsByOwnerUsername(principal.getName());
            List<Pet> petsFiltered = filterPestToCreateAdoptionRequest(petByowner, principal.getName());
            res.addObject("pets",petsFiltered);
        }else{
            adoptionRequest.setAuthor(adoptionRequest.getPet().getOwner());        
            this.adoptionRequestService.saveAdoptionRequest(adoptionRequest);
            res = new ModelAndView("redirect:/adoptionRequest/list");  
        }
        return res;
    }

    @GetMapping(value="adoptionRequest/list")
    public ModelAndView showAdoptionRequests(Principal principal){
        ModelAndView res = new ModelAndView(LIST_ADOPTION_REQUEST);
        List<AdoptionRequest> adoptionRequests = adoptionRequestService.getAll();
        List<AdoptionRequest> adoptionRequestsFiltered = adoptionRequests.stream().filter(x->x.getAvalible()==null || x.getAvalible() == true).collect(Collectors.toList());
        res.addObject("adoptionRequests", adoptionRequestsFiltered);
        res.addObject("principal", principal.getName());
        return res;
    }

    @GetMapping(value="adoptionRequest/{id}")
    public ModelAndView showAdoptionRequests(@PathVariable("id") Integer id,Principal principal){
        ModelAndView res = new ModelAndView(SHOW_ADOPTION_REQUEST);
        AdoptionRequest adoptionRequest = adoptionRequestService.getById(id).orElse(null);
        res.addObject("principal", principal.getName());
        res.addObject("adoptionRequest", adoptionRequest);
        return res;
    }

    @GetMapping(value ="adoptionRequest/delete/{id}")
    public ModelAndView deleteAdoptionRequest(@PathVariable("id") Integer id){
        ModelAndView res = new ModelAndView("redirect:/adoptionRequest/list");
        AdoptionRequest adoptionRequest = adoptionRequestService.getById(id).orElse(null);
        if(adoptionRequest !=null){
            adoptionRequestService.deleteAdoptionRequest(adoptionRequest);
        }
        return res;
    }







   
}
