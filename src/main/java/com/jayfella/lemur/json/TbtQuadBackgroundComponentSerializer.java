package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jayfella.lemur.util.TextureUtils;
import com.jme3.math.Vector2f;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;
import com.simsilica.lemur.geom.TbtQuad;

import java.io.IOException;
import java.lang.reflect.Field;

public class TbtQuadBackgroundComponentSerializer extends StdSerializer<TbtQuadBackgroundComponent> {

    public TbtQuadBackgroundComponentSerializer(Class<TbtQuadBackgroundComponent> t) {
        super(t);
    }

    @Override
    public void serializeWithType(final TbtQuadBackgroundComponent value, final JsonGenerator generator,
                                  final SerializerProvider provider, final TypeSerializer serializer) throws IOException {

        // effectively assuming no type information at all
        serialize(value, generator, provider);
    }

    @Override
    public void serialize(TbtQuadBackgroundComponent value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        String imageStringData = new TextureUtils().toBase64(value.getTexture());

        float x2 = 0;
        float y2 = 0;

        try {
            Field field = TbtQuadBackgroundComponent.class.getDeclaredField("quad");
            field.setAccessible(true);
            TbtQuad quad = (TbtQuad) field.get(value);
            field.setAccessible(false);

            field = TbtQuad.class.getDeclaredField("horzFolds");
            field.setAccessible(true);
            float[] horzFolds = (float[]) field.get(quad);
            field.setAccessible(false);

            x2 = horzFolds[1];
            y2 = horzFolds[1];

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Some components (such as the ListBoxSelectorTheme) require BlendMode.AlphaAdditive

        gen.writeStartObject();
        gen.writeStringField("@class", "com.simsilica.lemur.component.TbtQuadBackgroundComponent");
        gen.writeStringField("base64Image", imageStringData);
        gen.writeObjectField("color", value.getColor());
        gen.writeObjectField("margin", value.getMargin());
        gen.writeObjectField("margin2", new Vector2f(x2, y2));
        gen.writeNumberField("zOffset", value.getZOffset());
        gen.writeBooleanField("lit", value.getMaterial().isLit());
        gen.writeStringField("blendMode", value.getMaterial().getMaterial().getAdditionalRenderState().getBlendMode().toString());
        gen.writeEndObject();

    }

}
