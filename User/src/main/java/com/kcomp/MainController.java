package com.kcomp;


import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	private final static Logger log = Logger.getLogger(MainController.class.getName()); 
	
	@RequestMapping(value = "/hello")
	public ModelAndView sayHello(){
		log.info("In hello");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping(value = "/userForm")
	public ModelAndView userForm(){
		log.info("In userForm");
		ModelAndView mv = new ModelAndView("userForm","user",new User());

		mv.setViewName("userForm");
		
		return mv;
	}
	
	@RequestMapping(value = "/result")
	public ModelAndView result(User user){
		log.info("In result");
		ModelAndView mv = new ModelAndView();

		mv.setViewName("result");
		mv.addObject("u",user);
		return mv;
	}
}