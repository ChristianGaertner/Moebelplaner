package io.github.christiangaertner.moebelplaner;

import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.moebel.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Christian
 */
public class MenuBar {

    public static JMenuBar getMenuBar(Grid g) {

        final Grid grid = g;

        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("Edit");
        JMenu addMenu = new JMenu("Add");

        menuBar.add(editMenu);
        menuBar.add(addMenu);

        JMenuItem edit_SelectAll = new JMenuItem("Select All");
        edit_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        edit_SelectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.focus();
            }
        });


        JMenuItem edit_Delete = new JMenuItem("Delete");
        edit_Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));
        edit_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.deleteFocused();
            }
        });

        editMenu.add(edit_SelectAll);
        editMenu.add(edit_Delete);



        JMenuItem add_MoebelMenu = new JMenu("Furniture");

        JMenuItem add_MoebelMenu_Bett = new JMenuItem("Bed");
        add_MoebelMenu_Bett.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Bett());
            }
        });

        JMenuItem add_MoebelMenu_Badewanne = new JMenuItem("Bathtub");
        add_MoebelMenu_Badewanne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Badewanne());
            }
        });
        
        JMenuItem add_MoebelMenu_Toilette = new JMenuItem("Toilet");
        add_MoebelMenu_Toilette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Toilette());
            }
        });
        
        JMenuItem add_MoebelMenu_Sink = new JMenuItem("Sink");
        add_MoebelMenu_Sink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Waschbecken());
            }
        });

        add_MoebelMenu.add(add_MoebelMenu_Bett);
        add_MoebelMenu.add(add_MoebelMenu_Badewanne);
        add_MoebelMenu.add(add_MoebelMenu_Toilette);
        add_MoebelMenu.add(add_MoebelMenu_Sink);

        addMenu.add(add_MoebelMenu);

        return menuBar;
    }
}
