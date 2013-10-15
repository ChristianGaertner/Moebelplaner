package io.github.christiangaertner.moebelplaner.graphics.blending;

import java.awt.Color;

/**
 *
 * @author Christian
 */
public class DefaultColorBlender implements IColorBlender {

    protected static double normalize(int c) {
        return c / 255.0f;
    }

    @Override
    public int normal(int a, int b) {
        return b;
    }

    @Override
    public int average(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (c1.getRed() * c1.getAlpha() + c2.getRed() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getGreen() * c1.getAlpha() + c2.getGreen() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getBlue() * c1.getAlpha() + c2.getBlue() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (c1.getRed() * c2.getRed() / 0xff),
                (c1.getGreen() * c2.getGreen() / 0xff),
                (c1.getBlue() * c2.getBlue() / 0xff),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public int difference(int a, int b) {
        return Math.abs(a - b);
    }

    @Override
    public int darkenonly(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    @Override
    public int lightenonly(int a, int b) {
        return darkenonly(b, a);
    }

    @Override
    public int screen(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelScreen(c1.getRed(), c2.getRed())),
                (channelScreen(c1.getGreen(), c2.getGreen())),
                (channelScreen(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }
    
    protected int channelScreen(int a, int b) {
        return (int) Math.round(255 * (1 - ((1 - normalize(a)) * (1 - normalize(b)))));
    }

    @Override
    public int overlay(int a, int b) {
        if (a < 0.5) {
            return (2 * a * b);
        } else {
            return (1 - 2 * (1 - a) * (1 - b));
        }
    }

    @Override
    public int hardlight(int a, int b) {
        return overlay(b, a);
    }

    @Override
    public int softlight(int a, int b) {
        if (b < 0.5) {
            return (2 * a * b + a * a * (1 - 2 * b));
        } else {
            return (int) (2 * a * (1 - b) + Math.sqrt(a) * (2 * b - 1));
        }
    }

    @Override
    public int colorburn(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelColorBurn(c1.getRed(), c2.getRed())),
                (channelColorBurn(c1.getGreen(), c2.getGreen())),
                (channelColorBurn(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelColorBurn(int a, int b) {
        if (b == 0) {
            return 0;
        }

        int color = (int) (255 * (1 - (1 - normalize(a)) / normalize(b)));
        return (color < 0) ? 0 : color;
    }
}
