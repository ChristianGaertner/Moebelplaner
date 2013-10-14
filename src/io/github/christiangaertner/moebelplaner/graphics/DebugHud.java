package io.github.christiangaertner.moebelplaner.graphics;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.input.Mouse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Christian
 */
public class DebugHud {

    private Sprite sprite;
    private int x, y;
    private Mouse mouse;
    private Grid grid;

    public DebugHud(Moebelplaner planer) {
        mouse = planer.getMouse();
        grid = planer.getGrid();
    }

    public void render(Graphics g) {
        int fontSize = 20;
        g.setColor(Color.RED);
        g.setFont(new Font("Verdana", 0, fontSize));

        g.drawString("DEBUG MODE", 0, fontSize);
        g.drawString("Entities: " + grid.entityCount(), 0, fontSize * 2);
        g.drawString("Focused: " + grid.focusCount(), 0, fontSize * 3);
        g.drawString("Highlights: " + grid.highlightCount(), 0, fontSize * 4);

        g.drawString("Mouse: X: " + mouse.x() + "; Y: " + mouse.y() + "; preX: " + mouse.preX() + "; preY: " + mouse.preY(), 0, fontSize * 5);
        g.drawString("Drag: " + (mouse.x() - mouse.preX()) + " / " + (mouse.y() - mouse.preY()), 0, fontSize * 6);

        String display;

        switch (mouse.hold()) {
            case 1:
                display = "LEFT HOLD";
                break;
            case 2:
                display = "MIDDLE HOLD";
                break;
            case 3:
                display = "RIGHT HOLD";
                break;
            default:
                display = "OTHER BUTTON. ID: " + mouse.hold();
        }

        if (mouse.hold() != -1) {
            g.drawString(display, 0, fontSize * 7);
        }
    }
}
