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
		Flight[] s = restTemplate.getForObject("https://opensky-network.org/api/flights/departure?airport=EGLL&begin=1582485409&end=1582555409", Flight[].class);
		String data = "";
		for(int i = 0; i < s.length; i++){
			data += "\n	" + s[i].toString() ; 
		}
		model.addAttribute("name", data);
		return "index";
	}

}