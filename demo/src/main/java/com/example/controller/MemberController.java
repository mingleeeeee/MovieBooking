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

import com.example.dao.MemberDAO;
import com.example.entity.Member;
import com.example.entity.ShoppingCart;


@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	 @Autowired
	 ShoppingCart cart;
	 

	 @RequestMapping("/registration")
	 public ModelAndView registration(){
		 ModelAndView model = new ModelAndView("registration");
		 model.addObject("Member",new Member());
		 
		 return model;
	 }
	

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView processFormCreate(@Valid @ModelAttribute("Member") Member member,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("registraion");	           	         
	         return model;
	       }
		else{
			dao.save(member);
			return new ModelAndView("redirect:/memberInfo");
		}
	}

	@RequestMapping("/memberInfo")
	 public ModelAndView memberInfo(){
		 ModelAndView model = new ModelAndView("memberInfo");
		 model.addObject("Member",new Member());
		 
		 return model;
	 }
	 
	}

	



