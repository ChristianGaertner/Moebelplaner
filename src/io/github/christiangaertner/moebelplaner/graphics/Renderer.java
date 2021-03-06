package io.github.christiangaertner.moebelplaner.graphics;

import io.github.christiangaertner.moebelplaner.graphics.blending.BlendingMode;
import io.github.christiangaertner.moebelplaner.graphics.blending.IColorBlender;

/**
 *
 * @author Christian
 */
public class Renderer {

    private final IColorBlender blender;
    public static final int IGNORE_COLOR = 0xFFFF00FF;
    /**
     * Der pixel Array
     */
    public int[] pixels;
    /**
     * Die Maße des zu renderen Bildes
     */
    private int width, height;

    public Renderer(int w, int h, IColorBlender blender) {
        this.blender = blender;
        width = w;
        height = h;
        pixels = new int[w * h];
    }

    /**
     * Rendered im Normal Mode
     *
     * @param r
     */
    public void render(IRenderable r) {
        render(r, 100);
    }

    /**
     * Rendered im Normal Mode
     *
     * @param r
     */
    public void render(IRenderable r, int o) {
        render(BlendingMode.NORMAL, r.getSprite(), r.x(), r.y(), o);
    }

    /**
     * Rendered eine Sprite an einer bestimmten Koordinate (Normal Mode)
     *
     * @param sprite
     * @param xp
     * @param yp
     */
    public void render(Sprite sprite, int xp, int yp) {

        render(sprite, xp, yp, 100);
    }

    /**
     * Rendered eine Sprite an einer bestimmten Koordinate (Normal Mode)
     *
     * @param sprite
     * @param xp
     * @param yp
     */
    public void render(Sprite sprite, int xp, int yp, int o) {

        render(BlendingMode.NORMAL, sprite, xp, yp, o);
    }

    /**
     * Rendered im bestimmten Mode
     *
     * @param r
     */
    public void render(BlendingMode mode, IRenderable r) {
        render(mode, r.getSprite(), r.x(), r.y(), 100);
    }

    /**
     * Rendered im bestimmten Mode
     *
     * @param r
     */
    public void render(BlendingMode mode, IRenderable r, int o) {
        render(mode, r.getSprite(), r.x(), r.y(), o);
    }

    /**
     * Rendered eine Sprite an einer bestimmten Koordinate in einem bestimmten Mode
     *
     * @param sprite
     * @param xp
     * @param yp
     * @param o Opacity
     */
    public void render(BlendingMode mode, Sprite sprite, int xp, int yp, int o) {

        for (int y = 0; y < sprite.getHeight(); y++) {
            int ya = y + yp;
            for (int x = 0; x < sprite.getWidth(); x++) {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) {
                    continue;
                }

                int color = sprite.pixels[x + y * sprite.getWidth()];

                if (color == IGNORE_COLOR) {
                    continue;
                }

                switch (mode) {
                    default:
                    /* Falls through */
                    case NORMAL:
                        pixels[xa + ya * width] = blender.normal(pixels[xa + ya * width], color);
                        break;
                    case AVERAGE:
                        pixels[xa + ya * width] = blender.average(pixels[xa + ya * width], color);
                        break;
                    case ADD:
                        pixels[xa + ya * width] = blender.add(pixels[xa + ya * width], color);
                        break;
                    case SUBTRACT:
                        pixels[xa + ya * width] = blender.subtract(pixels[xa + ya * width], color);
                        break;
                    case MULTIPLY:
                        pixels[xa + ya * width] = blender.multiply(pixels[xa + ya * width], color);
                        break;
                    case DIVIDE:
                        pixels[xa + ya * width] = blender.divide(pixels[xa + ya * width], color);
                        break;
                    case DIFFERENCE:
                        pixels[xa + ya * width] = blender.difference(pixels[xa + ya * width], color);
                        break;
                    case DARKENONLY:
                        pixels[xa + ya * width] = blender.darkenonly(pixels[xa + ya * width], color);
                        break;
                    case LIGHTENONLY:
                        pixels[xa + ya * width] = blender.lightenonly(pixels[xa + ya * width], color);
                        break;
                    case SCREEN:
                        pixels[xa + ya * width] = blender.screen(pixels[xa + ya * width], color);
                        break;
                    case OVERLAY:
                        pixels[xa + ya * width] = blender.overlay(pixels[xa + ya * width], color);
                        break;
                    case HARDLIGHT:
                        pixels[xa + ya * width] = blender.hardlight(pixels[xa + ya * width], color);
                        break;
                    case SOFTLIGHT:
                        pixels[xa + ya * width] = blender.softlight(pixels[xa + ya * width], color);
                        break;
                    case COLORBURN:
                        pixels[xa + ya * width] = blender.colorburn(pixels[xa + ya * width], color);
                        break;
                    case EXCLUSION:
                        pixels[xa + ya * width] = blender.exclusion(pixels[xa + ya * width], color);
                        break;
                    case HARDMIX:
                        pixels[xa + ya * width] = blender.hardmix(pixels[xa + ya * width], color);
                        break;
                    case VIVIDLIGHT:
                        pixels[xa + ya * width] = blender.vividlight(pixels[xa + ya * width], color);
                        break;
                    case COLORDOGE:
                        pixels[xa + ya * width] = blender.colordoge(pixels[xa + ya * width], color);
                        break;
                }
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
