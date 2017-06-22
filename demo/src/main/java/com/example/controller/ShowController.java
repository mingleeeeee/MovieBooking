package com.example.controller;

import com.example.dao.ShowDAO;
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

import com.example.entity.Movie;
import com.example.entity.MovieCategory;
import com.example.entity.Show;
import com.example.entity.Users;

@Controller
public class ShowController {
	
	@Autowired
	ShowDAO showdao;
	
	
	@RequestMapping(value = "/admin/showCreate" , method = RequestMethod.GET)
	 public ModelAndView moviePhoto(){
		
		 ModelAndView model = new ModelAndView("/admin/showCreate");			
		 model.addObject("Show",new Show());
			
		 return model;
	 }
	 @RequestMapping(value = "/admin/show/Create", method = RequestMethod.POST)
	    public ModelAndView processFormCreate(@ModelAttribute Show show) throws SQLException {

	       
	      
	       showdao.save(show);
	       
	       ModelAndView model = new ModelAndView("/admin/showCreate");
	       
	       return model;
	    }
	 
	 @RequestMapping(value = "/admin/showUpdate", method = RequestMethod.GET)
		public ModelAndView openFormUpdate(
				@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {
			ModelAndView model = new ModelAndView("/admin/showUpdate");
			Show show = showdao.findOne(id);
			model.addObject("Show", show);


			return model;
		}

		@RequestMapping(value = "/admin/showUpdate", method = RequestMethod.POST)
		public ModelAndView processFormUpdate(@Valid @ModelAttribute Show show,
				BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				ModelAndView model = new ModelAndView("/admin/showUpdate");
			
				return model;
			} else {
				showdao.save(show);

				return new ModelAndView("redirect:/showSelect");
			}
		}

		@RequestMapping(value = "/admin/showDelete", method = RequestMethod.GET)
		public ModelAndView deleteProduct(
				@RequestParam(value = "id", required = false, defaultValue = "1") Long id){
			showdao.delete(id);

			return new ModelAndView("redirect:/showSelect");
		}
	
	
}
