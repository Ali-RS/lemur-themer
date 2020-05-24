package com.jayfella.lemur;

import com.jayfella.lemur.util.TextureUtils;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture;
import com.simsilica.lemur.Container;
import com.simsilica.lemur.GuiGlobals;
import com.simsilica.lemur.component.TbtQuadBackgroundComponent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImageEncoder extends SimpleApplication {

    public static void main(String... args) throws IOException {

        ImageEncoder imageEncoder = new ImageEncoder();

        imageEncoder.setShowSettings(false);
        imageEncoder.start();

    }


    @Override
    public void simpleInitApp() {

        GuiGlobals.initialize(this);

        String filePath = "/media/jayfella/Storage Drive/github/Lemur/src/main/resources/com/simsilica/lemur/icons/bordered-gradient.png";

        try {
            byte[] fileContent = Files.readAllBytes(new File(filePath).toPath());
            byte[] encodedData = Base64.getEncoder().encode(fileContent);
            String imageString = new String(encodedData);

            Texture texture = new TextureUtils().fromBase64(imageString);

            Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            material.setTexture("ColorMap", texture);
            material.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);

            Geometry geometry = new Geometry("Image", new Quad(2,2));
            geometry.setMaterial(material);

            Container container = new Container();
            container.setPreferredSize(new Vector3f(texture.getImage().getWidth(), texture.getImage().getHeight(), 1));
            TbtQuadBackgroundComponent bg = TbtQuadBackgroundComponent.create(texture, 1, 1, 1, 126, 126, 1, false);
            bg.setColor(new ColorRGBA(0.25f, 0.5f, 0.5f, 0.5f));
            container.setBackground(bg);
            container.setLocalTranslation(0, cam.getHeight(), 1);

            guiNode.attachChild(container);
            rootNode.attachChild(geometry);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
