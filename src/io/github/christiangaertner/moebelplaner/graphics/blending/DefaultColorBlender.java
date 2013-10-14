package io.github.christiangaertner.moebelplaner.graphics.blending;

import java.awt.Color;

/**
 *
 * @author Christian
 */
public class DefaultColorBlender implements IColorBlender {

    @Override
    public int normal(int a, int b, int o) {
        return b;
    }

    @Override
    public int average(int a, int b, int o) {
        Color c1 = new Color(a);
        Color c2 = new Color(b);
        return new Color(
                (c1.getRed() * c1.getAlpha() + c2.getRed() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getGreen() * c1.getAlpha() + c2.getGreen() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getBlue() * c1.getAlpha() + c2.getBlue() * c2.getAlpha()) / (c1.getAlpha() + c2.getAlpha()),
                (c1.getAlpha() + c2.getAlpha()) / 2).getRGB();
    }

    @Override
    public int add(int a, int b, int o) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b, int o) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b, int o) {
        return a * b;
    }

    @Override
    public int divide(int a, int b, int o) {
        return a / b;
    }

    @Override
    public int difference(int a, int b, int o) {
        return Math.abs(a - b);
    }

    @Override
    public int darkenonly(int a, int b, int o) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    @Override
    public int lightenonly(int a, int b, int o) {
        return darkenonly(b, a, o);
    }

    @Override
    public int screen(int a, int b, int o) {
        return (1 - (1 - a) * (1 - b));
    }

    @Override
    public int overlay(int a, int b, int o) {
        if (a < 0.5) {
            return (2 * a * b);
        } else {
            return (1 - 2 * (1 - a) * (1 - b));
        }
    }

    @Override
    public int hardlight(int a, int b, int o) {
        return overlay(b, a, o);
    }

    @Override
    public int softlight(int a, int b, int o) {
        if (b < 0.5) {
            return (2 * a * b + a * a * (1 - 2 * b));
        } else {
            return (int) (2 * a * (1 - b) + Math.sqrt(a) * (2 * b - 1));
        }
    }

    @Override
    public int colorburn(int a, int b, int o) {
        return (1 - (1 - a) / b);
    }
}
