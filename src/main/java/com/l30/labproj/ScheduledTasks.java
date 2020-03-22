package com.l30.labproj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private FlightRepository repo;

	@Autowired
	private KafkaTemplate<String, String> KafkaTemplate;

	public void sendMessage(String msg){
		KafkaTemplate.send("opensky", msg);
		log.info("Producer sent -> " + msg);
	}

	@KafkaListener(topics = "opensky", groupId = "l30")
	public void listen(String message){
		log.info("Consumer received -> " + message);
	}

	@Scheduled(fixedRate = 20000)
	public void getFromAPI() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		log.info("Retrive info from OpenSky");
		Date d = new Date();
		long end = d.getTime()/1000;
		long begin = end-(int)(1.5*24*60*60);
		RestTemplate restTemplate = new RestTemplate();
		Flight[] f = restTemplate.getForObject("https://opensky-network.org/api/flights/departure?airport=EGLL&begin=" + begin + "&end=" + end, Flight[].class);
		sendMessage("Number of flights : " + f.length);
		for(int i = 0; i < f.length; i++){
			repo.save( f[i]);
		}
	}
}