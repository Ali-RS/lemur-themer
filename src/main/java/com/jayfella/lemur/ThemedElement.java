package com.jayfella.lemur;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
public abstract class ThemedElement {

    private final String elementId;
    private final String child;

    public ThemedElement(String elementId) {
        this(elementId, "");
    }

    public ThemedElement(String elementId, String child) {
        this.elementId = elementId;
        this.child = child;
    }

    String getElementId() {
        return elementId;
    }

    public String getChild() {
        return child;
    }
}
