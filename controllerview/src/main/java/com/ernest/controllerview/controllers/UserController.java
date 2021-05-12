package com.ernest.controllerview.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ernest.controllerview.models.User;
import com.ernest.controllerview.services.UserService;
import com.ernest.controllerview.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    //==============================================================
    // registration
    //==============================================================
    
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "loginReg.jsp";
    }
    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Validated @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirect) {
    	userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginReg.jsp";
		}
		else {
		    	User u = userService.registerUser(user);
		    	session.setAttribute("userId", u.getId());
		    	redirect.addFlashAttribute("reg", "You have succesfully registered");
		    	return "redirect:/";
		}
    }
    
    //==============================================================
    // login
    //==============================================================
       
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password")String password, Model model, HttpSession session, RedirectAttributes redirect) {
		if(userService.authenticateUser(email, password)) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("user", new User());
			redirect.addFlashAttribute("error", "Please use valid login credentials");
			return "redirect:/";
		}
    }
    
    //==============================================================================
    // dashboard / home page
    //==============================================================================
    
    @RequestMapping("/dashboard")
    public String home(HttpSession session, Model model, RedirectAttributes redirect) {
	Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			redirect.addFlashAttribute("please", "Please login or Registor before entering the site");
			return "redirect:/";
		} else {
			model.addAttribute("user", userService.findUserById(userId));
			return "homePage.jsp";
	   }
   }
    
    //==============================================================================
    // logout
    //==============================================================================
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
    }
}