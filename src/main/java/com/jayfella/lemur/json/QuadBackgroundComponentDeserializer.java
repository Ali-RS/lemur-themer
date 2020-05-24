package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;

import java.io.IOException;

public class QuadBackgroundComponentDeserializer extends StdDeserializer<QuadBackgroundComponent> {

    public QuadBackgroundComponentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Object deserializeWithType(final JsonParser parser, final DeserializationContext context,
                                      final TypeDeserializer deserializer) throws IOException {

        // effectively assuming no type information at all
        return deserialize(parser, context);
    }

    @Override
    public QuadBackgroundComponent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        float r = node.get("color").get("r").floatValue();
        float g = node.get("color").get("g").floatValue();
        float b = node.get("color").get("b").floatValue();
        float a = node.get("color").get("a").floatValue();

        float xMargin = node.get("margin").get("x").floatValue();
        float yMargin = node.get("margin").get("y").floatValue();

        float zOffset = node.get("zOffset").floatValue();

        boolean lit = node.get("lit").booleanValue();

        QuadBackgroundComponent backgroundComponent = new QuadBackgroundComponent(
                new ColorRGBA(r, g, b, a),
                xMargin, yMargin,
                zOffset,
                lit);

        // Some components (such as the ListBoxSelectorTheme) require BlendMode.AlphaAdditive
        String blendModeString = node.get("blendMode").asText();
        RenderState.BlendMode blendMode = RenderState.BlendMode.valueOf(blendModeString);
        backgroundComponent.getMaterial().getMaterial().getAdditionalRenderState().setBlendMode(blendMode);

        return backgroundComponent;
    }
}
