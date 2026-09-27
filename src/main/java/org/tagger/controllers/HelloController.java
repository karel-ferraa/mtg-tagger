package org.tagger.controllers;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
	final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/")
	public String hello() {
		logger.info("Root endpoint");
		return "This is the root endpoint for the card tags api";
	}
}
