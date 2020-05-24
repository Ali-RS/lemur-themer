package com.jayfella.lemur.theme.listbox;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class ListBoxItemTheme extends ThemedElement {

    private ColorRGBA color = new ColorRGBA(0.5f, 0.75f, 0.75f, 0.85f);

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = new QuadBackgroundComponent(ColorRGBA.BlackNoAlpha.clone());

    public ListBoxItemTheme() {
        super("list.item");
    }
}
