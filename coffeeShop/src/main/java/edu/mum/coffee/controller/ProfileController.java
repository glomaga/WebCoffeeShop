package edu.mum.coffee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Authorities;
import edu.mum.coffee.domain.HelperProfile;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Users;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.UsersService;

@Controller
public class ProfileController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private UsersService usersService;
	
	 @RequestMapping(value = "/profile", method = RequestMethod.GET)
	   public String login(Model model) {
		 HelperProfile newPerson= new HelperProfile();
		 
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username is the email
	      Person tPerson = personService.findByEmail(name).get(0);
	      newPerson.setPerson(tPerson);
		  model.addAttribute("newPerson", newPerson);
	      return "editProfile";
	   }
	 
	 
	 @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
		public String Save(Model model, @ModelAttribute("newPerson") @Valid HelperProfile newPerson,BindingResult result, HttpServletRequest request) {
			
			if(result.hasErrors()) {
				   return "addPerson";
			}
			   System.out.println("Valores "+newPerson);
				personService.savePerson(newPerson.getPerson());
				
				Users newUser=usersService.findByUsername(newPerson.getPerson().getEmail()).get(0);
				newUser.setPassword(newPerson.getUser().getPassword());
				usersService.saveUsers(newUser);
				
				 HelperProfile newPersontemp= new HelperProfile();
				 model.addAttribute("newPerson", newPersontemp);
			   
			return "redirect:/market/products";
		}
	 
	 
}
