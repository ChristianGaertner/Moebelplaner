package io.github.christiangaertner.moebelplaner.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian
 */
public class Sprite {

    /**
     * Dieses Sprite kann für Fehler genutzt werden (Programm Fehler).
     * - Farbe: rot
     * - Größe: 16x16
     */ 
    public static final Sprite ERROR = new Sprite(16, 0xFF0000);

    /**
     * X-Y Koordinaten auf der Grid
     */
    protected int x, y;
    /**
     * Höhe und Breite der Sprite
     */
    protected int width, height;
    /**
     * Die Farbwerte als int[]
     */
    protected int[] pixels;

    public Sprite(String path) {
        loadImage(path);
    }
    
    public Sprite(int size, int color) {
        this(size, size, color);
    }

    public Sprite(int w, int h, int color) {
        width = w;
        height = h;
        pixels = new int[w * h];
        setColor(color);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void setColor(int color) {
        for (int i = 0; i < width * height; i++) {
            pixels[i] = color;
        }
    }
    
    
    private void loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(Sprite.class.getResource(path));
            
            int w = image.getWidth();
            int h = image.getHeight();
            
            this.width = w;
            this.height = h;
            
            pixels = new int[w * h];
            
            image.getRGB(0, 0, w, h, pixels, 0, w); //translate image into pixels array
            
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
