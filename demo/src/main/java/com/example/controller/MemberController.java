package com.example.controller;

import com.example.dao.AuthorityDAO;
import com.example.dao.UsersDAO;

import java.sql.SQLException;

import javax.persistence.Table;
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

import com.example.entity.Authority;
import com.example.entity.Users;

@Controller
public class MemberController {
	
	@Autowired
	UsersDAO usersdao; 
	
	@Autowired
	AuthorityDAO authoritydao;
	
	@RequestMapping(value = "/registration" , method = RequestMethod.GET)
	public ModelAndView openFormCreate(){
		ModelAndView model = new ModelAndView("/registration");
		model.addObject("Users",new Users());
		return model;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("Users") Users users,  BindingResult bindingResult)
			 {
		ModelAndView model;
		if (bindingResult.hasErrors()) {
			
	         model = new ModelAndView("registration");	           	         
	         return model;
	       }
		else{
			model=new ModelAndView("redirect:/user/index");
			model.addObject(users);	
			Authority authority = new Authority();
			authority.setUser(users);
			
			usersdao.save(users);
			authoritydao.save(authority);
			return model;
		}
	}
	
	

}
