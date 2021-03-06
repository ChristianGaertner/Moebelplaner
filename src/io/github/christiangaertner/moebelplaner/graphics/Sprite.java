package io.github.christiangaertner.moebelplaner.graphics;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author Christian
 */
public class Sprite {

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
        loadImage(path, false);
    }
    
    /**
     * Neue Sprite von Bild
     */
    public Sprite(String path, boolean absolute) {
        this.path = path;
        loadImage(path, absolute);
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
    /**
     * Erstellt eine neue Sprite von einem Bild
     * @param image 
     */
    public Sprite(BufferedImage image) {
        loadImage(image);
    }

    public void resize(int xs, int ys) throws IOException {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        
        int i = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, pixels[i]);
                i++;
            }
        }
        
        image = Thumbnails.of(image).forceSize(xs, ys).asBufferedImage();
        loadImage(image);
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
    
    private void loadImage(String path, boolean absolute) {
        try {
            BufferedImage image = getImage(path, absolute);

            loadImage(image);

        } catch (IOException ex) {
            Moebelplaner.LOGGER.log(Level.SEVERE, "Bild konnte nicht geladen werden", ex);
        }
    }

    private BufferedImage getImage(String path, boolean absolute) throws IOException {
        if (absolute) {
            return ImageIO.read(new File(path));
        } else {
            return ImageIO.read(Sprite.class.getResource(path));
        }
    }
}
