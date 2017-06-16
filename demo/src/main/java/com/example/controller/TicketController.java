package com.example.controller;

 

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.MovieDAO;
import com.example.dao.ShowDAO;
import com.example.dao.TicketDAO;
import com.example.dao.TicketTypeDAO;
import com.example.dao.TimeSlotDAO;
import com.example.entity.Movie;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.ShoppingCart;
import com.example.entity.Show;
import com.example.entity.Ticket;
import com.example.entity.Ticket_type;
import com.example.entity.Time_slot;
import com.example.storage.StorageService;


@Controller
public class TicketController { 

	@Autowired
	TicketDAO ticketdao;
	@Autowired
	TicketTypeDAO ticket_type_dao;
	@Autowired
	MovieDAO moviedao;
	@Autowired
	TimeSlotDAO time_slotdao;
	ShowDAO showdao;
	
	 private final StorageService storageService;	 

	 @RequestMapping(value = "/moviePhoto" , method = RequestMethod.GET)
	 public ModelAndView moviePhoto(){
		
		 ModelAndView model = new ModelAndView("uploadForm");			
		 model.addObject("Movie",new Movie());
		 return model;
	 }
	 
	
	@RequestMapping(value = "/movieSelect" , method = RequestMethod.GET)
	public ModelAndView movie( @ModelAttribute Movie mov){
		
		
		//storageService.store(mov.getPhotoFile());
	      // mov.setPhoto();//copy file name to the field photo
	
	     //cus.setPhoto(cus.getPhotoFile().getOriginalFilename());//copy file name to the field photo
	      
		Iterable<Movie> movie = moviedao.findAll();
		ModelAndView model = new ModelAndView("movieSelect");
		model.addObject("movie",movie);
		
		return model;
	}
	/**
	@RequestMapping(value = "/movieSelect", method = RequestMethod.POST)
	public ModelAndView movieDone(@Valid @ModelAttribute("Ticket") Ticket ti,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {		
	         ModelAndView model = new ModelAndView("movieSelect");	           	         
	         return model;
	       }
		else{					
			return new ModelAndView("timeSelect");
		}
	}
	**/
	@RequestMapping(value = "/timeSelect" , method = RequestMethod.GET)
	public ModelAndView timeSelect(
			@RequestParam(value = "movie_id", required = false, defaultValue = "1") Long id){
		Movie movie = moviedao.findOne(id);
		
		ModelAndView model = new ModelAndView("timeSelect");		
		
		model.addObject("show",movie.getTime_slot());
		
		return model;
	}
	/**
	@RequestMapping(value = "/timeSelect", method = RequestMethod.POST)
	public ModelAndView timeDone(@Valid @ModelAttribute("") Movie mov,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("timeSelect");	           	         
	         return model;
	       }
		else{
			
			return new ModelAndView("ticketSelect");
		}
	}
	**/
	
	
	 @RequestMapping(value = "/ticketSelect" , method = RequestMethod.GET)
	 public ModelAndView ticketSelect(
			 @RequestParam(value = "movie_id", required = false, defaultValue = "1") Long id){
		 Movie movie = moviedao.findOne(id);
		 Iterable<Ticket_type> ticket_type = ticket_type_dao.findAll();
		 
		 ModelAndView model = new ModelAndView("ticketSelect");		
		// model.addObject("ticket_type",new Ticket_type());
		 model.addObject("show",movie.getMovie_show());	 
		 model.addObject("ticket_type",ticket_type);
		 model.addObject("Ticket",new Ticket());
		 return model;
	 }
	

	@RequestMapping(value = "/ticketSelect", method = RequestMethod.POST)
	public ModelAndView ticketDone(@Valid @ModelAttribute("Ticket") Ticket ticket,  BindingResult bindingResult)
			 throws SQLException{
		if (bindingResult.hasErrors()) {
			
	         ModelAndView model = new ModelAndView("ticketSelect");	           	         
	         return model;
	       }
		else{
			ticketdao.save(ticket);
			return new ModelAndView("movieSelect");
		}
	}

	
	    @Autowired
	    public TicketController(StorageService storageService) {
	        this.storageService = storageService;
	    }
	
	    @GetMapping("/files/{filename:.+}")
	    @ResponseBody
	    @RequestMapping
	    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

	        Resource file = (Resource) storageService.loadAsResource(filename);
	        return ResponseEntity
	                .ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+((org.springframework.core.io.Resource) file).getFilename()+"\"")
	                .body(file);
	    }
	 
	}

	



