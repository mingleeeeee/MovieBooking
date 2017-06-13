package com.example.controller;

 

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.ProductCategoryDAO;
import com.example.dao.ProductDAO;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.ShoppingCart;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;

	@Autowired
	ProductCategoryDAO categoryDao;
	
	 @Autowired
	 ShoppingCart cart;
	 
	 @RequestMapping(value = "/hi", method = RequestMethod.GET)
	    public ModelAndView openFormLogin() {
	       ModelAndView model = new ModelAndView("productCreate");
	   
	       return model;
	    }

	    @RequestMapping(value = "/HelloWithId", method = RequestMethod.POST)
	    public ModelAndView processForm(@ModelAttribute("id") String id, HttpSession session) {
	       ModelAndView model = new ModelAndView("redirect:/productRetrieveAll");
	       session.setAttribute("loginId", id);
	       return model;
	    }
	
	
	@RequestMapping(value = "/productCreate", method = RequestMethod.GET)
	public ModelAndView openFormCreate() {
		ModelAndView model = new ModelAndView("productCreate");

		//Iterable<Product> Product = dao.findAll();
		Iterable<ProductCategory> categories = categoryDao.findAll();

		model.addObject("Product", new Product());
		model.addObject("allProductCategories", categories);
		return model;
	}

	@RequestMapping(value = "/productCreate", method = RequestMethod.POST)
	public ModelAndView processFormCreate(@Valid @ModelAttribute("Product") Product product,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("productCreate");	    
	         Iterable<ProductCategory> categories = categoryDao.findAll();
	         model.addObject("allProductCategories", categories);
	         return model;
	       }
		else{
			dao.save(product);
			return new ModelAndView("redirect:/productRetrieveAll");
		}
	}

	@RequestMapping(value = { "/productRetrieveAll", "/product" }, method = RequestMethod.GET)
	public ModelAndView retrieveProducts() {

		ModelAndView model = new ModelAndView("productList");
		Iterable<ProductCategory> categories = categoryDao.findAll();
		model.addObject("allProductCategories", categories);
		ProductCategory category = categories.iterator().next();//get first category
		model.addObject("ProductCategory", category);

		Iterable<Product> pros = dao.findAll();
		model.addObject("allProducts", pros);
		return model;
	}

	@RequestMapping(value = { "/productRetrieveByCategory" }, method = RequestMethod.POST)
	public ModelAndView retrieveProductsByCategory(
			@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
/*
	public ModelAndView retrieveProductsByCategory(@ModelAttribute ProductCategory category) {
*/
		ModelAndView model = new ModelAndView("productList");
		// ProductCategory category = new ProductCategory();
		// category.setId(id);
		// Iterable<Product> pros = dao.findByProductCategory(category);
		
		//System.out.println(category.getName());
		Iterable<ProductCategory> categories = categoryDao.findAll();
		model.addObject("allProductCategories", categories);
		ProductCategory category = categoryDao.findOne(id);
		model.addObject("ProductCategory", category);
		
		model.addObject("allProducts", category.getProducts());
		// model.addObject("allProducts",products);
		// model.addObject(allProducts);
		return model;
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.GET)
	public ModelAndView openFormUpdate(
			@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
		ModelAndView model = new ModelAndView("productUpdate");
		Product product = dao.findOne(id);
		model.addObject("Product",product);
		
		ProductCategory category = categoryDao.findOne(id);
		model.addObject("ProductCategory", category);
		
		Iterable<ProductCategory> categories = categoryDao.findAll();
		model.addObject("allProductCategories", categories);

		return model;
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
	public ModelAndView processFormUpdate(@Valid @ModelAttribute("Product") 
	Product product, Iterable<ProductCategory> categories,BindingResult bindingResult) 
	throws SQLException{
		if(bindingResult.hasErrors())
			return new ModelAndView("productUpdate").addObject("allProductCategories", categories);
		else{
			dao.save(product);
			return new ModelAndView("redirect:/productRetrieveAll");
		}
	}

	@RequestMapping(value = "/productDelete", method = RequestMethod.GET)
	public ModelAndView deleteProduct(
			@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
		ModelAndView model = new ModelAndView("redirect:/productRetrieveAll");

		dao.delete(id);

		return model;
	}
	
	 @RequestMapping(value = "/shoppingCartAdd", method = RequestMethod.GET)
	 public ModelAndView addShoppingCart(
	   @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
	  ModelAndView model = new ModelAndView("redirect:/productRetrieveAll");
	  Product pro = dao.findOne(id);
	  cart.add(pro);

	  return model;
	 }

	 @RequestMapping(value = "/shoppingCartList", method = RequestMethod.GET)
	 public ModelAndView showShoppingCart() {
	  ModelAndView model = new ModelAndView("shoppingCart");
	  return model;
	 }

	 @RequestMapping(value = "/cleanShoppingCart", method = RequestMethod.GET)
	 public ModelAndView cleanShoppingCart() {
	  ModelAndView model = new ModelAndView("shoppingCart");
	  cart.cleanup();
	  return model;
	 }
	 
	}

	
	/**
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String firstPage(){
		return "hi";
	}
	
	@RequestMapping(value = "/helloWithId", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("id") String name){
		if(name.equals("sa"))
			return new ModelAndView("redirect:/productRetrieveAll");
		else
			return (new ModelAndView("hello")).addObject("name", name);
	}
	**/


