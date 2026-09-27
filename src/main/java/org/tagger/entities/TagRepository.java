package org.tagger.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface TagRepository extends JpaRepository<Tag, Long> {
	List<Tag> findByType(EnumTagType type);
	Tag findByTypeAndName(EnumTagType type, String name);
}
