package com.jayfella.lemur.theme.slider;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jayfella.lemur.util.BackgroundUtils;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.core.GuiComponent;

public class SliderLeftButtonTheme extends ThemedElement {

    private String text = "-";

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.doubleGradient(new ColorRGBA(0.5f, 0.75f, 0.75f, 0.5f));

    private ColorRGBA color = new ColorRGBA(0.6f, 0.8f, 0.8f, 0.85f);

    public SliderLeftButtonTheme() {
        super("slider.left.button");

        BackgroundUtils.setMargin(background, 5, 0);
    }
}
