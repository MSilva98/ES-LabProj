package com.l30.labproj;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

	@Autowired
    private FlightRepository repo;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //RestTemplate restTemplate = new RestTemplate();
		//Flight[] s = restTemplate.getForObject("https://opensky-network.org/api/flights/departure?airport=EGLL&begin=1582485409&end=1582555409", Flight[].class);
		String data = "";
		// for(int i = 0; i < s.length; i++){
		// 	data += "\n	" + s[i].toString() ; 
		// }
		// repo.findByEstDepartureAirport("EGLL").forEach(f -> {
		// 	data += "\n	" + f.toString(); 
		//   });
		// List<Flight> f = repo.findByEstDepartureAirport("EGLL");
		// log.info("Reloading web page");
		// for (int i = 0; i < f.size(); i++) {
		// 	data += "\n	" + f.toString();
		// }
		model.addAttribute("flights", repo.findAll());
		return "index";
	}	

}