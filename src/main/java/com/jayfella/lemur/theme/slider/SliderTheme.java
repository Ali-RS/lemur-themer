package com.jayfella.lemur.theme.slider;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class SliderTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.25f, 0.5f, 0.5f, 0.5f));
    private Insets3f insets = new Insets3f(1,3,1,2);

    public SliderTheme() {
        super("slider");
    }
}
