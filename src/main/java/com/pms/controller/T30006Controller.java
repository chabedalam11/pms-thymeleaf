package com.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pms.model.T30005;
import com.pms.model.T30006;
import com.pms.model.User;
import com.pms.service.T30001Service;
import com.pms.service.T30002Service;
import com.pms.service.T30004Service;
import com.pms.service.T30005Service;
import com.pms.service.T30006Service;
import com.pms.service.T30036Service;
import com.pms.service.UserService;

@Controller
public class T30006Controller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private T30001Service t30001Service;
	
	@Autowired
	private T30002Service t30002Service;
	
	@Autowired
	private T30004Service t30004Service;
	
	@Autowired
	private T30005Service t30005Service;
	
	@Autowired
	private T30006Service t30006Service;
	
	@Autowired
	private T30036Service t30036Service;
	
	
	
	//request for t30006 page
	@RequestMapping(value="/admin/t30006", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		//t30006Service.getAllT30006();
		modelAndView.addObject("t30001",t30001Service.findAll());
		modelAndView.addObject("t30002",t30002Service.findAll());
		modelAndView.addObject("t30004",t30004Service.findAll());
		modelAndView.addObject("t30005",t30005Service.findAll());
		modelAndView.addObject("t30036",t30036Service.findAll());
		modelAndView.addObject("t30006",t30006Service.findAll());
		
		modelAndView.setViewName("admin/t30006");
		return modelAndView;
	}
	
	//generic item change response
	@RequestMapping("admin/t30006getCitiesForState")
	   @ResponseBody
	   public List<T30005> responseForDropdownStateChange(@RequestParam long state) {
		System.out.println("param : "+state);
		List<T30005> t30005List= new ArrayList<T30005>();
	    t30005List = t30005Service.findByT_gen_code(Long.toString(state));
	    return t30005List;
	   }
	
	
	
	
	//save t30006
	@RequestMapping(value="/admin/saveT30006", method = RequestMethod.POST)
	public ModelAndView saveT30006(@Valid T30006 t30006, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("code : "+t30006.getTdrugmastercode());
		//set entry user and date
		if(t30006.getTdrugmastercode() == null || t30006.getTdrugmastercode().equals("")){
			System.out.println("method");
			t30006.setT_entry_user(Integer.toString(user.getId()));
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    t30006.setT_entry_date(sqlDate);
		}else{
			
		    //for update first take database object
		    T30006 upt30006 = t30006Service.findByTdrugmastercode(t30006.getTdrugmastercode());
		    upt30006.setT_upd_user(Integer.toString(user.getId()));
		    java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    upt30006.setT_upd_date(sqlDate);
		    upt30006.setT_trade_code(t30006.getT_trade_code());
		    upt30006.setT_drug_form_code(t30006.getT_drug_form_code());
		    upt30006.setT_route_code(t30006.getT_route_code());
		    upt30006.setT_units(t30006.getT_units());
		    upt30006.setT_bse_um(t30006.getT_bse_um());
		    upt30006.setT_strength(t30006.getT_strength());
		    upt30006.setT_opd_price(t30006.getT_opd_price());
		    upt30006.setT_active_flag(t30006.getT_active_flag());
		    t30006=upt30006;
		    modelAndView.addObject("msg",  "Update Successful");
		}
		System.out.println("um > "+t30006.getT_bse_um());
		
		//save T30006
		t30006Service.saveT30006(t30006);
		
		//go to html page with parameter
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30001",t30001Service.findAll());
		modelAndView.addObject("t30002",t30002Service.findAll());
		modelAndView.addObject("t30004",t30004Service.findAll());
		modelAndView.addObject("t30005",t30005Service.findAll());
		modelAndView.addObject("t30036",t30036Service.findAll());
		//modelAndView.addObject("t30006",t30006Service.findAll());
		modelAndView.setViewName("admin/t30006");
		return modelAndView;
	}
	
		//delete t30006
		@RequestMapping(value="/admin/deleteT30006", method = RequestMethod.POST)
		public ModelAndView deleteT30006(@Valid T30006 t30006, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete dragMasterCode
			t30006Service.deleteT30006(t30006);
			
			//go to html page with parameter
			modelAndView.addObject("t30006",t30006Service.findAll());
			modelAndView.addObject("msg",  "Delete Successful");
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.setViewName("admin/t30006");
			return modelAndView;
		}
}
