# Lemur-Themer


A Theming library allowing the creation, loading and saving of themes for Lemur.

Themes are saved in `JSON` format.

### Using the Themer

Themes are loaded using the `setTheme(String)` or `setTheme(File)` methods.
Themes are saved using the `saveActiveTheme()` method.
If the theme does not exist one will be created and populated by the default glass theme.

```java
public class TestThemeLoading extends SimpleApplication {

    public static void main(String... args) {

        TestThemeLoading testThemeLoading = new TestThemeLoading();

        AppSettings appSettings = new AppSettings(true);
        appSettings.setResolution(800, 600);

        testThemeLoading.setSettings(appSettings);
        testThemeLoading.setShowSettings(false);
        testThemeLoading.start();

    }

    private TestThemeLoading() {
        super (new AppState[0]);
    }

    @Override
    public void simpleInitApp() {

        GuiGlobals.initialize(this);

        LemurThemer lemurThemer = new LemurThemer();
        lemurThemer.setTheme("./mytheme.lemur.json");

        Container container = new Container();
        container.addChild(new Label("I am a themed label."));
        container.addChild(new Button("I am a themed button"));
        container.addChild(new Checkbox("I am a themed checkbox"));

        container.setLocalTranslation(new Vector3f(
                cam.getWidth() * 0.5f - container.getPreferredSize().x * 0.5f,
                cam.getHeight() * 0.5f + container.getPreferredSize().y * 0.5f,
                1.0f));

        guiNode.attachChild(container);

    }

}
```

### Extending Themes

Users that have created custom GUI elements can also have them themed. To theme a custom element create a `class` that
extends `ThemedElement`. If your element extends an existing element, extend that `ThemedElement` too. For example if
your element extends `Label` then your ThemedElement should extend `LabelTheme`. This will give it all of the properties
of the label theme in addition to your custom properties. Below is an example of the built-in `ButtonTheme` that extends
`LabelTheme`.

```java
public class ButtonTheme extends LabelTheme {

    private ColorRGBA color = new ColorRGBA(0.8f, 0.9f, 1.0f, 0.85f);
    private ColorRGBA focusColor = ColorRGBA.Green.clone();
    private ColorRGBA highlightColor = ColorRGBA.Yellow.clone();

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
    private GuiComponent background = BackgroundComponents.gradient(new ColorRGBA(0.0f, 0.75f, 0.75f, 0.5f));

    private Insets3f insets = new Insets3f(2, 2, 2, 2);

    // The ElementId this class will be applying the theme to.
    public ButtonTheme() {
        super("button");
    }

    public ButtonTheme(String elementId) {
        super(elementId);
    }

}
```

Field names are consistent with the attribute name you are applying. For example, the field `color` will apply the
attribute "color" to the element "button" with the value of the color field. This is equivalent to:

```java
attributes = styles.getSelector("button", "glass");
attributes.set("color", color);
attributes.set("focusColor", focusColor);
attributes.set("highlightColor", highlightColor)
```

### Polymorphic fields

For polymorphic fields the JSON parser needs to understand which class to construct. To advise the JSON parser we add
an `Annotation` to the field. The annotation is instructing the JSON parser to create and read a field called "@class"
to store the fully-qualified class name.

```
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS)
```

### Theme Packages
Lemur-Themer scans for classes that extend ThemedElement and applies the theme automatically. Scanning the entire
classpath can take a considerable amount of time in large projects or low-power devices such as a mobile device or
raspberry Pi. To alleviate this issue the user **must place their theme classes in the** `com.jayfella.lemur.theme`
package.

