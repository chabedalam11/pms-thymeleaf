package com.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pms.model.T30005;
import com.pms.model.User;
import com.pms.service.T30004Service;
import com.pms.service.T30005Service;
import com.pms.service.T30007Service;
import com.pms.service.UserService;

@Controller
public class T30005Controller {
	
	@Autowired
	private UserService userService;

	@Autowired
	private T30004Service t30004Service;
	
	@Autowired
	private T30005Service t30005Service;
	
	@Autowired
	private T30007Service t30007Service;
	
	//request for t30005 page
	@RequestMapping(value="/admin/t30005", method = RequestMethod.GET)
	public ModelAndView home(){
		System.out.println("come to controller");
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
		modelAndView.addObject("t30004",t30004Service.findAll());
		modelAndView.addObject("t30005List",t30005Service.findAll());
		modelAndView.addObject("t30005",new T30005());
		modelAndView.addObject("t30007",t30007Service.findAll());
		modelAndView.setViewName("admin/t30005");
		return modelAndView;
	}
	
	
	
	
		//request for t30005 page
		@RequestMapping(value="/admin/findbygent30005", method = RequestMethod.GET)
		public ModelAndView getTradeByGenCode(
				 @RequestParam(value = "stringParam") String stringParam
				 /*,@RequestParam(value = "arrayParam") List<String> arrayParam*/
				){
			System.out.println("come getGenericData medhos"+stringParam);
			ModelAndView modelAndView = new ModelAndView();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.addObject("t30004",t30004Service.findAll());
			modelAndView.addObject("t30005List",t30005Service.findByT_gen_code(stringParam));
			modelAndView.addObject("t30005",new T30005());
			modelAndView.addObject("t30007",t30007Service.findAll());
			modelAndView.setViewName("admin/t30005");
			return modelAndView;
		}
		
		
		
		
		
		
		
	
	//save and update t30005
	@RequestMapping(value="/admin/saveT30005", method = RequestMethod.POST)
	public ModelAndView saveT30005(@Valid T30005 t30005, BindingResult bindingResult){
		//create ModelAndView for return
		ModelAndView modelAndView = new ModelAndView();
		
		//get Authentication for get user name
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		System.out.println("gencode : "+t30005.getT_gen_code());
		if (t30005.getT_gen_code().equals("0")) {
			System.out.println("step 1");
			bindingResult
					.rejectValue("t_gen_code", "error.t30005",
							"please select a generic code !!!");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("step 2");
			//go to html page with parameter
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.addObject("t30004",t30004Service.findAll());
			modelAndView.addObject("t30005List",t30005Service.findAll());
			modelAndView.addObject("t30007",t30007Service.findAll());
			modelAndView.setViewName("admin/t30005");
		}else{
			
			System.out.println("step 3");
			//set entry user and date
			if(t30005.getTtradecode().equals("")){
				t30005.setT_entry_user(Integer.toString(user.getId()));
				java.util.Date utilDate = new java.util.Date();
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    t30005.setT_entry_date(sqlDate);
			    modelAndView.addObject("msg",  "Save Successful");
			}else{
				
			    //for update first take database object
			    T30005 upt30005 = t30005Service.findByTtradecode(t30005.getTtradecode());
			    upt30005.setT_upd_user(Integer.toString(user.getId()));
			    java.util.Date utilDate = new java.util.Date();
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    upt30005.setT_upd_date(sqlDate);
			    upt30005.setT_gen_code(t30005.getT_gen_code());
			    upt30005.setT_manuf_code(t30005.getT_manuf_code());
			    upt30005.setT_lang2_name(t30005.getT_lang2_name());
			    upt30005.setT_active_flag(t30005.getT_active_flag());
			    t30005=upt30005;
			    modelAndView.addObject("msg",  "Update Successful");
			}
			
			//save T30005
			t30005Service.saveT30005(t30005);
			
			//go to html page with parameter
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.addObject("t30004",t30004Service.findAll());
			modelAndView.addObject("t30005",new T30005());
			modelAndView.addObject("t30005List",t30005Service.findByT_gen_code(t30005.getT_gen_code()));
			modelAndView.addObject("t30007",t30007Service.findAll());
			modelAndView.setViewName("admin/t30005");
			
			
		} 
		
		
		
		
		
		
		return modelAndView;
	}
		
		
		
		
		
		
	
		//delete t30005
		@RequestMapping(value="/admin/deleteT30005", method = RequestMethod.POST)
		public ModelAndView deleteT30005(@Valid T30005 t30005, BindingResult bindingResult){
			//create ModelAndView for return
			ModelAndView modelAndView = new ModelAndView();
			
			//get Authentication for get user name
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			
			//delete trade code
			t30005Service.deleteT30005(t30005);
			
			//go to html page with parameter
			modelAndView.addObject("userName",  user.getName()+ " " + user.getLastName());
			modelAndView.addObject("msg",  "Delete Successful");
			modelAndView.addObject("t30004",t30004Service.findAll());
			modelAndView.addObject("t30005List",t30005Service.findAll());
			modelAndView.addObject("t30005",new T30005());
			modelAndView.addObject("t30007",t30007Service.findAll());
			modelAndView.setViewName("admin/t30005");
			return modelAndView;
		}
}
