package edu.mum.coffee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Authorities;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Users;
import edu.mum.coffee.service.AuthoritiesService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.UsersService;

@Controller
public class RegisterController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String login(Model model) {
		 Person newPerson = new Person();
		   model.addAttribute("newPerson", newPerson);
			 Users newUser = new Users();
			   model.addAttribute("newUser", newUser);
	      return "addPerson";
	   }
	 
	 

		@RequestMapping(value = "/register/add", method = RequestMethod.POST)
		public String Save(Model model, @ModelAttribute("newPerson") @Valid Person newPerson, @ModelAttribute("Users") Users user ,BindingResult result, HttpServletRequest request) {
			
			if(result.hasErrors()) {
				   return "addPerson";
			}
			 System.out.println("Valores "+newPerson);
				personService.savePerson(newPerson);
				
				System.out.println("clave"+ user.getPassword() );
				Users newUser= new Users();
				newUser.setUsername(newPerson.getEmail());
				newUser.setPassword(newPerson.getFirstName());
				newUser.setEnabled(true);
				usersService.saveUsers(newUser);
				Authorities newAuto= new Authorities();				
				newAuto.setUsername(newUser);
				newAuto.setAuthority("ROLE_USER");
				authoritiesService.saveAuthorities(newAuto);
			  
				
			   Person newPerson2 = new Person();
			   model.addAttribute("newPerson", newPerson2);
			   
			return "redirect:/login";
		}
		
}
