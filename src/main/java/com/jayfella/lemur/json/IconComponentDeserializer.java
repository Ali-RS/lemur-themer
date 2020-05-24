package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.jayfella.lemur.util.TextureUtils;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.texture.plugins.AWTLoader;
import com.simsilica.lemur.component.IconComponent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class IconComponentDeserializer extends StdDeserializer<IconComponent> {

    public IconComponentDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public IconComponent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        // Texture
        String imageDataString = node.get("base64Image").asText();
        Texture texture = new TextureUtils().fromBase64(imageDataString);

        // Scale
        float scaleX = node.get("iconScale").get("x").floatValue();
        float scaleY = node.get("iconScale").get("y").floatValue();

        Vector2f iconScale = new Vector2f(scaleX, scaleY);

        // Margin
        float marginX = node.get("margin").get("x").floatValue();
        float marginY = node.get("margin").get("y").floatValue();

        // zOffset
        float zOffset = node.get("zOffset").floatValue();

        // lit
        boolean lit = node.get("lit").booleanValue();

        // Color
        float r = node.get("color").get("r").floatValue();
        float g = node.get("color").get("g").floatValue();
        float b = node.get("color").get("b").floatValue();
        float a = node.get("color").get("a").floatValue();

        ColorRGBA color = new ColorRGBA(r, g, b, a);

        IconComponent iconComponent = new IconComponent(texture, iconScale, marginX, marginY, zOffset, lit);
        iconComponent.setColor(color);

        return iconComponent;
    }
}
