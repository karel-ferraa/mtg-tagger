package org.tagger.controllers;
import org.tagger.services.*;
import org.tagger.entities.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

	@GetMapping("/tags/art")
	public Collection<Tag> getArtTags() {
		logger.info("getArtTags");
		return tagService.getArtTags();
	}

	@GetMapping("/tags/function")
	public Collection<Tag> getFunctionTags() {
		logger.info("getFunctionTags");
		return tagService.getFunctionTags();
	}

	@PostMapping("/tags")
	@ResponseStatus(HttpStatus.OK)
	public void createTag(
			@RequestBody(required = true) TagKey tagKey
			)
	{
		logger.info("createTag");
		tagService.createTag(tagKey.getType(), tagKey.getName());
	}
}
