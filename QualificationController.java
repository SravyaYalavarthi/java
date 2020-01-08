package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Qualification;
import com.example.demo.services.QualificationService;
@Controller
@ResponseBody
public class QualificationController {
	@Autowired
QualificationService service;
	@GetMapping("/qua")
	public ModelAndView myget() {
		ModelAndView modelAndview=new ModelAndView();
		modelAndview.setViewName("qualification");
		return modelAndview;
	}
	@PostMapping("/get")
	public ModelAndView method(Qualification qua) {
		ModelAndView modelAndview=new ModelAndView();
		modelAndview.setViewName("qualification");
		return modelAndview.addObject("data",service.adddata(qua));
	}
	@GetMapping("/hi")
	public ModelAndView mydisplay() {
		ModelAndView modelAndview=new ModelAndView();
		modelAndview.setViewName("tablequal");
		return modelAndview.addObject("display1",service.display());

	}


}
