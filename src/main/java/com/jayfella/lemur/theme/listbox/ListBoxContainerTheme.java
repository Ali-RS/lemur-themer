package com.jayfella.lemur.theme.listbox;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class ListBoxContainerTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.25f, 0.5f, 0.5f, 0.5f));
    private Insets3f insets = new Insets3f(2, 2, 2, 2, 2, 2);

    public ListBoxContainerTheme() {
        super("list.container");
    }
}
