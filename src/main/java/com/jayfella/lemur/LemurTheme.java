package com.jayfella.lemur;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Transient;
import java.util.LinkedHashMap;
import java.util.Map;

public class LemurTheme {

    private static final Logger log = LoggerFactory.getLogger(LemurTheme.class);

    private String name = "AwesomeTheme";

    // we want to keep the order of insertion to maintain some kind of sanity whilst editing themes.
    @JsonProperty("elements")
    private final Map<String, ThemedElement> themedElementMap = new LinkedHashMap<>();

    public LemurTheme() {

    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Transient
    public ThemedElement get(Class<? extends ThemedElement> clazz) {
        return themedElementMap.get(clazz.getSimpleName());
    }

    @Transient
    public void add(ThemedElement themedElement) {
        themedElementMap.put(themedElement.getClass().getSimpleName(), themedElement);
    }

    @Transient
    public void putAll(Map<String, ThemedElement> elements) {
        themedElementMap.putAll(elements);
    }

    @Transient
    public int getThemedElementCount() {
        return themedElementMap.size();
    }

    @Transient
    public Map<String, ThemedElement> getThemedElementMap() {
        return themedElementMap;
    }

    public void setTheme(LemurTheme lemurTheme) {

        name = lemurTheme.name;

        themedElementMap.clear();
        themedElementMap.putAll(lemurTheme.themedElementMap);

    }

}
