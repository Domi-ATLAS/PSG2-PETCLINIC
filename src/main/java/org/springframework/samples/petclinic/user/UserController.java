/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.user;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
public class UserController {

	private static final String VIEWS_OWNER_CREATE_FORM = "users/createOwnerForm";

	private static final String CHANGE_PLAN = "users/changePlan";

	private static final String USER_PROFILE = "users/userProfile";

	private final OwnerService ownerService;

	private final UserService userService;

	private final VetService vetService;

	private final AuthoritiesService authService;

	@Autowired
	public UserController(OwnerService clinicService,UserService userService, VetService vetService, AuthoritiesService authService) {
		this.ownerService = clinicService;
		this.userService = userService;
		this.vetService = vetService;
		this.authService = authService;
	}

	


	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/users/new")
	public String initCreationForm(Map<String, Object> model) {
		Owner owner = new Owner();
		model.put("owner", owner);
		return VIEWS_OWNER_CREATE_FORM;
	}

	@PostMapping(value = "/users/new")
	public String processCreationForm(@Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_FORM;
		}
		else {
			//creating owner, user, and authority
			owner.getUser().setPlan(PricingPlan.BASIC);
			this.ownerService.saveOwner(owner);
			return "redirect:/";
		}
	}

	@GetMapping("/users/changePlan")
	public ModelAndView changePlan(Principal principal,Map<String,Object> model){
		ModelAndView res =  new ModelAndView(CHANGE_PLAN);
		PricingPlan plan = (PricingPlan)model.get("currentPlan");
		res.addObject("user",userService.currentUser(principal));
		res.addObject("plan",plan);
		return res;
	}

	@PostMapping("/users/changePlan")
	public ModelAndView changePlan(@Valid User user,BindingResult br,Principal principal){
		ModelAndView res = new ModelAndView(CHANGE_PLAN);
		if(br.hasErrors()){
			res.addObject("user", userService.currentUser(principal));
			return res;
		}else{
			User toUpdate = userService.findUser(principal.getName()).orElse(null);
			toUpdate.setPlan(user.plan);

			userService.saveUser(toUpdate);
			return new ModelAndView("redirect:/");
		}
		

	}

	@GetMapping("/users/{username}")
	public ModelAndView showProfile(@PathVariable("username") String username, Principal principal){

		User user = userService.findUser(username).get();
		Owner owner = ownerService.findByUsername(user.getUsername());
		Vet vet = vetService.findByUserName(username);
		PricingPlan plan = user.getPlan();
		String principalName = principal.getName();
		ModelAndView res = new ModelAndView(USER_PROFILE);

		String type = user.getAuthorities().stream().collect(Collectors.toList()).get(0).getAuthority();


		if(plan != null){
			res.addObject("plan", plan);
		}		
		res.addObject("user", user);
		res.addObject("owner", owner);
		res.addObject("vet", vet);
		res.addObject("principalName", principalName);
		res.addObject("type", type);
		return res;

	}


}
