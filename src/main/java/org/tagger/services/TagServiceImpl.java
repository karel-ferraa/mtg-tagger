package org.tagger.services;
import org.tagger.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagServiceImpl implements TagService {
	//@Autowired
	public TagRepository tagRepository;

	// this constructor is for test purposes only
	@Autowired
	private TagServiceImpl(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
		tagRepository.save(new Tag(EnumTagType.ART, "sword", null, null));
		Tag functionDraw = new Tag(EnumTagType.FUNCTION, "draw", null, null);
		tagRepository.save(functionDraw);
		tagRepository.save(new Tag(EnumTagType.FUNCTION, "rummage", List.of(functionDraw), null));
	}

	public Collection<Tag> getAllTags() {
		return (Collection<Tag>) tagRepository.findAll();
	}
}
