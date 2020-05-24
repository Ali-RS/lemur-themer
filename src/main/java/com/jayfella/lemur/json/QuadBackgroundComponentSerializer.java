package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.simsilica.lemur.component.QuadBackgroundComponent;

import java.io.IOException;

public class QuadBackgroundComponentSerializer extends StdSerializer<QuadBackgroundComponent> {

    public QuadBackgroundComponentSerializer(Class<QuadBackgroundComponent> t) {
        super(t);
    }

    @Override
    public void serializeWithType(final QuadBackgroundComponent value, final JsonGenerator generator,
                                  final SerializerProvider provider, final TypeSerializer serializer) throws IOException {

        // effectively assuming no type information at all
        serialize(value, generator, provider);
    }

    @Override
    public void serialize(QuadBackgroundComponent value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        // Some components (such as the ListBoxSelectorTheme) require BlendMode.AlphaAdditive

        gen.writeStartObject();
        gen.writeStringField("@class", "com.simsilica.lemur.component.QuadBackgroundComponent");
        gen.writeObjectField("color", value.getColor());
        gen.writeObjectField("margin", value.getMargin());
        gen.writeNumberField("zOffset", value.getZOffset());
        gen.writeBooleanField("lit", value.getMaterial().isLit());
        gen.writeStringField("blendMode", value.getMaterial().getMaterial().getAdditionalRenderState().getBlendMode().toString());
        gen.writeEndObject();

    }

}
