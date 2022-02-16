package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value="/hello")
	public String sayHello()  // http://localhost:8080/SpringWebXmlDemo/hello
	{
		return "Hello ! Spring MVC";
	}

	@RequestMapping(method = RequestMethod.GET,value="/")
	public String start()  // http://localhost:8080/SpringWebXmlDemo/hello
	{
		return "login.jsp";
	}

	@RequestMapping(method = RequestMethod.GET,value="/login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password, ModelMap map)  // http://localhost:8080/SpringWebXmlDemo/hello
	{
		if(username.equals("admin") && password.equals("admin123")) {
			map.addAttribute("username", username);
		return "home.jsp";
		}
		return "login.jsp";
	}

}




