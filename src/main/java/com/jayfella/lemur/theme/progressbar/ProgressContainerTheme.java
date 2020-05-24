package com.jayfella.lemur.theme.progressbar;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class ProgressContainerTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = new QuadBackgroundComponent(new ColorRGBA(0.2f, 0.2f, 0.2f, 0.5f), 2, 2);

    public ProgressContainerTheme() {
        super("progress", "container");
    }
}
