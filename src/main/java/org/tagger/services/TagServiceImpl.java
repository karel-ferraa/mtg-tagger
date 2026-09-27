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
		tagRepository.save(new Tag(EnumTagType.ART, "sword"));
		Tag functionDraw = new Tag(EnumTagType.FUNCTION, "draw");
		Tag functionRummage = new Tag(EnumTagType.FUNCTION, "rummage");
		tagRepository.save(functionDraw);
		tagRepository.save(functionRummage);
		functionRummage.addParentTag(functionDraw);
		tagRepository.save(functionDraw);
		tagRepository.save(functionRummage);
	}

	public Collection<Tag> getAllTags() {
		return (Collection<Tag>) tagRepository.findAll();
	}

	public Collection<Tag> getArtTags() {
		return (Collection<Tag>) tagRepository.findByType(EnumTagType.ART);
	}
	public Collection<Tag> getFunctionTags() {
		return (Collection<Tag>) tagRepository.findByType(EnumTagType.FUNCTION);
	}
}
