package io.github.christiangaertner.moebelplaner.menu.edit.items;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Christian
 */
public class SelectAll extends JMenuItem {

    public SelectAll(Moebelplaner planer, final Grid grid) {
        super("Select All");
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));


        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.focus();
            }
        });
    }
}
