package edu.mum.coffee.controller;
import com.google.gson.Gson;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("rest/order/")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PersonService personService;
	
	//http://localhost:8081/rest/order/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Order> list() {
		return orderService.findAll();
	}
	
	//http://localhost:8081/rest/order/add	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Order Save(@RequestBody Order order) {
		for(Orderline ol:order.getOrderLines())
			ol.setOrder(order);
		return orderService.save(order);
	}


	//http://localhost:8081/rest/order/update	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void Update(@RequestBody Order order) {
		for(Orderline ol:order.getOrderLines())
			ol.setOrder(order);
		orderService.save(order);
	}

	//http://localhost:8081/rest/order/delete	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void Delete(@RequestBody Order order) {
		for(Orderline ol:order.getOrderLines())
			ol.setOrder(order);
		orderService.delete(order);
	}
	
}
