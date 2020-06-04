package com.jayfella.lemur.theme;

import com.jayfella.lemur.ThemedElement;
import com.jayfella.lemur.theme.font.AngelFont;
import com.jayfella.lemur.util.AngelFonts;

public class GlobalTheme extends ThemedElement {

    protected float fontSize = 14.0f;
    protected AngelFont font = AngelFonts.nimulaUI();

    public GlobalTheme() {
        super("");
    }

}
