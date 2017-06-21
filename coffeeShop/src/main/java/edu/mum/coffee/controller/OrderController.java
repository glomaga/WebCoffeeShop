package edu.mum.coffee.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.service.OrderService;

@Controller
@RequestMapping("market")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/admin")
	public String list(Model model) {
	   model.addAttribute("orders", orderService.findAll());
	   return "AdminOrder";
	}
	

	@RequestMapping("/order/admin/delete/{orderKey}")
	public String Delete(Model model, @PathVariable("orderKey") int orderKey) {
		Order temp= orderService.findById(orderKey);
		orderService.delete(temp);
				   model.addAttribute("orders", orderService.findAll());
		return "redirect:/market/order/admin";
	}
	
	
	@RequestMapping("/order/admin/line/{orderKey}")
	public String listLine(Model model, @PathVariable("orderKey") int orderKey) {
	   model.addAttribute("orderlines", orderService.findById(orderKey).getOrderLines());
	   return "AdminOrderline";
	}
	
	
	@RequestMapping("/order/admin/line/delete/{orderKey}/{lineKey}")
	public String DeleteLine(Model model,@PathVariable("orderKey") int orderKey,@PathVariable("lineKey") int lineKey) {
	//	System.out.println("Entro" + orderKey);
	//	System.out.println("Entro line" + lineKey);
		
		Order temp= orderService.findById(orderKey);
		
	//	System.out.println("order a modificar "+ temp.getId());
		List<Orderline> lines= temp.getOrderLines();
		Orderline tempdelete = null;
		for (Orderline orderline : lines) {
			if (orderline.getId()==lineKey){
				tempdelete=orderline;
			}
		}
		//System.out.println("line a eliminar "+ tempdelete.getId());
		temp.removeOrderLine(tempdelete);
		orderService.save(temp);
		// model.addAttribute("orderlines", temp.getOrderLines());
		return "redirect:/market/order/admin/line/"+orderKey;
	}

	
//	@RequestMapping("/order/admin/line/delete")
//	public String DeleteLine(Model model, @RequestParam("lineKey") String lineKey1, @RequestParam("orderKey") String orderKey1) {
//		int orderKey= Integer.parseInt(orderKey1);
//		int lineKey= Integer.parseInt(lineKey1);
//		Order temp= orderService.findById(orderKey);
//		List<Orderline> lines= temp.getOrderLines();
//		Orderline tempdelete = null;
//		for (Orderline orderline : lines) {
//			if (orderline.getId()==lineKey){
//				tempdelete=orderline;
//			}
//		}
//		System.out.println("line a eliminar "+ tempdelete);
//		temp.removeOrderLine(tempdelete);
//		 model.addAttribute("orderlines", orderService.findById(orderKey).getOrderLines());
//		  return "AdminOrderline";
//	}
	
}
