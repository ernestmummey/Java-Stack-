package com.ernest.thecode.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String homeForm() {
		return "form.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String guess(@RequestParam(value="secret") String secretCode, RedirectAttributes redirectAttribute) {
		if(secretCode.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			redirectAttribute.addFlashAttribute("error", "Incorrect password");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String coding() {
		return "code.jsp";
	}
}