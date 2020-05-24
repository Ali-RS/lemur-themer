package com.jayfella.lemur.theme.listbox;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;

public class ListBoxSelectorTheme extends ThemedElement {

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private TbtQuadBackgroundComponent background = BackgroundComponents.gradient(new ColorRGBA(0.4f, 0.6f, 0.6f, 0.5f));

    public ListBoxSelectorTheme() {
        super("list.selector");

        background.getMaterial().getMaterial().getAdditionalRenderState().setBlendMode(RenderState.BlendMode.AlphaAdditive);
    }
}
