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
package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {

	private final VetService vetService;

	@Autowired
	public VetController(VetService clinicService) {
		this.vetService = clinicService;
	}

	@GetMapping(value = { "/vets" })
	public String showVetList(Map<String, Object> model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects
		// so it is simpler for Object-Xml mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetService.findVets());
		model.put("vets", vets);
		return "vets/vetList";
	}

	@GetMapping(value = { "/vets.xml"})
	public @ResponseBody Vets showResourcesVetList() {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects
		// so it is simpler for JSon/Object mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetService.findVets());
		return vets;
	}

	@GetMapping("/vets/edit/{id}")
	public ModelAndView editVet(@PathVariable("id") int id){
		ModelAndView res = new ModelAndView("vets/editVet");
		Vet vet = vetService.findVetById(id);
		res.addObject("vet", vet);
		return res;
	}

	@PostMapping("/vets/edit/{id}")
	public  ModelAndView createOrUpdateVet(@PathVariable("id") int id,  @Valid Vet vet, BindingResult br){
		if (!br.hasErrors()) {
			Vet vet2 = vetService.findVetById(id);
			vet2.setFirstName(vet.getFirstName());
			vet2.setLastName(vet.getLastName());
            vetService.save(vet2);
        } else {
			return new ModelAndView("redirect:/vets/edit/{id}");
        }
        return new ModelAndView("redirect:/vets");
	}

	@GetMapping("/vets/editSpecialty/{id}")
	public ModelAndView editSpecialityForm(@PathVariable("id") int id){
		ModelAndView res = new ModelAndView("vets/editSpecialty");
		List<Specialty> specialty = vetService.findAllSpecialty();
		Specialty spec = new Specialty();
		Vet vet = vetService.findVetById(id);
		res.addObject("spec",spec);
		res.addObject("specialty", specialty);
		res.addObject("nameVet", vet.getFirstName());
		return res;
	}

	@PostMapping("/vets/editSpecialty/{id}")
	public ModelAndView editSpecialty(@PathVariable("id") int id,  @Valid Specialty specialty, BindingResult br){
		ModelAndView res = new ModelAndView("vets/editSpecialty");
		List<Specialty> specialty1 = vetService.findAllSpecialty();
		res.addObject("specialty", specialty1);
		if (!br.hasErrors()) {
           Vet vet = vetService.findVetById(id);
		   List<Specialty> specialtiesAux = vetService.findAllSpecialty();
		   Specialty specialtyAux = specialtiesAux.stream().filter(x->x.getName().equals(specialty.getName())).collect(Collectors.toList()).get(0);
		   vet.addSpecialty(specialtyAux);
		   vetService.save(vet);
        } else {
			return new ModelAndView("redirect:/vets/editSpecialty/{id}");
        }
        return new ModelAndView("redirect:/vets");
	}

	@GetMapping("/vets/deleteSpecialty/{id}")
	public ModelAndView deleteSpecialityForm(@PathVariable("id") int id){
		ModelAndView res = new ModelAndView("vets/deleteSpecialty");
		List<Specialty> specialty = vetService.findAllSpecialty();
		Vet vet = vetService.findVetById(id);
		Specialty spec = new Specialty();
		res.addObject("spec",spec);
		res.addObject("specialty", specialty);
		res.addObject("nameVet", vet.getFirstName());
		return res;
	}

	@PostMapping("/vets/deleteSpecialty/{id}")
	public ModelAndView deleteSpeciality(@PathVariable("id") int id,  @Valid Specialty specialty, BindingResult br){
		ModelAndView res = new ModelAndView("vets/deleteSpecialty");
		List<Specialty> specialty1 = vetService.findAllSpecialty();
		res.addObject("specialty", specialty1);
		if (!br.hasErrors()) {
           Vet vet = vetService.findVetById(id);
		   List<Specialty> specialtiesAux = vetService.findAllSpecialty();
		   Specialty specialtyAux = specialtiesAux.stream().filter(x->x.getName().equals(specialty.getName())).collect(Collectors.toList()).get(0);
		   vet.deleteSpeciality(specialtyAux);
		   vetService.save(vet);
        } else {
			return new ModelAndView("redirect:/vets/deleteSpecialty/{id}");
        }
        return new ModelAndView("redirect:/vets");
	}

	@GetMapping("/vets/new")
    public ModelAndView createVet(){
        Vet vet = new Vet();
        ModelAndView result = new ModelAndView("vets/createVet");
		List<Specialty> specialty = vetService.findAllSpecialty();
        result.addObject("vet", vet);
		result.addObject("specialty", specialty);
        return result;
    }

    @PostMapping("/vets/new")
    public ModelAndView saveNewLogro(@Valid Vet vet, BindingResult br){
        if(br.hasErrors()){
            return new ModelAndView("vets/createVet",br.getModel());
        }
        vetService.save(vet);
        ModelAndView result =new ModelAndView("redirect:/vets");
        result.addObject("message", "El veterinario se añadió correctamente");
        return result;
    }

	
	@GetMapping(value="/vets/{vetId}/delete")
	public ModelAndView deleteVet(@PathVariable("vetId") int vetId){
		Vet vet = vetService.findVetById(vetId);
		vetService.deleteVet(vet.getId());
		return new ModelAndView("redirect:/vets");
	}

}
