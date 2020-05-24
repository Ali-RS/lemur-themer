package com.jayfella.lemur.theme;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.util.BackgroundComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.core.GuiComponent;

public class ButtonTheme extends LabelTheme {

    private ColorRGBA color = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);
    private ColorRGBA focusColor = ColorRGBA.Green.clone();
    private ColorRGBA highlightColor = ColorRGBA.Yellow.clone();

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.0f, 0.75f, 0.75f, 0.5f));

    private Insets3f insets = new Insets3f(2, 2, 2, 2);

    public ButtonTheme() {
        super("button");
    }

    // a lof of things will extend button (checkbox, etc) so let them just extend the theme.
    public ButtonTheme(String elementId) {
        super(elementId);
    }

}
