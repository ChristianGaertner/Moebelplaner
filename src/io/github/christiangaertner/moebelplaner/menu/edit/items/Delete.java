package io.github.christiangaertner.moebelplaner.menu.edit.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Christian
 */
public class Delete extends JMenuItem {

    public Delete(Moebelplaner planer, final Grid grid) {
        super("Select All");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.deleteFocused();
            }
        });
    }
}
