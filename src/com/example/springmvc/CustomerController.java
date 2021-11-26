package com.example.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//add the init binder to remove exxtra whitespaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);//true flag is used to trim space to null
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer",new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")Customer customer,BindingResult result) {
		
		System.out.println("Binding Result "+ result);
		
		System.out.println("\n\n\n\n\n\n\n");
		if(result.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
	
}
