package com.jayfella.lemur.util;

import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.texture.plugins.AWTLoader;
import jme3tools.converters.ImageToAwt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class TextureUtils {

    /**
     * Converts a base64 String to a texture.
     * @param base64String the Base64 Image.
     * @return a Texture of the given image.
     */
    public Texture fromBase64(String base64String) {

        byte[] imageData = Base64.getDecoder().decode(base64String);

        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData)) {

            BufferedImage bImage = ImageIO.read(bis);

            AWTLoader loader = new AWTLoader();
            Image image = loader.load(bImage, true);

            return new Texture2D(image);

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Converts a texture to a Base64 String Image.
     * @param texture the input texture.
     * @return a Base64 String representation of the Image.
     */
    public String toBase64(Texture texture) {

        BufferedImage bufferedImage = ImageToAwt.convert(texture.getImage(), false, true, 0);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, "png", baos);

            bufferedImage.flush();

            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }



}
