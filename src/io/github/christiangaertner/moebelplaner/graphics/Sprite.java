package io.github.christiangaertner.moebelplaner.graphics;

/**
 *
 * @author Christian
 */
public class Sprite {
    
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
    
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
}
