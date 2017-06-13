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

import com.example.dao.MovieDAO;
import com.example.dao.TicketDAO;
import com.example.dao.TicketTypeDAO;
import com.example.dao.TimeSlotDAO;
import com.example.dao.TransactionDAO;
import com.example.entity.Movie;
import com.example.entity.ProductCategory;
import com.example.entity.ShoppingCart;
import com.example.entity.Ticket;
import com.example.entity.Ticket_type;
import com.example.entity.Time_slot;
import com.example.entity.Transaction;


@Controller
public class TicketController { 

	@Autowired
	TransactionDAO tran_dao;
	
	@Autowired
	TicketDAO ticketdao;
	
	@Autowired
	TicketTypeDAO ticket_type_dao;
	
	@Autowired
	MovieDAO moviedao;
	
	@Autowired
	TimeSlotDAO time_slotdao;
	
	@RequestMapping(value = "/movieSelect" , method = RequestMethod.GET)
	public ModelAndView movie(){
		Iterable<Movie> movie = moviedao.findAll();
		ModelAndView model = new ModelAndView("movieSelect");
		model.addObject("movie",movie);
		model.addObject("Transaction",new Transaction());
		return model;
	}
	@RequestMapping(value = "/movieSelect", method = RequestMethod.POST)
	public ModelAndView movieDone(@Valid @ModelAttribute("Transaction") Transaction tran,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("movieSelect");	           	         
	         return model;
	       }
		else{		
			tran_dao.save(tran);
			return new ModelAndView("timeSelect");
		}
	}

	@RequestMapping(value = "/timeSelect" , method = RequestMethod.GET)
	public ModelAndView time(){
		Iterable<Time_slot> time_slot = time_slotdao.findAll();
		ModelAndView model = new ModelAndView("timeSelect");
		model.addObject("time",time_slot);
		model.addObject("Transaction",new Transaction());
		return model;
	}
	
	@RequestMapping(value = "/timeSelect", method = RequestMethod.POST)
	public ModelAndView timeDone(@Valid @ModelAttribute("Transaction") Transaction tran,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("timeSelect");	           	         
	         return model;
	       }
		else{
			tran_dao.save(tran);
			return new ModelAndView("ticketSelect");
		}
	}
	
	
	
	 @RequestMapping(value = "/ticketSelect" , method = RequestMethod.GET)
	 public ModelAndView ticket(){
		 Iterable<Ticket_type> ticket_type = ticket_type_dao.findAll();
		 
		 ModelAndView model = new ModelAndView("ticketSelect");		
		// model.addObject("ticket_type",new Ticket_type());
		 model.addObject("ticket_type",ticket_type);
		 model.addObject("Transaction",new Transaction());
		 return model;
	 }
	

	@RequestMapping(value = "/ticketSelect", method = RequestMethod.POST)
	public ModelAndView ticketDone(@Valid @ModelAttribute("Transaction") Transaction tran,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("ticketSelect");	           	         
	         return model;
	       }
		else{
			tran_dao.save(tran);
			return new ModelAndView("seatsSelect");
		}
	}

	@RequestMapping("/seatsSelect")
	 public ModelAndView seat(){
		 ModelAndView model = new ModelAndView("registration_success");		 	 
		 return model;
	 }
	@RequestMapping(value = "/seatsSelect", method = RequestMethod.POST)
	public ModelAndView seatDone(@Valid @ModelAttribute("Ticket") Ticket ticket,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("ticketSelect");	           	         
	         return model;
	       }
		else{
			ticketdao.save(ticket);
			return new ModelAndView("seatsSelect");
		}
	}

	 
	}

	



