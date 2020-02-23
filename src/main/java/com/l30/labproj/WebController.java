package com.l30.labproj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        RestTemplate restTemplate = new RestTemplate();
		String s = restTemplate.getForObject("https://opensky-network.org/api/flights/aircraft?icao24=3c675a&begin=1517184000&end=1517270400", String.class);
		model.addAttribute("name", s);
		return "index";
	}

}