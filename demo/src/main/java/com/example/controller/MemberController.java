package com.example.controller;

import com.example.dao.MemberDAO;

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

import com.example.dao.MovieDAO;
import com.example.dao.TicketDAO;
import com.example.dao.TicketTypeDAO;
import com.example.dao.TimeSlotDAO;
import com.example.entity.Member;
import com.example.entity.Movie;
import com.example.entity.ProductCategory;
import com.example.entity.ShoppingCart;
import com.example.entity.Ticket;
import com.example.entity.Ticket_type;
import com.example.entity.Time_slot;
@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memberdao;
	
	@RequestMapping(value = "/registration" , method = RequestMethod.GET)
	public ModelAndView openFormCreate(){
		ModelAndView model = new ModelAndView("/registration");
		model.addObject("Member",new Member());
		return model;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("Member") Member member,  BindingResult bindingResult)
			 {
		ModelAndView model;
		if (bindingResult.hasErrors()) {
			
	         model = new ModelAndView("registraction");	           	         
	         return model;
	       }
		model=new ModelAndView("redirect:/user/index");
		model.addObject(member);	
		memberdao.save(member);
		return model;
		
	}

}
