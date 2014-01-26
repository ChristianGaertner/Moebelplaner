package io.github.christiangaertner.moebelplaner.menu.debug;

import io.github.christiangaertner.moebelplaner.Moebelplaner;
import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.menu.debug.items.RenderSettingsItem;
import javax.swing.JMenu;

/**
 *
 * @author Christian
 */
public class DebugMenu extends JMenu {

    public DebugMenu(Moebelplaner planer, Grid grid) {
        super("Debug");
        add(new RenderSettingsItem(planer, grid));
    }
}
