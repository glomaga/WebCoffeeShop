package edu.mum.coffee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@Controller
@RequestMapping(value = "market/cart")
public class CartController {

	@Autowired
	private OrderService orderService;
	
   @RequestMapping
   public String get(HttpServletRequest request,HttpSession session) {
	  
	   if(session.getAttribute("cartId")==null){
		  return "cart";
	  }
	  else{
		  //System.out.println("valor del la seccion anterior "+request.getSession(true).getAttribute("cartId"));
		  return "redirect:/market/cart/"+request.getSession(true).getAttribute("cartId");
	  }
   }
   
   @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
   public String getCart(@PathVariable(value = "cartId") int cartId, Model model) {
      model.addAttribute("cartId",cartId);
      return "cart";
   }
   
   
}