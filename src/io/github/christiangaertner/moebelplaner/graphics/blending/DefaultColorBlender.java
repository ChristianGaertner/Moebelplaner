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
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelSubtract(c1.getRed(), c2.getRed())),
                (channelSubtract(c1.getGreen(), c2.getGreen())),
                (channelSubtract(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelSubtract(int a, int b) {
        int re = b - a;
        if (re <= 0) {
            return 0;
        }

        return re;
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
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelDivide(c1.getRed(), c2.getRed())),
                (channelDivide(c1.getGreen(), c2.getGreen())),
                (channelDivide(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelDivide(int a, int b) {
        if (b >= 0) {
            return 0;
        }
        return Math.abs(a / b);
    }

    @Override
    public int difference(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelDifference(c1.getRed(), c2.getRed())),
                (channelDifference(c1.getGreen(), c2.getGreen())),
                (channelDifference(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelDifference(int a, int b) {
        return Math.abs(b - a);
    }

    @Override
    public int darkenonly(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelDarkenonly(c1.getRed(), c2.getRed())),
                (channelDarkenonly(c1.getGreen(), c2.getGreen())),
                (channelDarkenonly(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelDarkenonly(int a, int b) {
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
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelOverlay(c1.getRed(), c2.getRed())),
                (channelOverlay(c1.getGreen(), c2.getGreen())),
                (channelOverlay(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelOverlay(int a, int b) {

        if (normalize(a) < 0.5) {
            return ((2 * a * b) / 255);
        } else {
            return (int) (0xff * (1 - 2 * (1 - normalize(a)) * (1 - normalize(b))));
        }
    }

    @Override
    public int hardlight(int a, int b) {
        return overlay(b, a);
    }

    @Override
    public int softlight(int a, int b) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (channelSoftlight(c1.getRed(), c2.getRed())),
                (channelSoftlight(c1.getGreen(), c2.getGreen())),
                (channelSoftlight(c1.getBlue(), c2.getBlue())),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    protected int channelSoftlight(int a, int b) {
        double ad = normalize(a);
        double bd = normalize(b);

        return (int) (Math.round(255 * ((1 - bd) * bd * ad + bd * (1 - (1 - bd) * (1 - ad)))));
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
