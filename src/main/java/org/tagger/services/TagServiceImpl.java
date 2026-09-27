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
		tagRepository.save(new Tag(EnumTagType.art, "sword"));
		Tag functionDraw = new Tag(EnumTagType.function, "draw");
		Tag functionRummage = new Tag(EnumTagType.function, "rummage");
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
		return (Collection<Tag>) tagRepository.findByType(EnumTagType.art);
	}
	public Collection<Tag> getFunctionTags() {
		return (Collection<Tag>) tagRepository.findByType(EnumTagType.function);
	}

	public void createTag(EnumTagType type, String name) {
		tagRepository.save(new Tag(type, name));
	}
	public void addParentTags(EnumTagType type, String name, List<TagKey> listTagKey) {
		Tag childTag = tagRepository.findByTypeAndName(type, name);
		for (var tagKey : listTagKey) {
			Tag parentTag = tagRepository.findByTypeAndName(tagKey.getType(), tagKey.getName());
			childTag.addParentTag(parentTag);
			tagRepository.save(parentTag);
		}
		tagRepository.save(childTag);
	}
	public void addChildTags(EnumTagType type, String name, List<TagKey> listTagKey) {
		Tag parentTag = tagRepository.findByTypeAndName(type, name);
		for (var tagKey : listTagKey) {
			Tag childTag = tagRepository.findByTypeAndName(tagKey.getType(), tagKey.getName());
			parentTag.addChildTag(childTag);
			tagRepository.save(childTag);
		}
		tagRepository.save(parentTag);
	}
	public void removeParentTags(EnumTagType type, String name, List<TagKey> listTagKey) {
		Tag childTag = tagRepository.findByTypeAndName(type, name);
		for (var tagKey : listTagKey) {
			Tag parentTag = tagRepository.findByTypeAndName(tagKey.getType(), tagKey.getName());
			childTag.removeParentTag(parentTag);
			tagRepository.save(parentTag);
		}
		tagRepository.save(childTag);
	}
	public void removeChildTags(EnumTagType type, String name, List<TagKey> listTagKey) {
		Tag parentTag = tagRepository.findByTypeAndName(type, name);
		for (var tagKey : listTagKey) {
			Tag childTag = tagRepository.findByTypeAndName(tagKey.getType(), tagKey.getName());
			parentTag.removeChildTag(childTag);
			tagRepository.save(childTag);
		}
		tagRepository.save(parentTag);
	}
}
