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
	// a RestTemplate makes HTTP requests
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	// @Profile("!test") means code below won't be run when testing
	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		// "lambda" shortcut ↓
		// means it's creating the CommandLineRunner object
		// then overrides the "run" method which is the only method CmdLnRnr has in the "{ }"
		return args -> {
			// makes an HTTP request to *URL* and converts the data received into a Quote obj
			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			// logs toString method in the logs
			log.info(quote.toString());
		};
	}
}
