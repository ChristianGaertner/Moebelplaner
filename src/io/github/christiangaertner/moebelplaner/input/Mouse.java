package io.github.christiangaertner.moebelplaner.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Christian
 */
public class Mouse implements MouseListener, MouseMotionListener {

    /**
     * Mouse Koordianten
     */
    protected int x, y;
    /**
     * Die vorherige Mouse Position
     */
    protected int preX, preY;
    /**
     * Positiv bei einem Klick (ein Update lang). -1: Kein 1: Links 2: Mittlerer 3: Rechts
     */
    protected int buttonClick = -1;
    /**
     * Positiv solange wie ein Button gedrückt ist. -1: Kein 1: Links 2: Mittlerer 3: Rechts
     */
    protected int buttonHold = -1;

    /**
     * Updated den MouseListener. Wird gebraucht, um einfache Klicks zu erfassen
     */
    public void update() {
        buttonClick = -1;
    }

    /**
     * Links KLICK
     *
     * @return
     */
    public boolean leftClick() {
        return (click() == 1);
    }

    /**
     * Gibt zurück welche Taste geklickt ist
     *
     * @return
     */
    public int click() {
        return buttonClick;
    }

    /**
     * Gibt zurück ob die linke MausTaste gedrückt ist
     *
     * @return
     */
    public boolean leftHold() {
        return (hold() == 1);
    }

    /**
     * Gibt zurück welche Taste gedrückt ist
     *
     * @return
     */
    public int hold() {
        return buttonHold;
    }

    /**
     * X-Koordinate
     *
     * @return
     */
    public int x() {
        return x;
    }

    /**
     * Y-Koordinate
     *
     * @return
     */
    public int y() {
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        buttonHold = me.getButton();
        buttonClick = me.getButton();
        preX = x - me.getX();
        preY = y - me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        buttonHold = -1;
        buttonClick = -1;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }
}
