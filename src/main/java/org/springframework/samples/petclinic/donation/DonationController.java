package org.springframework.samples.petclinic.donation;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.cause.Cause;
import org.springframework.samples.petclinic.cause.CauseService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private DonationService donationService;
    private CauseService causeService;

    @Autowired
    public DonationController(DonationService service, CauseService causeService){
        this.donationService = service;
        this.causeService = causeService;
    }

    @GetMapping("/new/{causeId}")
    public ModelAndView createCause(@PathVariable("causeId") Integer causeId, Principal principal){
        Donation donation = new Donation();
        ModelAndView result = new ModelAndView("donation/createDonation");
        String donorName = principal.getName();
        result.addObject("donation", donation);
        result.addObject("donorName", donorName);
        return result;
    }

    @PostMapping("/new/{causeId}")
    public ModelAndView saveNewCause(@PathVariable("causeId") Integer causeId, @Valid Donation donation, BindingResult br){

        if(br.hasErrors()){
            ModelAndView res = new ModelAndView("donation/createDonation", br.getModel());
            List<Cause> causes = causeService.getAllCauses();
            res.addObject("causes",causes);
            return res;
        }
        donationService.saveDonation(donation);
        Cause toUpdate = causeService.getCauseById(causeId).get();
        List<Donation> donations = toUpdate.getDonations();
        donations.add(donation);
        toUpdate.setDonations(donations);
        causeService.editCause(toUpdate);
        ModelAndView result = new ModelAndView("redirect:/causes");
        result.addObject("message", "The donation was succesfully added");
        return result;
    }

}
