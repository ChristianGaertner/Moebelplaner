package io.github.christiangaertner.moebelplaner.menu.debug.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author Christian
 */
public class ToogleHudItem extends JMenuItem {

    public ToogleHudItem(final Moebelplaner planer, final Grid grid) {
        super("Toogle HUD");
        
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                planer.toogleHud();
                
            }
        });
    }
}
