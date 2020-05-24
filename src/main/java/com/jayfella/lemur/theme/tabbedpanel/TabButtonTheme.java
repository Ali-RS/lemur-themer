package com.jayfella.lemur.theme.tabbedpanel;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class TabButtonTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.25f, 0.5f, 0.5f, 0.5f));

    private ColorRGBA color = new ColorRGBA(0.4f, 0.45f, 0.5f, 0.85f);
    private Insets3f insets = new Insets3f(4, 2, 0, 2);

    public TabButtonTheme() {
        super("tab.button");
    }
}
