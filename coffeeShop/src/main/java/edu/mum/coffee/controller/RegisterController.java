package edu.mum.coffee.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Authorities;
import edu.mum.coffee.domain.HelperProfile;
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
//		 Person newPerson = new Person();
//		   model.addAttribute("newPerson", newPerson);
//			 Users newUser = new Users();
//			   model.addAttribute("newUser", newUser);
		 HelperProfile newPerson= new HelperProfile();
		 model.addAttribute("newPerson", newPerson);
	      return "addPerson";
	   }
	 
	 
	 @RequestMapping(value = "/register/add", method = RequestMethod.POST)
		public String Save(Model model, @ModelAttribute("newPerson") @Valid HelperProfile newPerson,BindingResult result, HttpServletRequest request) {
			
			if(result.hasErrors()) {
				   return "addPerson";
			}
			   System.out.println("Valores "+newPerson);
				personService.savePerson(newPerson.getPerson());
				
				Users newUser= new Users();
				newUser.setUsername(newPerson.getPerson().getEmail());
				newUser.setPassword(newPerson.getUser().getPassword());
				newUser.setEnabled(true);
				usersService.saveUsers(newUser);
				
				Authorities newAuto= new Authorities();				
				newAuto.setUsername(newUser);
				newAuto.setAuthority("ROLE_USER");
				authoritiesService.saveAuthorities(newAuto);
			  
				
				 HelperProfile newPersontemp= new HelperProfile();
				 model.addAttribute("newPerson", newPersontemp);
			   
				// SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(newUser.getUsername(), newUser.getPassword(), (Collection<? extends GrantedAuthority>)newAuto.getAuthority() ));

				 
				 return "redirect:/market/products";
		}
	 





//		@RequestMapping(value = "/register/add", method = RequestMethod.POST)
//		public String Save(Model model, @ModelAttribute("newPerson") @Valid Person newPerson, @ModelAttribute("Users") Users user ,BindingResult result, HttpServletRequest request) {
//			
//			if(result.hasErrors()) {
//				   return "addPerson";
//			}
//			 System.out.println("Valores "+newPerson);
//				personService.savePerson(newPerson);
//				
//				System.out.println("clave"+ user.getPassword() );
//				Users newUser= new Users();
//				newUser.setUsername(newPerson.getEmail());
//				newUser.setPassword(newPerson.getFirstName());
//				newUser.setEnabled(true);
//				usersService.saveUsers(newUser);
//				Authorities newAuto= new Authorities();				
//				newAuto.setUsername(newUser);
//				newAuto.setAuthority("ROLE_USER");
//				authoritiesService.saveAuthorities(newAuto);
//			  
//				
//			   Person newPerson2 = new Person();
//			   model.addAttribute("newPerson", newPerson2);
//			   
//			return "redirect:/login";
//		}
		
}
