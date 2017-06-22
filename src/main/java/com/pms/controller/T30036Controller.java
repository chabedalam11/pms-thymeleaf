package com.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.model.T30001;
import com.pms.model.T30036;
import com.pms.model.User;
import com.pms.service.T30001Service;
import com.pms.service.T30036Service;
import com.pms.service.UserService;

@Controller
public class T30036Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30036Service t30036Service;
	
	
	//request for t30036 page
	@RequestMapping(value="/admin/t30036", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30036",t30036Service.findAll());
		modelAndView.setViewName("admin/t30036");
		return modelAndView;
	}
	
	//save t30036
	@RequestMapping(value="/admin/saveT30036", method = RequestMethod.POST)
	public ModelAndView saveT30036(@Valid T30036 t30036, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("Unit magarment code "+t30036.getTum());
		//set entry user and date
		if(t30036.getTum().equals("")){
			t30036.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30036.setT_entry_date(sqlDate);
		}else{
			//for update first take database object
		    T30036 upt30036 = t30036Service.findByTum(t30036.getTum());
		    upt30036.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30036.setT_upd_date(sqlDate);
		    upt30036.setT_lang2_name(t30036.getT_lang2_name());
		    
		    t30036=upt30036;
		}
	
		//save T30036
		t30036Service.saveT30036(t30036);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30036");
		return modelAndView;
	}
	
	
	//delete t30036
		@RequestMapping(value="/admin/deleteT30036", method = RequestMethod.POST)
		public ModelAndView deleteT30036(@Valid T30036 t30036, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete Manufacture code
			t30036Service.deleteT30036(t30036);
			
			//go to html page with parameter
			modelAndView.addObject("t30036",t30036Service.findAll());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30036");
			return modelAndView;
		}
}
