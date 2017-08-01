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

import com.pms.model.T30118;
import com.pms.model.User;
import com.pms.service.T30118Service;
import com.pms.service.UserService;

@Controller
public class T30118Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30118Service t30118Service;
	
	
	//request for t30118 page
	@RequestMapping(value="/admin/t30118", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30118",t30118Service.findAll());
		modelAndView.setViewName("admin/t30118");
		return modelAndView;
	}
	
	//save t30118
	@RequestMapping(value="/admin/saveT30118", method = RequestMethod.POST)
	public ModelAndView saveT30118(@Valid T30118 t30118, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("form code "+t30118.getTvendorcode());
		//set entry user and date
		/*if(t30118.getTvendorcode().equals("")){
			t30118.setT_upd_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30118.setT_upd_date(sqlDate);
		}else{
			//for update first take database object
		    T30001 upt30001 = t30118Service.findByTdrugformcode(t30118.getTdrugformcode());
		    upt30001.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30001.setT_upd_date(sqlDate);
		    upt30001.setT_lang2_name(t30118.getT_lang2_name());
		    
		    t30118=upt30001;
		}*/
		
		t30118.setT_upd_user(Integer.toString(user.getId()));
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    t30118.setT_upd_date(sqlDate);
	    
	    
	
		//save T30118
		t30118Service.saveT30118(t30118);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30118");
		return modelAndView;
	}
	
	//delete t30118
	@RequestMapping(value="/admin/deleteT30118", method = RequestMethod.POST)
	public ModelAndView deleteT30118(@Valid T30118 t30118, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		//delete Manufacture code
		t30118Service.deleteT30118(t30118);
		
		//go to html page with parameter
		modelAndView.addObject("t30118",t30118Service.findAll());
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.setViewName("admin/t30118");
		return modelAndView;
	}
}
