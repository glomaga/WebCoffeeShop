package edu.mum.coffee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.mum.coffee.domain.Person;

import edu.mum.coffee.service.PersonService;

@Controller
@RequestMapping("market")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/person/admin", method = RequestMethod.GET)
	public String getAdminPersonForm(Model model) {
	   Person newPerson = new Person();
	   model.addAttribute("newPerson", newPerson);
	   model.addAttribute("people", personService.getAllPerson());
	   return "AdminPerson";
	}
	
	@RequestMapping(value = "/person/admin", method = RequestMethod.POST)
	public String Save(Model model, @ModelAttribute("newPerson") @Valid Person newPerson, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			   return "AdminPerson";
		}
		System.out.println("Valores "+newPerson);
		personService.savePerson(newPerson);

		   Person newPerson2 = new Person();
		   model.addAttribute("newPerson", newPerson2);
		   model.addAttribute("people", personService.getAllPerson());
		   
		return "redirect:/market/person/admin";
	}
	

	@RequestMapping("/person/admin/{PersonKey}")
	public String Update(Model model, @PathVariable("PersonKey") Long PersonKey) {
		   model.addAttribute("newPerson", personService.findById(PersonKey));
		   model.addAttribute("people", personService.getAllPerson());
		   return "AdminPerson";
	}

	@RequestMapping("/person/admin/delete/{PersonKey}")
	public String Delete(Model model, @PathVariable("PersonKey") Long PersonKey) {
		Person temp= personService.findById(PersonKey);
				personService.removePerson(temp);
				   Person newPerson2 = new Person();
				   model.addAttribute("newPerson", newPerson2);
				   model.addAttribute("people", personService.getAllPerson());
		return "redirect:/market/person/admin";
	}

	
}