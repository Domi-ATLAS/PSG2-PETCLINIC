package org.springframework.samples.petclinic.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.maps.MapsService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.maps.model.LatLng;

@Controller
public class WelcomeController {

	@Autowired
	private UserService userService;
	
	
	  @GetMapping({"/","/welcome"})
	  public String welcome(Map<String, Object> model, Principal principal) throws Exception{	
		if(principal != null){
			String username = principal.getName();
			model.put("username", username);
		} 
		LatLng latLng = MapsService.getLatLng("C. Reina de la Paz, 41013 Sevilla");
		String url = "https://www.google.com/maps/search/?api=1&query=" + latLng.lat + "," + latLng.lng;
		model.put("url", url);
	    return "welcome";
	  }
}
