package com.ernest.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterControllers {
	@RequestMapping("/")
	   public String homePage(HttpSession session){
		Integer count = (Integer) session.getAttribute("count");
		@SuppressWarnings("deprecation")
		Integer counter = new Integer(count.intValue() +1 );
        session.setAttribute("count", counter);
        return "home.jsp";
    }
	

	@RequestMapping("/counter")
	   public String counterPage(Model model, HttpSession session){
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute(count);
		return "counter.jsp";
 }
}
	
