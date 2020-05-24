package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.simsilica.lemur.Insets3f;

import java.io.IOException;

public class Insets3fSerializer extends StdSerializer<Insets3f> {

    public Insets3fSerializer(Class<Insets3f> t) {
        super(t);
    }

    @Override
    public void serialize(Insets3f value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        float top = value.min.y;
        float left = value.min.x;
        float bottom = value.max.y;
        float right = value.max.x;

        gen.writeStartObject();
        gen.writeNumberField("top", top);
        gen.writeNumberField("left", left);
        gen.writeNumberField("bottom", bottom);
        gen.writeNumberField("right", right);
        gen.writeEndObject();

    }

}
