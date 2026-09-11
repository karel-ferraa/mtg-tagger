package org.tagger.controllers;
import org.tagger.services.*;
import org.tagger.entities.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@RestController
public class TagController {
	final Logger logger = LoggerFactory.getLogger(TagController.class);
	@Autowired
	TagService tagService;

	@GetMapping("/tags")
	public Collection<Tag> getAllTags() {
		logger.info("getAllTags");
		return tagService.getAllTags();
	}
}
