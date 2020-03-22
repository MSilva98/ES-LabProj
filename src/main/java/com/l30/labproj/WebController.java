package com.l30.labproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Autowired
	private FlightRepository repo;
	
	
	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("flights", repo.findAll());
		return "index";
	}	

}