package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.AuthoritiesService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.UsersService;

@RestController
@RequestMapping(value = "rest/register")
public class RegisterRestController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	//http://localhost:8081/rest/register/check	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public int Save(@RequestBody String username) {	
		username =username.replace("%40", "@").substring(9);
		List<Person> a= personService.findByEmail(username.trim());
		if(a.isEmpty()){
			return 1;
		}else{

			return -1;
		}
	}
	 
}
