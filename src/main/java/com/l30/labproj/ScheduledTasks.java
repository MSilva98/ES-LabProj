package com.l30.labproj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
    private FlightRepository repo;

	@Scheduled(fixedRate = 20000)
	public void getFromAPI() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		log.info("Retrive info from OpenSky");
        RestTemplate restTemplate = new RestTemplate();
		Flight[] s = restTemplate.getForObject("https://opensky-network.org/api/flights/departure?airport=EGLL&begin=1582485409&end=1582555409", Flight[].class);
		for(int i = 0; i < s.length; i++){
			// log.info(s[i].toString());
			repo.save( s[i]);
		}
	}
}