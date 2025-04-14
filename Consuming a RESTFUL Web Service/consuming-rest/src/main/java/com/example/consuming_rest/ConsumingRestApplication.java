package com.example.consuming_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	// basically a more advanced sout
	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	// @Bean means Spring will create and manage the object below
	// instead of just doing: RestTemplate restTemplate = new RestTemplate();
	// you do this ↓
	// and Spring creates the object, and distributes it automatically to whatever needs it
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) { // a RestTemplate makes HTTP requests, has to be built with the RestTemplateBuilder builder (not just an obj)
		return builder.build();
	}

	// @Profile("!test") means code below won't be run when testing
	@Bean
	@Profile("!test") //CommandLineRunner runs code right after the app starts, not waiting for some get request at a specific URL like I've seen in "Consuming a Restful web service"
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		// "lambda" shortcut ↓
		// returns a commandlinerunner obj and "@Override"s the "run" method
		// run method is the only method the obj has
		return args -> {
			// RestTemplate deals with http so:
			// makes a get request to the url, waits for an object from there
			// converts json into a quote obj
			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			// "logs" via toString method in the terminal
			log.info(quote.toString());
		};
	}
}

// it's not that complicated, yet I can't get to remember what everything does to understand everything at once