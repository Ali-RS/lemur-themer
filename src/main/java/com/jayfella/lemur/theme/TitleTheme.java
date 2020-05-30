package com.jayfella.lemur.theme;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class TitleTheme extends ThemedElement {

    protected ColorRGBA color = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);
    protected ColorRGBA highlightColor = new ColorRGBA(1.0f, 0.8f, 1.0f, 0.85f);
    protected ColorRGBA shadowColor = new ColorRGBA(0.0f, 0.0f, 0.0f, 0.75f);

    protected Vector3f shadowOffset = new Vector3f(2, -2, -1);

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    protected GuiComponent background = BackgroundComponents.doubleGradient(new ColorRGBA(0.5f, 0.75f, 0.85f, 0.5f));

    protected Insets3f insets = new Insets3f(2,2,2,2);

    public TitleTheme() {
        super("title");
    }
}
