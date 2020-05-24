package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.simsilica.lemur.Insets3f;

import java.io.IOException;

public class Insets3fDeserializer extends StdDeserializer<Insets3f> {

    public Insets3fDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Insets3f deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        float top = node.get("top").floatValue();
        float left = node.get("left").floatValue();
        float bottom = node.get("bottom").floatValue();
        float right = node.get("right").floatValue();

        return new Insets3f(top, left, bottom, right);

    }
}
