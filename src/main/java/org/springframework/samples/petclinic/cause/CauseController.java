package org.springframework.samples.petclinic.cause;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/causes")
public class CauseController {

    private static final String LIST_CAUSES = "cause/causeList";

	private final CauseService causeService;

	@Autowired
	public CauseController(CauseService causeService) {
		this.causeService = causeService;
	}

    @GetMapping("")
    public ModelAndView causeList(Principal principal){
        List<Cause> causes = causeService.getAllCauses();
        ModelAndView res = new ModelAndView(LIST_CAUSES);
        for(Cause c: causes){
            if(c.getAchievedBudget()>=c.getBudgetTarget()){
                c.setIsClosed(true);
                causeService.editCause(c);
            }
        }
        res.addObject("causes",causes);
        return res;
    }

    @GetMapping("/new")
    public ModelAndView createCause(){
        Cause cause = new Cause();
        ModelAndView result = new ModelAndView("cause/createCause");
        result.addObject("cause", cause);
        return result;
    }

    @PostMapping("/new")
    public ModelAndView saveNewCause(@Valid Cause cause, BindingResult br){
        if(br.hasErrors()){
            return new ModelAndView("cause/createCause", br.getModel());
        }
        causeService.save(cause);
        ModelAndView result = new ModelAndView("redirect:/causes");
        result.addObject("message", "The cause was succesfully added");
        return result;
    }

    @GetMapping("details/{id}")
    public ModelAndView causeDetails(@PathVariable("id") Integer id){
        ModelAndView result = new ModelAndView("cause/causeDetails");
        Cause cause = causeService.getCauseById(id).get();
        result.addObject("cause", cause);

        return result;
    }


    
}
