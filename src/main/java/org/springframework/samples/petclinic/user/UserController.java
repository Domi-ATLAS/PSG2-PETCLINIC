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

import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.samples.petclinic.exchange.Currency;
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
import org.springframework.web.bind.annotation.RequestParam;
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

	private static final String USER_CA="users/customerAgreement";

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
		res.addObject("options", Currency.values());
		return res;

	}

	@PostMapping("/users/{username}")
	public ModelAndView changeCurrency(@PathVariable("username") String username,@RequestParam String currency, Principal principal){

		User user = userService.findUser(username).get();
		user.setPreferedCurrency(Currency.valueOf(currency));
		userService.saveUser(user);
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
		res.addObject("options", Currency.values());
		return res;

	}

	@GetMapping("/users/CA")
	public ModelAndView CA(){
		PegDownProcessor pdp = new PegDownProcessor();
    	String markdownText = "# Acuerdo con el cliente \n";
		markdownText +="\n";
		markdownText +="## Servicios \n";
		markdownText +="El Proveedor proporcionará al Cliente los servicios de petclinic así como todos los servicios asociados con el lanzamiento y uso de este (en adelante, los 'Servicios'). Los usuarios pueden solicitar incidentes de resolución, peticiones de usuario y solicitudes de cambios estimados. Entre los servicios integrados tenemos:\n";
		markdownText +="\n";
		markdownText +="* Un servicio de hotel para las mascotas de los propietarios, este servicio les permitirá a los propietarios reservar habitaciones durante el tiempo que quieran para sus mascotas.  \n";
		markdownText +="\n";
		markdownText +="* Un servicio de causas, gracias al cual los propietarios podrán crear causas benéficas para recolectar dinero de las donaciones de otros usuarios de la aplicación. De las causas se guardará información como el nombre, la descripción, el dinero que se fije como objetivo y el nombre de una organización a la cual la causa se asociará, una causa se cerrará cuando la suma de las cantidades de sus donaciones supere la cantidad objetivo fijada. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de donaciones, que permitirá a los usuarios hacer donaciones a las causas creadas por otros propietarios añadiendo a sus donaciones un mensaje. El listado de donaciones de una causa será visible para los usuarios y por lo tanto el mensaje asociado a cada donación también se podrá ver. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de visitas, que registrará las visitas de los clientes y permitirá que los veterinarios vean el historial médico de las mascotas. De las visitas se guarda información como, la fecha, una descripción y la mascota que hizo la visita a la clínica. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de adopciones, por el cual los propietarios podrán poner en adopción sus mascotas solicitando que las adopten, a la solicitud se añadirá un mensaje en el que el propietario debe indicar cómo deben cuidar a su mascota, además una solicitud de adopción podrá ser cancelada siempre que no se haya seleccionado a ningún usuario como nuevo propietario de la mascota que se pone en adopción. Los propietarios podrán responder a las solicitudes de adopción postulando como nuevos propietarios, indicando en un mensaje como cuidarán de la mascota. Finalmente, el propietario que creó la solicitud, podrá escoger cuál será el nuevo propietario de su mascota. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de resolución de incidentes, cuando nuestros clientes detecten algún fallo o interrupción en el servicio los clientes podrán reportarlo a través de nuestro portal de iTop y nosotros nos encargaremos de resolver los incidentes con la mayor brevedad posible. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de peticiones de los usuarios, los usuarios podrán hacernos pequeñas peticiones que no supongan cambios en nuestra funcionalidad a través de nuestro portal de iTop. \n";
		markdownText +="\n";
		markdownText +="* Un servicio de de peticiones de cambios, los usuarios podrán hacernos peticiones para que realicemos cambios en la funcionalidad de nuestra aplicación a través de nuestro portal de iTop. \n";
		markdownText +="\n";
		markdownText +="## Tarifas y pagos \n";
		markdownText +="\n";
		markdownText +="El Cliente pagará al Proveedor la cantidad descrita en el plan de precios para poder acceder a los siguientes servicios, que es la siguiente (en adelante, las 'Tarifas'): \n";
		markdownText +=" \n";
		markdownText +="* Plan Básico: este plan tiene un precio de 0€/mes y nos da la posibilidad de donar, buscar propietarios y ver sus detalles y hacer visitas a nuestra clínica, las visitas serán cobradas cuando se hagan y su precio dependerá de la causa de la visita. Otros servicios que se proporcionan para el plan básico son las peticiones de usuarios y la resolución de incidentes. Este plan no asegura que todos los servicios que proporciona estén siempre disponibles para los usuarios. \n";
		markdownText +=" \n";
		markdownText +="* Plan Advanced: además de todo lo anterior se añade la posibilidad de poder hacer reservas con una limitación de dos reservas mensuales además de poder solicitar que otros propietarios adopten sus mascotas y escoger al mejor propietario para nuestra mascota.  Adicionalmente, a este servicio se añade un descuento del 5% que se aplicará sobre el precio de las visitas. Todo esto por un precio de 5€/mes. Para este plan todos los servicios estarán siempre disponibles para los usuarios. \n";
		markdownText +=" \n";
		markdownText +="* Plan Pro: por un precio de 10€/mes incluye todo lo contenido en los dos anteriores planes, además de poder responder a adopciones para postular como nuevo propietario de una mascota y crear causas benéficas para recolectar dinero. Este plan carece de limitaciones en las reservas, no como los otros dos anteriores(notar que el plan básico no tiene la posibilidad de hacer reservas solo el advanced y pro). Y al igual que el plan Advanced, tiene un descuento del 10% aplicable sobre el precio de las visitas. Para este plan todos los servicios estarán siempre disponibles para los usuarios. \n";
		markdownText +=" \n";
		markdownText +="En la siguiente tabla se puede observar de forma esquemática lo que nos permite cada plan. \n";
		markdownText +=" \n";


		String markdownText2 = "El Proveedor se reserva el derecho de modificar las Tarifas y plazos de pago en caso de cambios en los Servicios.\n";
		markdownText2 +="\n";
		markdownText2 +="El Cliente acepta pagar todas las Tarifas y gastos relacionados con los Servicios. \n";

    	String htmlText1 = pdp.markdownToHtml(markdownText);
		String htmlText2 = pdp.markdownToHtml(markdownText2);

		ModelAndView res = new ModelAndView(USER_CA);
		res.addObject("htmlText1",htmlText1);
		res.addObject("htmlText2", htmlText2);
		return res;
	}


}
