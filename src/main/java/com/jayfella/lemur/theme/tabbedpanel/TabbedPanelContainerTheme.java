package com.jayfella.lemur.theme.tabbedpanel;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class TabbedPanelContainerTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = new QuadBackgroundComponent(ColorRGBA.BlackNoAlpha);

    public TabbedPanelContainerTheme() {
        super("tabbedPanel.container");
    }
}
