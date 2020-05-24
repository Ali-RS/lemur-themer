package com.jayfella.lemur.theme.progressbar;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class ProgressValueTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = new QuadBackgroundComponent(new ColorRGBA(0.1f, 0.7f, 0.3f, 1));

    public ProgressValueTheme() {
        super("progress", "value");
    }
}
