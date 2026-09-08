package org.tagger.controllers;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
	@GetMapping("/")
	public String hello() {
		Logger logger = LoggerFactory.getLogger(HelloController.class);
		logger.info("Hello World");
		return "hello";
	}
}
