package edu.mum.coffee.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.ProductService;


@Controller
@RequestMapping("market")
public class ProductController {

	@Autowired
	private ProductService productService;
	

	@RequestMapping("/products")
	public String list(Model model) {
	   model.addAttribute("products", productService.getAllProduct());
	   return "products";
	}
	

	@RequestMapping(value = "/products/admin", method = RequestMethod.GET)
	public String getAdminProductForm(Model model) {
	   Product newProduct = new Product();
	   model.addAttribute("newProduct", newProduct);
	   model.addAttribute("types",ProductType.values());
	   model.addAttribute("products", productService.getAllProduct());
	   return "AdminProduct";
	}
	

	
	@RequestMapping(value = "/products/admin", method = RequestMethod.POST)
	public String Save(Model model, @ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			   return "AdminProduct";
		}
		System.out.println("Valores "+newProduct);
		 productService.save(newProduct);

		 Product temProduct = new Product();
		   model.addAttribute("newProduct", temProduct);
		   model.addAttribute("types",ProductType.values());
		   model.addAttribute("products", productService.getAllProduct());
		   
		return "redirect:/market/products/admin";
	}
	

	@RequestMapping("/products/admin/{productKey}")
	public String Update(Model model, @PathVariable("productKey") int productKey) {
		model.addAttribute("newProduct", productService.getProduct(productKey));
		   model.addAttribute("types",ProductType.values());
		   model.addAttribute("products", productService.getAllProduct());
		   return "AdminProduct";
	}

	@RequestMapping("/products/admin/delete/{productKey}")
	public String Delete(Model model, @PathVariable("productKey") int productKey) {
		Product temp= productService.getProduct(productKey);
		productService.delete(temp);
		  Product temProduct = new Product();
		   model.addAttribute("newProduct", temProduct);
		   model.addAttribute("types",ProductType.values());
		   model.addAttribute("products", productService.getAllProduct());
		return "redirect:/market/products/admin";
	}
	
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") int productId, Model model) {
	   model.addAttribute("product", productService.getProduct(productId));
	   return "product";
	}
	
}
