package com.l30.labproj;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
public class Main {

	// private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	// @Bean
	// public RestTemplate rest(RestTemplateBuilder builder){
	// 	return builder.build();
	// }

	// @Bean
	// public CommandLineRunner run(RestTemplate rest) throws Exception{
	// 	return args -> {
	// 		String s = rest.getForObject("https://opensky-network.org/api/flights/aircraft?icao24=3c675a&begin=1517184000&end=1517270400", String.class);
	// 		log.info(s);
	// 	};
	// }

}
