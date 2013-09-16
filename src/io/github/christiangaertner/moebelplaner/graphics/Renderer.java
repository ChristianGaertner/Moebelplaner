package io.github.christiangaertner.moebelplaner.graphics;

/**
 *
 * @author Christian
 */
public class Renderer {
    
    public static final int IGNORE_COLOR = 0xFFFF00FF;
    
    /**
     * Der pixel Array
     */
    public int[] pixels;
    
    /**
     * Die Maße des zu renderen Bildes
     */ 
    private int width, height;

    public Renderer(int w, int h) {
        width = w;
        height = h;
        pixels = new int[w * h];
    }
    
    
    /**
     * Rendered
     * @param r
     */
    public void render(IRenderable r) {
        render(r.getSprite(), r.x(), r.y());
    }
    
    /**
     * Rendered eine Sprite an einer bestimmten Koordinate
     * @param sprite
     * @param xp
     * @param yp 
     */
    public void render(Sprite sprite, int xp, int yp) {
        
        for (int y = 0; y < sprite.getHeight(); y++) {
            int ya = y + yp;
            for (int x = 0; x < sprite.getWidth(); x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
                
                int color = sprite.pixels[x + y * sprite.getWidth()];
                
                if (color == IGNORE_COLOR) {
                    continue;
                }
                
                pixels[xa + ya * width] = color;
            }
        }
    }
    
    
    /**
     * Setzt den int[] zurück (schwarz)
     */
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
