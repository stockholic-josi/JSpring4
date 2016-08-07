package com.taxholic.web.admin.main.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxholic.core.authority.AuthDto;



@Controller
@RequestMapping("/admin")
public class mainController{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping(value = "main")
	public String main(AuthDto user) {
		
		logger.debug("user : " + user);
		
		return "manager:admin/main";
	} 
	
	
	
}