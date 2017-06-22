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

import com.pms.model.User;
import com.pms.service.T30001Service;
import com.pms.service.UserService;

@Controller
public class T30001Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30001Service t30001Service;
	
	
	//request for t30001 page
	@RequestMapping(value="/admin/t30001", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30001",t30001Service.findAll());
		modelAndView.setViewName("admin/t30001");
		return modelAndView;
	}
	
	//save t30001
	@RequestMapping(value="/admin/saveT30001", method = RequestMethod.POST)
	public ModelAndView saveT30001(@Valid T30001 t30001, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("form code "+t30001.getTdrugformcode());
		//set entry user and date
		if(t30001.getTdrugformcode().equals("")){
			t30001.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30001.setT_entry_date(sqlDate);
		}else{
			//for update first take database object
		    T30001 upt30001 = t30001Service.findByTdrugformcode(t30001.getTdrugformcode());
		    upt30001.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30001.setT_upd_date(sqlDate);
		    upt30001.setT_lang2_name(t30001.getT_lang2_name());
		    
		    t30001=upt30001;
		}
	
		//save T30001
		t30001Service.saveT30001(t30001);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30001");
		return modelAndView;
	}
	
	//save t30001
		@RequestMapping(value="/admin/deleteT30001", method = RequestMethod.POST)
		public ModelAndView deleteT30001(@Valid T30001 t30001, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete Manufacture code
			t30001Service.deleteT30001(t30001);
			
			//go to html page with parameter
			modelAndView.addObject("t30001",t30001Service.findAll());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30001");
			return modelAndView;
		}
}
