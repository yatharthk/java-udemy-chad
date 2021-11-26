package com.example.springmvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}



	//need a controller method to process the HTML fORM
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	@RequestMapping(value = "/processFormShoutOut",method = RequestMethod.GET)
	public String processFormCaps() {
		return "processFormCaps";
	}
	
	@RequestMapping(value = "/processFormShoutOut",method = RequestMethod.POST)
	public String processFormCaps(HttpServletRequest request,Model model) {
		System.out.println("Inside");
//		get Data
		String result;
//		List<Student> theStudentList;
		
		//read data from html form
		String toConvert=request.getParameter("studentName");
		
		//convert data to all caps
		toConvert=toConvert.toUpperCase();
		
		
		result="Yo!"+toConvert;
		
		//add messages to model
		model.addAttribute("message",result);
		model.addAttribute("age",23);
		
		return "helloWorld";
	}

	
	@RequestMapping(value = "/processFormShoutOutThree",method = RequestMethod.POST)
	public String processFormCaps(@RequestParam("studentName")String studentName ,Model model) {
		System.out.println("Inside");
//		get Data
		String result;
//		List<Student> theStudentList;
		
		
		
		//convert data to all caps
		studentName=studentName.toUpperCase();
		
		
		result="Hey my friend from v3!"+studentName;
		
		//add messages to model
		model.addAttribute("message",result);
		model.addAttribute("age",23);
		
		return "helloWorld";
	}

}
