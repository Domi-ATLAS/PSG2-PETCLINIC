package org.springframework.samples.petclinic.adptionResponse;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.adoptionRequest.AdoptionRequest;
import org.springframework.samples.petclinic.adoptionRequest.AdoptionRequestService;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adoptionResponse")
public class AdoptionResponseController {

    public static final String CREATE_ADOPTION_RESPONSE= "adoption/adoptionResponseCreate";
    
    AdoptionResponseService adoptionReponseService;

    AdoptionRequestService adoptionRequestService;
    
    OwnerService ownerService;

    @Autowired
    public AdoptionResponseController(AdoptionResponseService adoptionResponseService, AdoptionRequestService adoptionRequestService,OwnerService ownerService){
        this.adoptionReponseService = adoptionResponseService;
        this.adoptionRequestService = adoptionRequestService;
        this.ownerService = ownerService;
    }

    @GetMapping("/new/{adoptionRequestId}")
    public ModelAndView createAdoptionResopnseForm(@PathVariable("adoptionRequestId") Integer adoptionRequestId){
        ModelAndView res = new ModelAndView(CREATE_ADOPTION_RESPONSE);
        AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
        if(adoptionRequest!=null){
            res.addObject("adoptionRequest",adoptionRequest);
            AdoptionResponse adoptionResponse= new AdoptionResponse();
            res.addObject("adoptionResponse", adoptionResponse);
        }
        return res;
    }

    @PostMapping("/new/{adoptionRequestId}")
    public ModelAndView createAdoptionResopnse(@PathVariable("adoptionRequestId") Integer adoptionRequestId,@Valid AdoptionResponse adoptionResponse,BindingResult br,Principal principal){
        ModelAndView res = new ModelAndView("redirect:/adoptionRequest/{adoptionRequestId}");
        AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
        if(br.hasErrors()){
            res = new ModelAndView(CREATE_ADOPTION_RESPONSE);
            res.addObject("adoptionRequest",adoptionRequest);
            res.addObject("adoptionResponse", adoptionResponse);
        }else{
            adoptionResponse.setOwner(obtenerOwnerLogueado(principal.getName()));
            adoptionReponseService.save(adoptionResponse);
            List<AdoptionResponse> responses = adoptionRequest.getResponses();
            responses.add(adoptionResponse);
            adoptionRequest.setResponses(responses);
            adoptionRequestService.saveAdoptionRequest(adoptionRequest);
        }
        return res;
    }

    public Owner obtenerOwnerLogueado(String username){
        List<Owner> owners = ownerService.getAll();
        Owner owner = owners.stream().filter(x->x.getUser().getUsername().equals(username)).findFirst().orElse(null);
        return owner;
    }

}
