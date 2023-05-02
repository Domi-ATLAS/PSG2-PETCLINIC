package org.springframework.samples.petclinic.adptionResponse;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.adoptionRequest.AdoptionRequest;
import org.springframework.samples.petclinic.adoptionRequest.AdoptionRequestService;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.samples.petclinic.user.PricingPlan;
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
    public static final String SELECT_ADOPTION_RESPONSE= "adoption/adoptionResponseSelect";
    
    AdoptionResponseService adoptionReponseService;

    AdoptionRequestService adoptionRequestService;
    
    OwnerService ownerService;

    PetService petService;

    @Autowired
    public AdoptionResponseController(AdoptionResponseService adoptionResponseService, AdoptionRequestService adoptionRequestService,OwnerService ownerService,PetService petService){
        this.adoptionReponseService = adoptionResponseService;
        this.adoptionRequestService = adoptionRequestService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/new/{adoptionRequestId}")
    public ModelAndView createAdoptionResopnseForm(@PathVariable("adoptionRequestId") Integer adoptionRequestId,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes adoptar");
            return new ModelAndView("redirect:/");
        }else{
        
            ModelAndView res = new ModelAndView(CREATE_ADOPTION_RESPONSE);
            AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
            if(adoptionRequest!=null){
                res.addObject("adoptionRequest",adoptionRequest);
                AdoptionResponse adoptionResponse= new AdoptionResponse();
                res.addObject("adoptionResponse", adoptionResponse);
            }
            return res;
        }
    }

    @PostMapping("/new/{adoptionRequestId}")
    public ModelAndView createAdoptionResopnse(@PathVariable("adoptionRequestId") Integer adoptionRequestId,@Valid AdoptionResponse adoptionResponse,BindingResult br,Principal principal,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes adoptar");
            return new ModelAndView("redirect:/");
        }else{
            ModelAndView res = new ModelAndView("redirect:/adoptionRequest/{adoptionRequestId}");
            AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
            if(br.hasErrors()){
                res = new ModelAndView(CREATE_ADOPTION_RESPONSE);
                res.addObject("adoptionRequest",adoptionRequest);
                res.addObject("adoptionResponse", adoptionResponse);
            }else{
                adoptionResponse.setOwner(obtenerOwnerLogueado(principal.getName()));
                adoptionReponseService.save(adoptionResponse);
                List<AdoptionResponse> responses;
                if(!adoptionRequest.equals(null)){
                    responses = adoptionRequest.getResponses();
                }else{
                    responses = new ArrayList<>();
                }
                responses.add(adoptionResponse);
                adoptionRequest.setResponses(responses);
                adoptionRequestService.saveAdoptionRequest(adoptionRequest);
            }
            return res;
        }
    }

    public Owner obtenerOwnerLogueado(String username){
        List<Owner> owners = ownerService.getAll();
        Owner owner = owners.stream().filter(x->x.getUser().getUsername().equals(username)).findFirst().orElse(null);
        return owner;
    }


    @GetMapping("/{adoptionRequestId}/resp")
    public ModelAndView selectAdoptionResopnseForm(@PathVariable("adoptionRequestId") Integer adoptionRequestId,Principal principal,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes solicitar adopciones");
            return new ModelAndView("redirect:/");
        }else{    
            ModelAndView res = new ModelAndView(SELECT_ADOPTION_RESPONSE);
            AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
            res.addObject("adoptionRequest", adoptionRequest);
            res.addObject("principal",principal.getName());
            res.addObject("adoptionResponse", new AdoptionResponse());
            return res;
        }
    }

    @PostMapping("/{adoptionRequestId}/resp")
    public ModelAndView selectAdoptionResopnse(@PathVariable("adoptionRequestId") Integer adoptionRequestId,AdoptionRequest adoptionRequest,Principal principal,Map<String,Object> model) throws DataAccessException, DuplicatedPetNameException{
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC){
            model.put("message","Con tu plan no puedes solicitar adopciones");
            return new ModelAndView("redirect:/");
        }else{    
            ModelAndView res = new ModelAndView("redirect:/adoptionRequest/list");
            AdoptionResponse adoptionResponseSelected = adoptionReponseService.getApplicationById(adoptionRequest.getSelectedResponse().getId()).orElse(null);
            AdoptionRequest adoptionRequestToChange = adoptionRequestService.getById(adoptionRequestId).orElse(null);
            if(!adoptionRequestToChange.equals(null)){
                adoptionRequestToChange.setSelectedResponse(adoptionResponseSelected);
                adoptionRequestToChange.setAvalible(false);
                adoptionRequestService.saveAdoptionRequest(adoptionRequestToChange);
            }
            Pet pet = adoptionRequestToChange.getPet();
            pet.setOwner(adoptionRequestToChange.getSelectedResponse().getOwner());
            petService.savePet(pet);
            Owner ownerGivesPet = adoptionRequestToChange.getAuthor();
            Owner ownerAdopt = adoptionRequestToChange.getSelectedResponse().getOwner();
            ownerGivesPet.removePet(pet);
            ownerAdopt.addPet(pet);
            ownerService.saveOwner(ownerAdopt);
            ownerService.saveOwner(ownerGivesPet);
            return res;
        }
    }

    @GetMapping("/delete/{adoptionRequestId}/{id}")
    public ModelAndView deleteAdoptionResponse(@PathVariable("id") Integer id,@PathVariable("adoptionRequestId") Integer adoptionRequestId,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no borrar solicitudes de adopción");
            return new ModelAndView("redirect:/");
        }else{    
            ModelAndView res = new ModelAndView("redirect:/adoptionRequest/list");
            AdoptionResponse adoptionResponse = adoptionReponseService.getById(id).orElse(null);
            if(adoptionResponse != null){
                AdoptionRequest adoptionRequest = adoptionRequestService.getById(adoptionRequestId).orElse(null);
                if(!adoptionRequest.equals(null)){
                    adoptionRequest.getResponses().remove(adoptionResponse);
                }
                adoptionRequestService.saveAdoptionRequest(adoptionRequest);
                adoptionReponseService.deleteApplicationById(id);
            }
            return res;
        }
    }

}
