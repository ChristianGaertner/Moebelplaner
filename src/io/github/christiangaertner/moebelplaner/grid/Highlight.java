package io.github.christiangaertner.moebelplaner.grid;

import io.github.christiangaertner.moebelplaner.graphics.Sprite;

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

        sprite.resize(xs, ys);
        return sprite;
    }
}
