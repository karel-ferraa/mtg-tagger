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

	@PutMapping("/tags/{type}/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void addFamilyTags(
			@PathVariable("type") EnumTagType type,
			@PathVariable("name") String name,
			@RequestParam(value="parent", required = true) boolean parent, // whether this tag is the parent of the tags to be added (true) or is the child of the tags to be added (false)
			@RequestBody(required = true) List<TagKey> listTagKey
			)
	{
		if (parent) {
			logger.info("addFamilyTags - add children tags");
			tagService.addChildTags(type, name, listTagKey);
		} else {
			logger.info("addFamilyTags - add parent tags");
			tagService.addParentTags(type, name, listTagKey);
		}
	}

	@DeleteMapping("/tags/{type}/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void removeFamilyTags(
			@PathVariable("type") EnumTagType type,
			@PathVariable("name") String name,
			@RequestParam(value="parent", required = true) boolean parent, // whether this tag is the parent of the tags to be removed (true) or is the child of the tags to be removed (false)
			@RequestBody(required = true) List<TagKey> listTagKey
			)
	{
		if (parent) {
			logger.info("removeFamilyTags - remove children tags");
			tagService.removeChildTags(type, name, listTagKey);
		} else {
			logger.info("removeFamilyTags - remove parent tags");
			tagService.removeParentTags(type, name, listTagKey);
		}
	}
	@DeleteMapping(value="/tags/{type}/{name}", params="!parent")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTag(
			@PathVariable("type") EnumTagType type,
			@PathVariable("name") String name
			)
	{
		logger.info("deleteTag");
		tagService.deleteTag(type, name);
	}
}
