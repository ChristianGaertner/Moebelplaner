package io.github.christiangaertner.moebelplaner.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Christian
 */
public final class Mouse implements MouseListener, MouseMotionListener {

    /**
     * Mouse Koordianten
     */
    private int x, y;
    
    private int buttonClicked = -1;
    private int buttonHold = -1;
    
    /**
     * Gibt zurück welche Taste gerade gedrückt wurde
     * auf der Maus
     */ 
    public int click() {
        int r = buttonClicked;
        buttonClicked = -1;
        return r;
    }
    
    /**
     * Gibt zurück ob die linke MausTaste gedrückt ist
     * @return 
     */
    public boolean leftClick() {
        return (click() == 1);
    }
    
    public int hold() {
        return buttonHold;
    }
    
    
    /**
     * X-Koordinate
     * @return 
     */
    public int x() {
        return x;
    }
    
    /**
     * Y-Koordinate
     * @return 
     */
    public int y() {
        return y;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        buttonClicked = me.getButton();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        buttonHold = me.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        buttonHold = -1;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }
}
