package com.jayfella.lemur.util;

import com.jme3.math.ColorRGBA;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;
import com.simsilica.lemur.core.GuiComponent;

public class BackgroundUtils {

    public static void setMargin(GuiComponent guiComponent, float x, float y) {
        if (guiComponent instanceof QuadBackgroundComponent) {
            QuadBackgroundComponent backgroundComponent = (QuadBackgroundComponent) guiComponent;
            backgroundComponent.setMargin(x, y);
        }
        else if (guiComponent instanceof TbtQuadBackgroundComponent) {
            TbtQuadBackgroundComponent backgroundComponent = (TbtQuadBackgroundComponent) guiComponent;
            backgroundComponent.setMargin(x, y);
        }
    }

    public static ColorRGBA getBackgroundColor(GuiComponent guiComponent) {

        if (guiComponent instanceof QuadBackgroundComponent) {
            QuadBackgroundComponent backgroundComponent = (QuadBackgroundComponent) guiComponent;
            return backgroundComponent.getColor();
        }
        else if (guiComponent instanceof TbtQuadBackgroundComponent) {
            TbtQuadBackgroundComponent backgroundComponent = (TbtQuadBackgroundComponent) guiComponent;
            return  backgroundComponent.getColor();
        }

        return null;
    }

}
