package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping("rest/products/")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	//http://localhost:8081/rest/products/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Product> list() {
		return productService.getAllProduct();
	}
	
	//http://localhost:8081/rest/products/add	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void Save(@RequestBody Product product) {
		 productService.save(product);
	}
	

	//http://localhost:8081/rest/products/update	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void Update(@RequestBody Product product) {
		 productService.save(product);
	}

	//http://localhost:8081/rest/products/delete	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public void Delete(@RequestBody Product product) {
		 productService.delete(product);
	}
	
}
