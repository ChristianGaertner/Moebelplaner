package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author Christian
 */
class Highlight extends AbstractEntity implements IMoveable {   

    public enum Type {

        FOCUS, ALERT
    }
    private Type type;

    public Highlight(Type type, int x, int y, int xs, int ys) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.sprite = getSpriteForType(type, xs, ys);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean isType(Type type) {
        return (type == this.type);
    }

    private Sprite getSpriteForType(Type type, int xs, int ys) {
        Sprite sprite;
        switch (type) {
            case FOCUS:
                sprite = new Sprite("/images/focus.png");
                break;
            default:
            /* Falls through */
            case ALERT:
                sprite = new Sprite("/images/alert.png");
                break;
        }
        try {
            sprite.resize(xs, ys);
        } catch (IOException ex) {
            Moebelplaner.LOGGER.log(Level.SEVERE, "Fehler beim Resizen des Highlight Bildes", ex);
        }
        return sprite;
    }
    
    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
