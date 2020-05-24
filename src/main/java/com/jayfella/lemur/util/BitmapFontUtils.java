package com.jayfella.lemur.util;

import com.jayfella.lemur.theme.font.AngelFont;
import com.jme3.font.BitmapCharacter;
import com.jme3.font.BitmapCharacterSet;
import com.jme3.font.BitmapFont;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.texture.Texture;
import com.simsilica.lemur.GuiGlobals;
import com.simsilica.lemur.core.GuiMaterial;

import java.util.Base64;

public class BitmapFontUtils {

    public static BitmapFont fromAngelFont(AngelFont angelFont) {
        return load(angelFont.getBase64Font(), angelFont.getBase64Images());
    }

    public static BitmapFont load(String bas64Fnt, String... base64Images) {

        byte[] fntFileData = Base64.getDecoder().decode(bas64Fnt);
        String fntFile = new String(fntFileData);

        // MaterialDef spriteMat = (MaterialDef) assetManager.loadAsset(new AssetKey<Material>("Common/MatDefs/Misc/Unshaded.j3md"));
        GuiMaterial guiMaterial = GuiGlobals.getInstance().createMaterial(false);
        Material spriteMat = guiMaterial.getMaterial();

        BitmapFont font = new BitmapFont();
        BitmapCharacterSet charSet = new BitmapCharacterSet();
        font.setCharSet(charSet);

        Material[] matPages = null;
        String[] lines = fntFile.split("\n");

        String regex = "[\\s=]+";

        for (String line : lines) {

            String[] tokens = line.split(regex);
            if (tokens[0].equals("info")){
                // Get rendered size
                for (int i = 1; i < tokens.length; i++){
                    if (tokens[i].equals("size")){
                        charSet.setRenderedSize(Integer.parseInt(tokens[i + 1]));
                    }
                }
            }else if (tokens[0].equals("common")){
                // Fill out BitmapCharacterSet fields
                for (int i = 1; i < tokens.length; i++){
                    String token = tokens[i];
                    if (token.equals("lineHeight")){
                        charSet.setLineHeight(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("base")){
                        charSet.setBase(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("scaleW")){
                        charSet.setWidth(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("scaleH")){
                        charSet.setHeight(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("pages")){
                        // number of texture pages
                        matPages = new Material[Integer.parseInt(tokens[i + 1])];
                        font.setPages(matPages);
                    }
                }
            }else if (tokens[0].equals("page")){
                int index = -1;
                Texture tex = null;

                for (int i = 1; i < tokens.length; i++){
                    String token = tokens[i];
                    if (token.equals("id")){
                        index = Integer.parseInt(tokens[i + 1]);
                    }else if (token.equals("file")){

//                        String file = tokens[i + 1];
//                        if (file.startsWith("\"")){
//                            file = file.substring(1, file.length()-1);
//                        }
//                        TextureKey key = new TextureKey(folder + file, true);
//                        key.setGenerateMips(false);
//                        tex = assetManager.loadTexture(key);

                        tex = new TextureUtils().fromBase64(base64Images[index]);
                        tex.setMagFilter(Texture.MagFilter.Bilinear);
                        tex.setMinFilter(Texture.MinFilter.BilinearNoMipMaps);
                    }
                }
                // set page
                if (index >= 0 && tex != null){
                    // Material mat = new Material(spriteMat);
                    Material mat = spriteMat.clone();
                    mat.setTexture("ColorMap", tex);
                    mat.setBoolean("VertexColor", true);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    matPages[index] = mat;
                }
            }else if (tokens[0].equals("char")){
                // New BitmapCharacter
                BitmapCharacter ch = null;
                for (int i = 1; i < tokens.length; i++){
                    String token = tokens[i];
                    if (token.equals("id")){
                        int index = Integer.parseInt(tokens[i + 1]);
                        ch = new BitmapCharacter();
                        charSet.addCharacter(index, ch);
                    }else if (token.equals("x")){
                        ch.setX(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("y")){
                        ch.setY(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("width")){
                        ch.setWidth(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("height")){
                        ch.setHeight(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("xoffset")){
                        ch.setXOffset(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("yoffset")){
                        ch.setYOffset(Integer.parseInt(tokens[i + 1]));
                    }else if (token.equals("xadvance")){
                        ch.setXAdvance(Integer.parseInt(tokens[i + 1]));
                    } else if (token.equals("page")) {
                        ch.setPage(Integer.parseInt(tokens[i + 1]));
                    }
                }
            }else if (tokens[0].equals("kerning")){
                // Build kerning list
                int index = 0;
                int second = 0;
                int amount = 0;

                for (int i = 1; i < tokens.length; i++){
                    if (tokens[i].equals("first")){
                        index = Integer.parseInt(tokens[i + 1]);
                    }else if (tokens[i].equals("second")){
                        second = Integer.parseInt(tokens[i + 1]);
                    }else if (tokens[i].equals("amount")){
                        amount = Integer.parseInt(tokens[i + 1]);
                    }
                }

                BitmapCharacter ch = charSet.getCharacter(index);
                ch.addKerning(second, amount);
            }
        }

        return font;
    }

}
