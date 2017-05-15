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

import com.pms.model.T30004;
import com.pms.model.T30007;
import com.pms.model.User;
import com.pms.service.T30007Service;
import com.pms.service.UserService;

@Controller
public class T30007Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30007Service t30007Service;
	
	
	//request for t30004 page
	@RequestMapping(value="/admin/t30007", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30007",t30007Service.findAll());
		modelAndView.setViewName("admin/t30007");
		return modelAndView;
	}
	
	//save t30004
	@RequestMapping(value="/admin/saveT30007", method = RequestMethod.POST)
	public ModelAndView saveT30007(@Valid T30007 t30007, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("manu code "+t30007.getTmanufacturercode());
		//set entry user and date
		if(t30007.getTmanufacturercode().equals("")){
			t30007.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30007.setT_entry_date(sqlDate);
		}else{
			//for update first take database object
		    T30007 upt30007 = t30007Service.findByTmanufacturercode(t30007.getTmanufacturercode());
		    upt30007.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30007.setT_upd_date(sqlDate);
		    upt30007.setT_lang2_name(t30007.getT_lang2_name());
		    
		    t30007=upt30007;
		}
		
		//save T30007
		t30007Service.saveT30007(t30007);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30007");
		return modelAndView;
	}
	
	//save t30004
		@RequestMapping(value="/admin/deleteT30007", method = RequestMethod.POST)
		public ModelAndView deleteT30007(@Valid T30007 t30007, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete Manufacture code
			t30007Service.deleteT30007(t30007);
			
			//go to html page with parameter
			modelAndView.addObject("t30007",t30007Service.findAll());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30007");
			return modelAndView;
		}
}
