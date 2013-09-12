package io.github.christiangaertner.moebelplaner.graphics;

/**
 *
 * @author Christian
 */
public interface IRenderable {
    
    /**
     * Rendererd das Bild
     * @param renderer 
     */
    public void render(Renderer renderer);
    
    /**
     * Gibt einfach nur die Sprite zurück
     * @return 
     */
    public Sprite getSprite();
    
    /**
     * Die X-Koordinate auf der Grid
     * @return 
     */
    public int x();
    
    /**
     * Die X-Koordinate auf der Grid
     * @return 
     */
    public int y();
    
}
