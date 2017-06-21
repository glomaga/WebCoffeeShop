package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("rest/person/")
public class PersonRestController {

	@Autowired
	private PersonService personService;
	
	//http://localhost:8081/rest/person/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Person> list() {
		return personService.getAllPerson();
	}
	
	//http://localhost:8081/rest/person/add	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Person Save(@RequestBody Person person) {
		System.out.println("Datos que llegaron"+ person );
	return	personService.savePerson(person);

	}
	

	//http://localhost:8081/rest/person/update	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void Update(@RequestBody Person person) {
		personService.savePerson(person);
	}

	//http://localhost:8081/rest/person/delete	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void Delete(@RequestBody Person person) {
		personService.removePerson(person);
	}
	
	//http://localhost:8081/rest/person/seach	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public Person Search(@RequestParam("PersonKey") Long PersonKey) {
		return personService.findById(PersonKey);
	}
	
}
