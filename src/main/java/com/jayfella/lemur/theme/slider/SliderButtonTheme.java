package com.jayfella.lemur.theme.slider;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class SliderButtonTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.doubleGradient(new ColorRGBA(0.5f, 0.75f, 0.75f, 0.5f));
    private Insets3f insets = new Insets3f(0, 0, 0, 0);

    public SliderButtonTheme() {
        super("slider", "button");
    }
}
