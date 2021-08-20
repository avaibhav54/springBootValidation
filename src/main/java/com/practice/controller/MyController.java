package com.practice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entities.LoginData;

@Controller
public class MyController {

	
	@GetMapping("/form")
	public String openForm(Model model)
	{
		model.addAttribute("loginData",new LoginData());
		System.out.println("opening form");
		return "forms";
	}
	
	//handler for processing form
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData logindata,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return"forms";
		}
		System.out.println(logindata);
		return "success";
	}
}
