package org.springframework.samples.petclinic.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@Autowired
	private UserService userService;
	
	
	  @GetMapping({"/","/welcome"})
	  public String welcome(Map<String, Object> model, Principal principal) {	 

		if(principal != null){
			String username = principal.getName();
			model.put("username", username);
		}
	    return "welcome";
	  }
}
