package org.springframework.samples.petclinic.donation;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private DonationService donationService;
    private OwnerService ownerService;

    @Autowired
    public DonationController(DonationService service, OwnerService ownerService){
        this.donationService = service;
        this.ownerService = ownerService;
    }
    
    @GetMapping("/new")
    public ModelAndView createCause(Principal principal){
        Owner owner = ownerService.findOwnerByUser(principal.getName());
        Donation donation = new Donation();
        ModelAndView result = new ModelAndView("donation/createDonation");
        result.addObject("donation", donation);
        result.addObject("owner", owner);
        return result;
    }

    @PostMapping("/new")
    public ModelAndView saveNewCause(@Valid Donation donation, BindingResult br){
        if(br.hasErrors()){
            return new ModelAndView("donation/createDonation", br.getModel());
        }
        donationService.saveDonation(donation);
        ModelAndView result = new ModelAndView("redirect:/donation");
        result.addObject("message", "The donation was succesfully added");
        return result;
    }


}
