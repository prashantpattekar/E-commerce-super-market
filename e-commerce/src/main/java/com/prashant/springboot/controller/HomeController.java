package com.prashant.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prashant.springboot.service.CategoryService;
import com.prashant.springboot.service.ProductService;

@Controller
public class HomeController {

	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/", "/home", "/index"})
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		return "shop";
		
	} 
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model ,@PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		return "shop";
		
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		model.addAttribute("product",productService.getProductById(id).get());
		return "viewProduct";
	}
	
	
}
