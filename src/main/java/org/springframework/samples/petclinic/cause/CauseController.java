package org.springframework.samples.petclinic.cause;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.donation.Donation;
import org.springframework.samples.petclinic.donation.DonationService;
import org.springframework.samples.petclinic.exchange.ExchangeCurrency;
import org.springframework.samples.petclinic.user.PricingPlan;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/causes")
public class CauseController {

    private static final String LIST_CAUSES = "cause/causeList";

	private final CauseService causeService;
    private final UserService userService;
    private final DonationService donationService;

	@Autowired
	public CauseController(CauseService causeService, UserService userService, DonationService donationService) {
		this.causeService = causeService;
        this.userService = userService;
        this.donationService = donationService;

	}

    @GetMapping()
    public ModelAndView causeList(Principal principal){
        User user = userService.findUser(principal.getName()).get();
        String currency = "USD";
        if(user.getPreferedCurrency()!=null ){
            currency=user.getPreferedCurrency();
        }
        Map<Cause,List<ExchangeCurrency>> causeBudgets = causeService.findAllCausesByExchangeCurrency(currency);
        
        ModelAndView res = new ModelAndView(LIST_CAUSES);
        causeService.checkCauses();
        res.addObject("causeBudgets", causeBudgets);
        res.addObject("options", ExchangeCurrency.currencyMap().keySet());
        return res;
    }

    @PostMapping()
    public ModelAndView currencyCauseList(@RequestParam String currency){
        ModelAndView res = new ModelAndView(LIST_CAUSES);
        Map<Cause,List<ExchangeCurrency>> causeBudgets = causeService.findAllCausesByExchangeCurrency(currency);
        res.addObject("causeBudgets", causeBudgets);
        res.addObject("options", ExchangeCurrency.currencyMap().keySet());
        
        return res;
    }

    @GetMapping("/new")
    public ModelAndView createCause(Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes crear una causa");
            return new ModelAndView("redirect:/");
        }else{
            Cause cause = new Cause();
            ModelAndView result = new ModelAndView("cause/createCause");
            result.addObject("cause", cause);
            return result;
        }
    }

    @PostMapping("/new")
    public ModelAndView saveNewCause(@Valid Cause cause, BindingResult br,Map<String,Object> model){
        PricingPlan plan = (PricingPlan)model.get("currentPlan");
        if(plan==null||plan==PricingPlan.BASIC||plan ==PricingPlan.ADVANCED){
            model.put("message","Con tu plan no puedes crear una causa");
            return new ModelAndView("redirect:/");
        }else{    
            if(br.hasErrors()){
                return new ModelAndView("cause/createCause", br.getModel());
            }
            causeService.save(cause);
            ModelAndView result = new ModelAndView("redirect:/causes");
            result.addObject("message", "The cause was succesfully added");
            return result;
        }
    }

    @GetMapping("details/{id}")
    public ModelAndView causeDetails(@PathVariable("id") Integer id,Map<String,Object> model, Principal principal){
            ModelAndView result = new ModelAndView("cause/causeDetails");
            User user = userService.findUser(principal.getName()).get();
            Cause cause = causeService.getCauseById(id).orElse(null);
            String currency = "USD";
            if(user.getPreferedCurrency()!=null ){
                currency=user.getPreferedCurrency();
            }
            Map<Cause,List<ExchangeCurrency>> causeBudgets = causeService.findAllCausesByExchangeCurrency(currency);
            List<ExchangeCurrency> budgets = causeBudgets.get(cause);
            Double budgetTarget = budgets.get(0).getValue();
            Double achievedBudget = budgets.get(1).getValue();
            if(!cause.equals(null)){
                result.addObject("cause", cause);
            }
            Map<Donation, ExchangeCurrency> donationAmounts = donationService.valueByDonation(cause, currency);
            result.addObject("donationAmounts", donationAmounts);
            result.addObject("achievedBudget", achievedBudget);
            result.addObject("budgetTarget", budgetTarget);
            result.addObject("currency", currency);
            return result;
    }


    
}
