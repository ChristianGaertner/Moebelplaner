package io.github.christiangaertner.moebelplaner.moebel;

import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.grid.AbstractEntity;
import io.github.christiangaertner.moebelplaner.grid.IMoveable;
import io.github.christiangaertner.moebelplaner.util.Vector2f;

/**
 *
 * @author Christian
 */
abstract public class AbstractMoebel extends AbstractEntity implements IMoveable {
    
    public AbstractMoebel(int x, int y, String path, boolean absolute) {
        this(x, y, new Sprite(path, absolute));
    }
    
    public AbstractMoebel(int x, int y, String path) {
        this(x, y, new Sprite(path));
    }
    
    public AbstractMoebel(int x, int y, Sprite s) {
        sprite = s;
        this.position = Vector2f.make(x, y);
    }
    
    public AbstractMoebel(Sprite s) {
        this(0, 0, s);
    }
}
