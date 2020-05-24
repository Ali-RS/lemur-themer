package com.jayfella.lemur.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jayfella.lemur.util.TextureUtils;
import com.simsilica.lemur.component.IconComponent;

import java.io.IOException;

public class IconComponentSerializer extends StdSerializer<IconComponent> {

    public IconComponentSerializer(Class<IconComponent> t) {
        super(t);
    }

    @Override
    public void serialize(IconComponent value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        String imageStringData = new TextureUtils().toBase64(value.getImageTexture());

        gen.writeStartObject();
        gen.writeStringField("base64Image", imageStringData);
        gen.writeObjectField("color", value.getColor());
        gen.writeObjectField("iconScale", value.getIconScale());
        gen.writeObjectField("margin", value.getMargin());
        gen.writeNumberField("zOffset", value.getZOffset());
        gen.writeBooleanField("lit", value.getMaterial().isLit());
        gen.writeEndObject();

    }

}
