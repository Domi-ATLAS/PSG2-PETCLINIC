package org.springframework.samples.petclinic.donation;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.cause.Cause;
import org.springframework.samples.petclinic.cause.CauseService;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.user.UserService;
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
    private CauseService causeService;
    private UserService userService;

    @Autowired
    public DonationController(DonationService service, OwnerService ownerService, CauseService causeService, UserService userService){
        this.donationService = service;
        this.ownerService = ownerService;
        this.causeService = causeService;
        this.userService = userService;
    }
    
    @GetMapping("/new")
    public ModelAndView createCause(Principal principal){
        Owner owner = ownerService.findOwnerByUser(userService.findUser(principal.getName()).get());
        Donation donation = new Donation();
        List<Cause> causes = causeService.getAllCauses();
        ModelAndView result = new ModelAndView("donation/createDonation");
        result.addObject("donation", donation);
        result.addObject("owner", owner);
        result.addObject("causes", causes);
        return result;
    }

    @PostMapping("/new")
    public ModelAndView saveNewCause(@Valid Donation donation, BindingResult br){

        if(br.hasErrors()){
            return new ModelAndView("donation/createDonation", br.getModel());
        }
        donationService.saveDonation(donation);
        ModelAndView result = new ModelAndView("redirect:/causes");
        result.addObject("message", "The donation was succesfully added");
        return result;
    }


}
