package com.jayfella.lemur.theme;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.core.GuiComponent;

public class RollupPanelTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.25f, 0.5f, 0.5f, 0.5f));

    public RollupPanelTheme() {
        // RollupPanel.ELEMENT_ID returns "panel" for some reason.
        super("rollup");
    }

}
