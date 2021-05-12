package com.ernest.productsandcategories.controllers;

import java.util.List; 
import java.util.Optional;

import javax.persistence.JoinColumn;
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


import com.ernest.productsandcategories.models.Category;
import com.ernest.productsandcategories.models.CategoryProduct;
import com.ernest.productsandcategories.models.Product;
import com.ernest.productsandcategories.services.CategoryService;
import com.ernest.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private final CategoryService categoryService;
	private final ProductService productService;
	public MainController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	//=========================================
	//test page
	//========================================= 
	
//	@RequestMapping("/")
//	public String index() {
//		return "/categoryProduct/test.jsp";
//	}
	
	//==========================================================================
	//add new product
	//==========================================================================
		
	@RequestMapping("products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/categoryProduct/newproduct.jsp";
	}
		
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String productCreate(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/categoryProduct/newproduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
		
		
	//==========================================================================
	//add new product
	//==========================================================================
			
	@RequestMapping("categories/new")
	public String newCategory(@ModelAttribute("category") Category  category) {
		return "/categoryProduct/newCategory.jsp";
	}
			
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String categoryCreate(@Valid @ModelAttribute("category") Category  category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categoryProduct/newCategory.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
			
			
			
	//==============================================================================
	//display Product with all of its categories
	//==============================================================================
			
	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product products = productService.findProduct(id);
		List<Category> currentProductCategories = products.getCategories();
		List<Category> otherCategories = categoryService.allCategorys();
		otherCategories.removeAll(currentProductCategories);
		model.addAttribute("products", currentProductCategories);
		model.addAttribute("categories", otherCategories);
		model.addAttribute("products", products );
		

		 			
		return "/categoryProduct/showProduct.jsp";
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id") Long product_id,
			@RequestParam(value="category_id") Long category_id) {
		
		Category c = categoryService.findCategory(category_id);
		Product p = productService.findProduct(product_id);
		
		CategoryProduct cp = new CategoryProduct(c, p);
		productService.saveRelationship(cp);
		
		return"redirect:/product/{id}";
	}
	
	//==============================================================================
	//display categories with all of its product
	//==============================================================================
		
	@RequestMapping("category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category categories = categoryService.findCategory(id);
		List<Product> currentCategoriesProduct = categories.getProducts();
		List <Product> products = productService.allProduct();
		products.removeAll(currentCategoriesProduct);
		model.addAttribute("categories", currentCategoriesProduct);
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		 
		return "/categoryProduct/showCategory.jsp";
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.POST)
	public String addProduct(@PathVariable("id") Long category_id,
			@RequestParam(value="product_id") Long product_id) {
		
		Category c = categoryService.findCategory(category_id);
		Product p = productService.findProduct(product_id);
		
		CategoryProduct cp = new CategoryProduct(c, p);
		productService.saveRelationship(cp);
		
		return"redirect:/category/{id}";
	}
	
}
