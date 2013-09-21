package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.Sprite;

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
