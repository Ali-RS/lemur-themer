package com.jayfella.lemur.theme.slider;

import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;

public class SliderThumbButtonTheme extends ThemedElement {

    private String text = "[]";
    private ColorRGBA color = new ColorRGBA(0.6f, 0.8f, 0.8f, 0.85f);

    public SliderThumbButtonTheme() {
        super("slider.thumb.button");
    }
}
