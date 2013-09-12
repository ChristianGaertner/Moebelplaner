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
    
    private int button = -1;
    
    /**
     * Gibt zurück welche Taste gerade gedrückt wird
     * auf der Maus
     */ 
    public int clicked() {
        return button;
    }
    
    /**
     * Gibt zurück ob die linke MausTaste gedrückt ist
     * @return 
     */
    public boolean leftClick() {
        return (clicked() == 1);
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
    }

    @Override
    public void mousePressed(MouseEvent me) {
        button = me.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        button = -1;
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
