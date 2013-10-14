package io.github.christiangaertner.moebelplaner.menu;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import javax.swing.JMenuBar;

/**
 *
 * @author Christian
 */
public class MenuBar extends JMenuBar {

    public MenuBar(Moebelplaner m, Grid g) {
        add(new EditMenu());
        add(new AddMenu());

        if (m.DEBUG) {
            add(new DebugMenu());
        }
    }
}
