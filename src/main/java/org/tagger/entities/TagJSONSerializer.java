package org.tagger.entities;

import org.springframework.boot.jackson.JacksonComponent;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;
import java.util.*;

@JacksonComponent
public class TagJSONSerializer extends ValueSerializer<Tag> {

	@Override
	public void serialize(Tag tag, JsonGenerator gen, SerializationContext context) {
		gen.writeStartObject();

		gen.writeStringProperty("type", tag.getType().toString());
		gen.writeStringProperty("name", tag.getName());
		
		gen.writeArrayPropertyStart("parents");
		for (Tag parentTag : tag.getParentTags()) {
			gen.writeStartObject();

			gen.writeStringProperty("type", parentTag.getType().toString());
			gen.writeStringProperty("name", parentTag.getName());

			gen.writeEndObject();
		}
		gen.writeEndArray();
		gen.writeArrayPropertyStart("children");
		for (Tag childTag : tag.getChildTags()) {
			gen.writeStartObject();

			gen.writeStringProperty("type", childTag.getType().toString());
			gen.writeStringProperty("name", childTag.getName());

			gen.writeEndObject();
		}
		gen.writeEndArray();

		gen.writeEndObject();
	}
}
