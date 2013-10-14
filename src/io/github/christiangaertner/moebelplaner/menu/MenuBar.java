package io.github.christiangaertner.moebelplaner.menu;

import io.github.christiangaertner.moebelplaner.menu.debug.DebugMenu;
import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.menu.add.AddMenu;
import io.github.christiangaertner.moebelplaner.menu.edit.EditMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Christian
 */
public class MenuBar extends JMenuBar {

    public MenuBar(Moebelplaner m, Grid g) {
        add(new EditMenu(m, g));
        add(new AddMenu(m, g));

        if (m.debug()) {
            add(new DebugMenu(m, g));
        }
    }
}
