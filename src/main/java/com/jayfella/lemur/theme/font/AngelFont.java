package com.jayfella.lemur.theme.font;

public class AngelFont {

    private String base64Font;
    private String[] base64Images;

    // serialization
    public AngelFont() {

    }

    public AngelFont(String base64Font, String... base64Images) {

        this.base64Font = base64Font;
        this.base64Images = base64Images;

    }

    public String getBase64Font() {
        return base64Font;
    }

    public String[] getBase64Images() {
        return base64Images;
    }
}
