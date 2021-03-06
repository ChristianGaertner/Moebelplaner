package io.github.christiangaertner.moebelplaner.menu.debug.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 *
 * @author Christian
 */
public class RenderSettingsItem extends JMenuItem {
    
    private static JFrame previous;
    
    public RenderSettingsItem(final Moebelplaner planer, final Grid grid) {
        super("Render Settings");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (previous != null) {
                    previous.dispose();
                }
                
                JFrame window = new JFrame();
                window.setTitle("Render Settings");
                window.add(new RenderSettingsWindow(planer, grid));
                window.pack();
                window.setLocationRelativeTo(planer);
                window.setVisible(true);
                
                previous = window;
                
                
            }
        });
    }
}
