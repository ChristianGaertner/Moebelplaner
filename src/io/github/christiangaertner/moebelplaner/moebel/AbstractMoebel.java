package io.github.christiangaertner.moebelplaner.moebel;

import io.github.christiangaertner.moebelplaner.graphics.Renderer;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.grid.AbstractEntity;
import io.github.christiangaertner.moebelplaner.grid.IMoveable;

/**
 *
 * @author Christian
 */
abstract public class AbstractMoebel extends AbstractEntity implements IMoveable {

    /**
     * Die Sprite für dieses Möbelstück
     */
    protected Sprite sprite;
    
    /**
     * Die X-Y Koordinate auf der Grid
     */
    protected int x, y;
    
    /**
     * Erstellt ein neues Möbelstück mit einem Bild
     * @param path 
     */
    public AbstractMoebel(String path) {
        sprite = new Sprite(path);
    }
    
    /**
     * Erstellt ein Möbelstück mit einer Sprite
     * @param sprite 
     */
    public AbstractMoebel(Sprite sprite) {
        this.sprite = sprite;
    }
    
    @Override
    public void render(Renderer renderer) {
        renderer.render(this, x, y);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }
    
    @Override
    public void move(int x, int y) {
        x += x;
        y += y;
    }
    
}
