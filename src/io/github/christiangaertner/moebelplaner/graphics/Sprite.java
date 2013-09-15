package io.github.christiangaertner.moebelplaner.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian
 */
public class Sprite {

    public enum Overlay {

        FOCUS, ALERT
    }
    /**
     * Dieses Sprite kann für Fehler genutzt werden (Programm Fehler). - Farbe: rot - Größe: 16x16
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
    /**
     * Der Pfad zum Bild
     */
    protected String path;

    /**
     * Neue Sprite von Bild
     */
    public Sprite(String path) {
        this.path = path;
        loadImage(path);
    }

    /**
     * Neue einfarbige, quadratische Sprite
     */
    public Sprite(int size, int color) {
        this(size, size, color);
    }

    /**
     * Neue einfarbige Sprite
     */
    public Sprite(int w, int h, int color) {
        width = w;
        height = h;
        pixels = new int[w * h];
        setColor(color);
    }

    public Sprite(Sprite sprite, Overlay o) {
        pixels = new int[sprite.getWidth() * sprite.getHeight()];
        width = sprite.getWidth();
        height = sprite.getHeight();
        
        String p;
        
        switch(o) {
            case FOCUS:
                p = "/images/focus.png";
                break;
            default:
                /* Falls through */
            case ALERT:
                p = "/images/alert.png";
                break;
        }
        
        try {
            loadImage(overlayImages(getImage(sprite), getImage(p)));
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPath() {
        return path;
    }

    public int[] getPixels() {
        return pixels;
    }

    /**
     * Setzt den kompletten int[] auf den hex code
     *
     * @param color hex code
     */
    private void setColor(int color) {
        for (int i = 0; i < width * height; i++) {
            pixels[i] = color;
        }
    }

    /**
     * Lädt das Bild in den Pixel Array
     *
     * @param BufferedImage Das Bild
     */
    private void loadImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        this.width = w;
        this.height = h;

        pixels = new int[w * h];

        image.getRGB(0, 0, w, h, pixels, 0, w); //translate image into pixels array
    }

    /**
     * Lädt das Bild vom relativen Pfad
     *
     * @param String Weg zum Pfad (relativ)
     */
    private void loadImage(String path) {
        try {
            BufferedImage image = getImage(path);

            loadImage(image);

        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private BufferedImage overlayImages(String bg, String fg) {
        try {
            // Erstmal beide Bilder laden
            BufferedImage image = getImage(bg);
            BufferedImage overlay_raw = getImage(fg);

            BufferedImage overlay = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

            Graphics tmpG = overlay.getGraphics();

            tmpG.drawImage(overlay_raw, 0, 0, image.getWidth(), image.getHeight(), null);

            // Neues Bild erstellen
            int w = Math.max(image.getWidth(), overlay.getWidth());
            int h = Math.max(image.getHeight(), overlay.getHeight());
            BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            // paint both images, preserving the alpha channels
            Graphics g = combined.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.drawImage(overlay, 0, 0, null);

            return combined;

        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private BufferedImage overlayImages(BufferedImage bg, BufferedImage fg) {
        BufferedImage overlay = new BufferedImage(bg.getWidth(), bg.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics tmpG = overlay.getGraphics();

        tmpG.drawImage(fg, 0, 0, bg.getWidth(), bg.getHeight(), null);

        // Neues Bild erstellen
        int w = Math.max(bg.getWidth(), overlay.getWidth());
        int h = Math.max(bg.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(bg, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);

        return combined;
    }

    private BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(Sprite.class.getResource(path));
    }

    private BufferedImage getImage(Sprite sprite) throws IOException {
        if (sprite.getPath() != null) {
            return getImage(sprite.getPath());
        } else {
            BufferedImage image = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_RGB);
            WritableRaster raster = (WritableRaster) image.getRaster();
            raster.getPixels(0, 0, sprite.getWidth(), sprite.getHeight(), sprite.getPixels());
            return image;
        }
    }
}
