package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.jayfella.lemur.util.TextureUtils;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector2f;
import com.jme3.texture.Texture;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;

import java.io.IOException;

public class TbtQuadBackgroundComponentDeserializer extends StdDeserializer<TbtQuadBackgroundComponent> {

    public TbtQuadBackgroundComponentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Object deserializeWithType(final JsonParser parser, final DeserializationContext context,
                                      final TypeDeserializer deserializer) throws IOException {

        // effectively assuming no type information at all
        return deserialize(parser, context);
    }

    @Override
    public TbtQuadBackgroundComponent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        JsonNode node = jp.getCodec().readTree(jp);

        String imageDataString = node.get("base64Image").asText();
        Texture texture = new TextureUtils().fromBase64(imageDataString);
        texture.setName("Base64 " + FastMath.rand.nextFloat());

        float r = node.get("color").get("r").floatValue();
        float g = node.get("color").get("g").floatValue();
        float b = node.get("color").get("b").floatValue();
        float a = node.get("color").get("a").floatValue();

        // this is important. We're only supporting 1.0x imageScale.
        // if we ever support other values, the deserializer will be affected.
        float imageScale = 1.0f;

        Vector2f margin = new Vector2f(
                node.get("margin").get("x").floatValue(),
                node.get("margin").get("y").floatValue());

        float zOffset = node.get("zOffset").floatValue();

        boolean lit = node.get("lit").booleanValue();

        Vector2f margin2 = new Vector2f(
                node.get("margin2").get("x").floatValue(),
                node.get("margin2").get("y").floatValue());

        TbtQuadBackgroundComponent backgroundComponent = TbtQuadBackgroundComponent.create(
                texture,
                imageScale,
                (int) margin.x,
                (int) margin.y,
                (int) margin2.x,
                (int) margin2.y,
                zOffset,
                lit);

        backgroundComponent.setColor(new ColorRGBA(r, g, b, a));

        // Some components (such as the ListBoxSelectorTheme) require BlendMode.AlphaAdditive
        String blendModeString = node.get("blendMode").asText();
        RenderState.BlendMode blendMode = RenderState.BlendMode.valueOf(blendModeString);
        backgroundComponent.getMaterial().getMaterial().getAdditionalRenderState().setBlendMode(blendMode);

        return backgroundComponent;

    }
}
