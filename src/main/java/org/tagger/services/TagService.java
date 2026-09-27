package org.tagger.services;
import org.tagger.entities.*;

import java.util.*;

public interface TagService {
	public Collection<Tag> getAllTags();
	public Collection<Tag> getArtTags();
	public Collection<Tag> getFunctionTags();
	public void createTag(EnumTagType type, String name);
}
