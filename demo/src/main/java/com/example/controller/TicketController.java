package com.example.controller;

 

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dao.MovieCategoryDAO;
import com.example.dao.MovieDAO;
//import com.example.dao.OrderDAO;
import com.example.dao.ShowDAO;
import com.example.dao.TicketDAO;
import com.example.dao.TicketTypeDAO;
import com.example.dao.TimeSlotDAO;
import com.example.entity.Movie;
import com.example.entity.MovieCategory;
import com.example.entity.Order;
//import com.example.entity.Order;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.ShoppingCart;
import com.example.entity.Show;
import com.example.entity.Ticket;
import com.example.entity.Ticket_type;
import com.example.entity.Time_slot;
import com.example.storage.StorageFileNotFoundException;
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
	@Autowired
	ShowDAO showdao;
	@Autowired
	MovieCategoryDAO movieCategorydao;
	//OrderDAO orderdao;
	
	 @Autowired
	 ShoppingCart cart;
	
	 private final StorageService storageService;	 
	 
		
	 // main 
	@RequestMapping(value = "/movieSelect" , method = RequestMethod.GET)
	public ModelAndView movie( @ModelAttribute Movie mov){
		     
		Iterable<Movie> movie = moviedao.findAll();
		ModelAndView model = new ModelAndView("movieSelect");
		
		Iterable<MovieCategory> movieCategory = movieCategorydao.findAll();
		  model.addObject("allMovieCategories", movieCategory);
			  
		  MovieCategory category = movieCategory.iterator().next();
			model.addObject("movieCategory", category);
			
		cart.cleanup();
		model.addObject("movie",movie);
		return model;
	}
	
	@RequestMapping(value = { "/movieRetrieveByCategory" }, method = RequestMethod.POST)
	 public ModelAndView retrieveMoviesByCategory(
	   @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
	  ModelAndView model = new ModelAndView("movieSelect");
	  
	  if ( id == 1 ){
		  
		  Iterable<MovieCategory> movieCategory = movieCategorydao.findAll();
		  model.addObject("allMovieCategories", movieCategory);
			  
		  MovieCategory category = movieCategory.iterator().next();
			model.addObject("movieCategory", category);
		  Iterable<Movie> movie = moviedao.findAll();
		  model.addObject("movie",movie);
		  return model;
	  }
	  
	  Iterable<MovieCategory> categories = movieCategorydao.findAll();
		model.addObject("allMovieCategories", categories);
		MovieCategory category = movieCategorydao.findOne(id);
		model.addObject("movieCategory", category);
		model.addObject("movie", category.getMovies());
		

	  return model;
	 }

	@RequestMapping(value = "/showSelect" , method = RequestMethod.GET)
	public ModelAndView showSelect(
			@RequestParam(value = "movie_id", required = false, defaultValue = "1") Long id){
		Movie movie = moviedao.findOne(id);
		
		//Order order = orderdao.findOne(id);
		//cart.add(order);
		
		ModelAndView model = new ModelAndView("showSelect");		
		model.addObject("movie",movie);
		model.addObject("show",movie.getMovie_show());
		
		return model;
	}
		
	 @RequestMapping(value = "/ticketSelect" , method = RequestMethod.GET)
	 public ModelAndView ticketSelect(
			 @RequestParam(value = "show_id", required = false, defaultValue = "1") Long id, HttpSession session){
		 
		 session.setAttribute("show_id", id);
		 session.getAttribute("amount");
		 Iterable<Ticket_type> ticket_type = ticket_type_dao.findAll();
		
		 ModelAndView model = new ModelAndView("ticket");		
		 model.addObject("ticket_type",ticket_type);
		 model.addObject("Order",new Order());
		 return model;
	 }
	 
	 
	 @RequestMapping(value = "/seatSelect" , method = RequestMethod.GET)
	 public ModelAndView seatSelect( @ModelAttribute("Ticket") Ticket ticket,
			 @RequestParam(value = "ticket_type_id", required = false, defaultValue = "1") Long id){
		 Ticket_type ticket_type = ticket_type_dao.findOne(id);
		 
		 //Order order = orderdao.findOne(id);
			//cart.add(order);
		 
		 ticketdao.save( ticket);
		 ModelAndView model = new ModelAndView("seatSelect");		
		// model.addObject("ticket_type",new Ticket_type());
		 
		 return model;
	 }
	
	 	
	// Shopping cart
	
	 @RequestMapping(value = "/shoppingCartAdd", method = RequestMethod.POST)
	 public ModelAndView addShoppingCart(  @ModelAttribute("Order") Order order, HttpSession session,			
	   @RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
	  ModelAndView model = new ModelAndView("ticket");
	  
	  boolean SameId = false;
	  if(cart.getCart().isEmpty()){
		  cart.add(order);
	  }
	  else{	  
		  int ticket_type_id = order.getTicket_type_id();
		  for(int i = 0 ; i < cart.getCart().size(); i++){
			  int Id = cart.getCart().get(i).getTicket_type_id(); 
			  if (  Id == ticket_type_id ){
				  SameId = true;
				  cart.getCart().get(i).setAmount(order.getAmount());
				  
				  break;
			  }
			  
		  }
		  if (!SameId)
			  cart.add(order);
	  }
	  Iterable<Ticket_type> ticket_type = ticket_type_dao.findAll();
	  model.addObject("ticket_type",ticket_type);
	  
	 

	  return model;
	 }

	 @RequestMapping(value = "/shoppingCartDelete", method = RequestMethod.GET)
	 public ModelAndView ShoppingDelete( 
			 @RequestParam(value = "id", required = false, defaultValue = "1") int id)  {
	  ModelAndView model = new ModelAndView("ticket");
	  Iterable<Ticket_type> ticket_type = ticket_type_dao.findAll();
				
		 model.addObject("ticket_type",ticket_type);
		 model.addObject("Order",new Order());
	  cart.cleanup();
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
	 
	 /**
	 @RequestMapping(value = "/shoppingCartCheckOut", method = RequestMethod.GET)
		public ModelAndView CheckOutShoppingCart() {
			ModelAndView model = new ModelAndView("redirect:/cleanShoppingCart");
			for(int i = 0; i < cart.getCart().size(); i++){
				Order oneOrder = cart.getCart().get(i);
				Ticket ticket = oneOrder.getChosenProduct();
				int amount = oneOrder.getAmount();
				int newStock = ticket.getStock() - amount;
				ticket.setStock(newStock);
				dao.save(ticket);
			}
			
			return model;
		}
	 **/

	    @Autowired
	    public TicketController(StorageService storageService) {
	        this.storageService = storageService;
	    }    
	    
	    @ResponseBody
	    @RequestMapping(value= "/files/{filename:.+}",method = RequestMethod.POST )
	    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

	        Resource file = (Resource) storageService.loadAsResource(filename);
	        return ResponseEntity
	                .ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+((org.springframework.core.io.Resource) file).getFilename()+"\"")
	                .body(file);
	    }
	   
	    @RequestMapping(value = "/admin/movieCreate" , method = RequestMethod.GET)
		 public ModelAndView moviePhoto(){
			
			 ModelAndView model = new ModelAndView("/admin/movieCreate");			
			 model.addObject("Movie",new Movie());
			 
			 Iterable<MovieCategory> categories = movieCategorydao.findAll();
				model.addObject("allMovieCategories", categories);
				
			 return model;
		 }
		 @RequestMapping(value = "/admin/movieCreate", method = RequestMethod.POST)
		    public ModelAndView processFormCreate(@ModelAttribute Movie movie) throws SQLException {

		       
		       storageService.store(movie.getPhotoFile());
		       movie.setPhoto();//copy file name to the field photo
		       //cus.setPhoto(cus.getPhotoFile().getOriginalFilename());//copy file name to the field photo
		       
		       moviedao.save(movie);
		       
		       ModelAndView model = new ModelAndView("/admin/movieCreate");
		       
		       return model;
		    }
		 
		 @RequestMapping(value = "/admin/movieUpdate", method = RequestMethod.GET)
			public ModelAndView openFormUpdate(
					@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
				ModelAndView model = new ModelAndView("/admin/movieUpdate");
				Movie movie = moviedao.findOne(id);
				model.addObject("Movie", movie);

				MovieCategory category = movie.getMovieCategory();
				model.addObject("movieCategory", category);

				Iterable<MovieCategory> categories = movieCategorydao.findAll();
				model.addObject("allMovieCategories", categories);

				return model;
			}

			@RequestMapping(value = "/admin/movieUpdate", method = RequestMethod.POST)
			public ModelAndView processFormUpdate(@Valid @ModelAttribute Movie movie,
					BindingResult bindingResult) {
				if (bindingResult.hasErrors()) {
					ModelAndView model = new ModelAndView("/admin/movieUpdate");
					Iterable<MovieCategory> categories = movieCategorydao.findAll();
					model.addObject("allMovieCategories", categories);

					return model;
				} else {
					moviedao.save(movie);

					return new ModelAndView("redirect:/movieSelect");
				}
			}

			@RequestMapping(value = "/admin/movieDelete", method = RequestMethod.GET)
			public ModelAndView deleteProduct(
					@RequestParam(value = "id", required = false, defaultValue = "1") Long id){
				moviedao.delete(id);

				return new ModelAndView("redirect:/movieSelect");
			}
		
}

	



