package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PersonService personService;
	
	// http://localhost:8081/rest/cart/84
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public Order read(@PathVariable(value = "cartId") int cartId) {
		return orderService.findById(cartId);
	}
	//
	// //http://localhost:8081/rest/cart/
	// @RequestMapping(value = "/", method = RequestMethod.PUT)
	// @ResponseStatus(value = HttpStatus.OK)
	// public void update(@RequestBody Order Order) {
	// //System.out.println("Entro a actualizar");
	// // System.out.println(Order);
	// orderService.save(Order);
	// }

	// http://localhost:8081/rest/cart/63
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "cartId") int cartId, HttpSession session) {
		Order temp = orderService.findById(cartId);
		orderService.delete(temp);
		session.removeAttribute("cartId");
	}

	// http://localhost:8081/rest/cart/add/{productId}
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addItem(@PathVariable int productId, HttpSession session, HttpServletRequest request) {

		if (session.getAttribute("cartId") == null) {
			 System.out.println("Es vacio!!!");
			Order newtemp = new Order();
			newtemp.setOrderDate(new Date());
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName(); //get logged in username is the email
		      Person newPerson = personService.findByEmail(name).get(0);
		      newtemp.setPerson(newPerson);
			int id = orderService.save(newtemp).getId();
			session.setAttribute("cartId", id);
		}
		// System.out.println("valor del la seccion antes de add
		// "+session.getAttribute("cartId").toString());
		int orderid = Integer.parseInt(session.getAttribute("cartId").toString());
		Order temp = orderService.findById(orderid);
		// System.out.println("Codigo Order a modificar:"+temp.getId());

		Product ptem = productService.getProduct(productId);
		// System.out.println("Codigo Producto a modificar:"+ptem.getId());

		Orderline ltem = new Orderline();
		ltem.setProduct(ptem);
		ltem.setOrder(temp);
		ltem.setQuantity(1);
		temp.addOrderLine(ltem);		
		orderService.save(temp);
	}

	// http://localhost:8081/rest/cart/remove/{productId}
	@RequestMapping(value = "/remove/{Order}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeItem(@PathVariable int Order, @RequestBody Orderline orderline, HttpSession session) {
		System.out.println("order " + Order);
		System.out.println("linea a eliminar " + orderline);
		Order saved = orderService.findById(Order);
		orderline.setOrder(saved);

		System.out.println("linea a eliminar " + orderline);
		saved.removeOrderLine(orderline);
		
		orderService.save(saved);
	}
}
