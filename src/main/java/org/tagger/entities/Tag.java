package org.tagger.entities;

import java.util.*;
import jakarta.persistence.*;

@IdClass(TagKey.class)
@Entity
public class Tag {
	@Id
	private EnumTagType type;
	@Id
	private String name;
	@OneToMany
	private Collection<Tag> parentTags;
	@OneToMany
	private Collection<Tag> childTags;

	public Tag() {}
	public Tag(EnumTagType type, String name, Collection<Tag> parentTags, Collection<Tag> childTags) {
		this.type = type;
		this.name = name;
		this.parentTags = parentTags;
		this.childTags = childTags;
	}

	public EnumTagType getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}
	public Collection<Tag> getParentTags() {
		return this.parentTags;
	}
	public Collection<Tag> getChildTags() {
		return this.childTags;
	}

	public void setType(EnumTagType type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParentTags(Collection<Tag> parentTags) {
		this.parentTags = parentTags;
	}
	public void setChildTags(Collection<Tag> childTags) {
		this.childTags = childTags;
	}

	@Override
	public String toString() {
		String res = "";
		res += "type: " + this.type;
		res += "name: " + this.name;
		res += "parent tags: [";
		for (var parentTag: this.parentTags) {
			res += parentTag.getName() + ",";
		}
		res += "] ";
		res += "child tags: [";
		for (var childTag: this.childTags) {
			res += childTag.getName() + ",";
		}
		res += "]";
		return res;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tag that = (Tag) o;
		return Objects.equals(type, that.type) && Objects.equals(name, that.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(type, name);
	}
}
