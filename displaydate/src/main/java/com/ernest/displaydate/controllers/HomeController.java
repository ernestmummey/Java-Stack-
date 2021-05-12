package com.ernest.displaydate.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/")
    public String dashboard(Model model) {
        return "dashboard.jsp";
    }
	
	@RequestMapping("/date")
    public String dates(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFor = new SimpleDateFormat("E', the' dd 'of' MMMM',' yyyy", Locale.ENGLISH);
		String formatted_date = dateFor.format(currentDate);
		model.addAttribute("currentDate", formatted_date);
        return "date.jsp";
    }
	
	@RequestMapping("/time")
    public String times(Model model) {
		Date currentTime = new Date();
		SimpleDateFormat dateFor = new SimpleDateFormat("hh:hh a", Locale.ENGLISH);
		String formatted_time = dateFor.format(currentTime);
		model.addAttribute("currentTime", formatted_time);
        return "time.jsp";
    }
}


