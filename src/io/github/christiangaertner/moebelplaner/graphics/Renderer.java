package io.github.christiangaertner.moebelplaner.graphics;

/**
 *
 * @author Christian
 */
public class Renderer {
    
    /**
     * Der pixel Array
     */
    public int[] pixels;

    public Renderer(int w, int h) {
        pixels = new int[w * h];
    }
}
