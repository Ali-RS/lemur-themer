package com.jayfella.lemur.theme;

import com.jayfella.lemur.ThemedElement;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.simsilica.lemur.Insets3f;
import com.simsilica.lemur.Label;

public class LabelTheme extends ThemedElement {

    protected ColorRGBA color = new ColorRGBA(0.5f, 0.75f, 0.75f, 0.85f);
    protected Insets3f insets = new Insets3f(2, 2, 2, 2);

    protected boolean textShadow = false;
    protected ColorRGBA shadowColor = new ColorRGBA(0.0f, 0.0f, 0.0f, 1.0f);
    protected Vector3f shadowOffset = new Vector3f(2, -2, -1);

    public LabelTheme() {
        super(Label.ELEMENT_ID);
    }

    // a lof of things will extend label (button, etc) so let them just extend the theme.
    public LabelTheme(String elementId) {
        super(elementId);
    }

    public LabelTheme(String elementId, String child) {
        super(elementId, child);
    }

}
