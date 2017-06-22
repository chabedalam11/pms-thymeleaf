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

import com.pms.model.T30002;
import com.pms.model.User;
import com.pms.service.T30002Service;
import com.pms.service.UserService;

@Controller
public class T30002Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30002Service t30002Service;
	
	
	//request for t30002 page
	@RequestMapping(value="/admin/t30002", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30002",t30002Service.findAll());
		modelAndView.setViewName("admin/t30002");
		return modelAndView;
	}
	
	//save t30001
	@RequestMapping(value="/admin/saveT30002", method = RequestMethod.POST)
	public ModelAndView saveT30002(@Valid T30002 t30002, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("Route code "+t30002.getTdrugroutecode());
		//set entry user and date
		if(t30002.getTdrugroutecode().equals("")){
			t30002.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30002.setT_entry_date(sqlDate);
		}else{
			//for update first take database object
		    T30002 upt30002 = t30002Service.findByTdrugroutecode(t30002.getTdrugroutecode());
		    upt30002.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30002.setT_upd_date(sqlDate);
		    upt30002.setT_lang2_name(t30002.getT_lang2_name());
		    
		    t30002=upt30002;
		}
	
		//save T30002
		t30002Service.saveT30002(t30002);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30002");
		return modelAndView;
	}
	
	//save t30001
		@RequestMapping(value="/admin/deleteT30002", method = RequestMethod.POST)
		public ModelAndView deleteT30002(@Valid T30002 t30002, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete Manufacture code
			t30002Service.deleteT30002(t30002);
			
			//go to html page with parameter
			modelAndView.addObject("t30002",t30002Service.findAll());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30002");
			return modelAndView;
		}
}
