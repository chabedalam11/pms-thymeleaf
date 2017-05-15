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
import com.pms.model.User;
import com.pms.service.T30004Service;
import com.pms.service.UserService;

@Controller
public class T30004Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30004Service t30004Service;
	
	
	//request for t30004 page
	@RequestMapping(value="/admin/t30004", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30004",t30004Service.findAll());
		modelAndView.setViewName("admin/t30004");
		return modelAndView;
	}
	
	//save t30004
	@RequestMapping(value="/admin/saveT30004", method = RequestMethod.POST)
	public ModelAndView saveT30004(@Valid T30004 t30004, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		//set entry user and date
		if(t30004.getTgencode().equals("")){
			t30004.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30004.setT_entry_date(sqlDate);
		}else{
			
		    //for update first take database object
		    T30004 upt30004 = t30004Service.findByTgencode(t30004.getTgencode());
		    upt30004.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30004.setT_upd_date(sqlDate);
		    upt30004.setT_lang2_nam(t30004.getT_lang2_nam());
		    upt30004.setT_active_flag(t30004.getT_active_flag());
		    t30004=upt30004;
		}
		
		//save T30004
		t30004Service.saveT30004(t30004);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30004");
		return modelAndView;
	}
	
		//delete t30004
		@RequestMapping(value="/admin/deleteT30004", method = RequestMethod.POST)
		public ModelAndView deleteT30004(@Valid T30004 t30004, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete gencode
			t30004Service.deleteT30004(t30004);
			
			//go to html page with parameter
			modelAndView.addObject("t30004",t30004Service.findAll());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30004");
			return modelAndView;
		}
}
