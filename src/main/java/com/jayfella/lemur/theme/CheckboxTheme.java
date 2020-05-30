package com.jayfella.lemur.theme;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayfella.lemur.util.IconComponents;
import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.Checkbox;
import com.simsilica.lemur.component.IconComponent;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class CheckboxTheme extends ButtonTheme {

    protected ColorRGBA color = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    protected GuiComponent background = new QuadBackgroundComponent(new ColorRGBA(0, 0, 0, 0));

    protected IconComponent onView = IconComponents.defaultCheckBoxIcon(true);
    protected IconComponent offView = IconComponents.defaultCheckBoxIcon(false);

    public CheckboxTheme() {
        super(Checkbox.ELEMENT_ID);
    }

    public CheckboxTheme(String elementId) {
        super(elementId);
    }

}
