package com.jayfella.lemur.theme.tabbedpanel;

import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;

public class TabbedPanelTheme extends ThemedElement {

    private ColorRGBA activationColor = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);

    public TabbedPanelTheme() {
        super("tabbedPanel");
    }
}
