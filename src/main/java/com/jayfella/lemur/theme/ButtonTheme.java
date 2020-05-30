package com.jayfella.lemur.theme;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class ButtonTheme extends LabelTheme {

    protected ColorRGBA color = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);
    protected ColorRGBA focusColor = ColorRGBA.Green.clone();
    protected ColorRGBA highlightColor = ColorRGBA.Yellow.clone();

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    protected GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.0f, 0.75f, 0.75f, 0.5f));

    protected Insets3f insets = new Insets3f(2, 2, 2, 2);

    public ButtonTheme() {
        super("button");
    }

    // a lof of things will extend button (checkbox, etc) so let them just extend the theme.
    public ButtonTheme(String elementId) {
        super(elementId);
    }

}
