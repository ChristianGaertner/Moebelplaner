package io.github.christiangaertner.moebelplaner.moebel;

import io.github.christiangaertner.moebelplaner.graphics.Sprite;
import io.github.christiangaertner.moebelplaner.graphics.Sprite.Overlay;
import io.github.christiangaertner.moebelplaner.grid.AbstractEntity;
import io.github.christiangaertner.moebelplaner.grid.IMoveable;

/**
 *
 * @author Christian
 */
abstract public class AbstractMoebel extends AbstractEntity implements IMoveable {

    /**
     * Erstellt ein neues Möbelstück mit einem Bild
     *
     * @param path
     */
    public AbstractMoebel(String path) {
        this(new Sprite(path));

    }

    /**
     * Erstellt ein Möbelstück mit einer Sprite
     *
     * @param s
     */
    public AbstractMoebel(Sprite s) {
        sprite = s;
        focusSprite = new Sprite(sprite, Overlay.FOCUS);
        alertSprite = new Sprite(sprite, Overlay.ALERT);
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
