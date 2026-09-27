package org.tagger.services;
import org.tagger.entities.*;
import org.tagger.entities.exceptions.*;

import java.util.*;

public interface TagService {
	public Collection<Tag> getAllTags();
	public Collection<Tag> getArtTags();
	public Tag getTag(EnumTagType type, String name);
	public Collection<Tag> getFunctionTags();
	public void createTag(EnumTagType type, String name);
	public void addParentTags(EnumTagType type, String name, List<TagKey> listTagKey) throws NonExistentTagException;
	public void addChildTags(EnumTagType type, String name, List<TagKey> listTagKey) throws NonExistentTagException;
	public void removeParentTags(EnumTagType type, String name, List<TagKey> listTagKey) throws NonExistentTagException;
	public void removeChildTags(EnumTagType type, String name, List<TagKey> listTagKey) throws NonExistentTagException;
	public void deleteTag(EnumTagType type, String name) throws NonExistentTagException;
}
