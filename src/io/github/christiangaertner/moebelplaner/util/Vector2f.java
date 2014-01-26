package io.github.christiangaertner.moebelplaner.util;

/**
 *
 * @author Christian
 */
public class Vector2f {

    protected float x, y;

    public static Vector2f make() {
        return new Vector2f();
    }
    
    public static Vector2f make(float x, float y) {
        return new Vector2f(x, y);
    }
    
    
    public Vector2f() {
        this(0, 0);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f vector) {
        set(vector.getX(), vector.getY());
    }

    public void add(Vector2f vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }
    
    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }
    
    public void subtract(Vector2f vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
    }
    
    public void subtract(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
    
    public void scale(float scale) {
        x *= scale;
        y *= scale;
    }

    public Vector2f scalar(float scalar) {
        return new Vector2f(x * scalar, y * scalar);
    }

    public void rotate(float angle) {
        x = (float) ((x * Math.cos(angle)) - (y * Math.sin(angle)));
        y = (float) ((y * Math.cos(angle)) + (x * Math.sin(angle)));
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float crossproduct(Vector2f vector) {
        return (x * vector.getY()) - (y * vector.getX());
    }

    public float dotproduct(Vector2f vector) {
        return ((x * vector.getX()) + (y * vector.getY()));
    }

    public void normalize() {
        float mag = magnitude();

        x = x / mag;
        y = y / mag;
    }
    
    public void invert() {
        x = -x;
        y = -y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public boolean equals(Vector2f vector) {
        return ((x == vector.getX()) && (y == vector.getY()));
    }
}
