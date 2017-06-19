package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("rest/order/")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	//http://localhost:8081/rest/order/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Order> list() {
		return orderService.findAll();
	}
	
	//http://localhost:8081/rest/order/add	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void Save(@RequestBody Order order) {
		orderService.save(order);
	}
	

	//http://localhost:8081/rest/order/update	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void Update(@RequestBody Order order) {
		orderService.save(order);
	}

	//http://localhost:8081/rest/order/delete	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void Delete(@RequestBody Order order) {
		orderService.delete(order);
	}
	
}
