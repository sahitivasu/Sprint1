package com.cg.eis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping(path="/login")
	public String loginPage()
	{
		return "login";
	}
	@RequestMapping("/logout-sucess")
	public String logoutPage()
	{
		return "logout";
	}
}
