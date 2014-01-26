package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.util.Vector2f;

/**
 *
 * @author Christian
 */
class Highlight extends AbstractEntity {   

    public enum Type {

        FOCUS, ALERT
    }
    private Type type;

    public Highlight(Type type, int x, int y, int xs, int ys) {
        this.position = Vector2f.make(x, y);
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
        Sprite s;
        switch (type) {
            case FOCUS:
                s = new Sprite(xs, ys, 0xFF00FF00);
                break;
            default:
            /* Falls through */
            case ALERT:
                s = new Sprite(xs, ys, 0xFFFF0000);
                break;
        }
        return s;
    }
}
