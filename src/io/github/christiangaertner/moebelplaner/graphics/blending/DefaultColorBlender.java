package io.github.christiangaertner.moebelplaner.graphics.blending;

/**
 *
 * @author Christian
 */
public class DefaultColorBlender implements IColorBlender {

    @Override
    public int normal(int a, int b) {
        return b;
    }

    @Override
    public int average(int a, int b) {
        return ((a + b) / 2);
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
        return a * b;
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
        return (1 - (1 - a) * (1 - b));
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
        return (1 - (1 - a) / b);
    }
}
