package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.IRenderable;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.graphics.blending.BlendingMode;
import io.github.christiangaertner.moebelplaner.util.Vector2f;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Christian
 */
abstract public class AbstractEntity implements IRenderable, IUpdateable, IFocusable, IAlertable, IMoveable {

    /**
     * Die Sprite für diese Entity
     */
    protected Sprite sprite;
    /**
     * Zeigt an, ob die Entity fokussiert ist
     */
    protected boolean focused = false;
    /**
     * Zeigt an, ob die Entity alamiert worden ist
     */
    protected boolean alerted = false;
    /**
     * Die X-Y Koordinate auf der Grid
     */
    protected Vector2f position;
    
    /**
     * Gibt den bevorzugten RenderMode dieser Entity wieder
     * @return 
     */
    public BlendingMode getRenderMode() {
        return BlendingMode.NORMAL;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public int x() {
        return (int) position.getX();
    }

    @Override
    public int y() {
        return (int) position.getY();
    }
    
    public Vector2f getPosition() {
        return position;
    }

    @Override
    public Shape getBoundaries() {
        return new Rectangle2D.Double(position.getX(), position.getY(), sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void update() {
    }

    @Override
    public void focus() {
        focused = true;
    }

    @Override
    public void unFocus() {
        focused = false;
    }

    @Override
    public boolean isFocused() {
        return focused;
    }

    @Override
    public void alert() {
        alerted = true;
    }

    @Override
    public void unAlert() {
        alerted = false;
    }

    @Override
    public boolean isAlerted() {
        return alerted;
    }
    
    @Override
    public void move(int x, int y) {
        position.add(x, y);
    }

    @Override
    public void moveTo(int x, int y) {
        position.set(x, y);
    }
}
