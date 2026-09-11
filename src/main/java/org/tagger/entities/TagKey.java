package org.tagger.entities;

import java.io.Serializable;
import java.util.Objects;

public class TagKey implements Serializable {
	private EnumTagType type;
	private String name;

	public EnumTagType getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}

	public void setType(EnumTagType type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TagKey that = (TagKey) o;
		return Objects.equals(type, that.type) && Objects.equals(name, that.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(type, name);
	}
}
