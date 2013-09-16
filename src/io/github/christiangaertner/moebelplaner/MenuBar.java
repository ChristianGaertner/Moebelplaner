package io.github.christiangaertner.moebelplaner;

import io.github.christiangaertner.moebelplaner.grid.Grid;
import io.github.christiangaertner.moebelplaner.moebel.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Christian
 */
public class MenuBar {

    private final Grid grid;
    
    public MenuBar(Grid g) {
        grid = g;
    }
    
    public JMenuBar getMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        for(JMenu menu : getMenus()) {
            menuBar.add(menu);
        }



        

        return menuBar;
    }
    
    private List<JMenu> getMenus() {
        
        List<JMenu> menus = new ArrayList<JMenu>();
        
        
        JMenu edit = new JMenu("Edit");
        JMenu add = new JMenu("Add");
        
        for (JMenuItem i : getMenuItemsEdit()) {
            edit.add(i);
        }
        
        for (JMenuItem i : getMenuItemsAdd()) {
            add.add(i);
        }
        
        
        menus.add(edit);
        menus.add(add);   
        
        return menus;
    }
    
    private List<JMenuItem> getMenuItemsEdit() {
        List<JMenuItem> items = new ArrayList<JMenuItem>();
        
        
        
        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.focus();
            }
        });


        JMenuItem delete = new JMenuItem("Delete");
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.deleteFocused();
            }
        });
        
        items.add(delete);
        items.add(selectAll);

        return items;
    }
    
    private List<JMenuItem> getMenuItemsAdd() {
        List<JMenuItem> items = new ArrayList<JMenuItem>();

        JMenuItem MoebelMenu = new JMenu("Furniture");

        JMenuItem MoebelMenu_Bett = new JMenuItem("Bed");
        MoebelMenu_Bett.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Bett());
            }
        });

        JMenuItem MoebelMenu_Badewanne = new JMenuItem("Bathtub");
        MoebelMenu_Badewanne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Badewanne());
            }
        });
        
        JMenuItem MoebelMenu_Toilette = new JMenuItem("Toilet");
        MoebelMenu_Toilette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Toilette());
            }
        });
        
        JMenuItem MoebelMenu_Sink = new JMenuItem("Sink");
        MoebelMenu_Sink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Waschbecken());
            }
        });
        
        JMenuItem MoebelMenu_Desk = new JMenuItem("Desk");
        MoebelMenu_Desk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                grid.add(new Schreibtisch());
            }
        });
        
        MoebelMenu.add(MoebelMenu_Bett);
        MoebelMenu.add(MoebelMenu_Badewanne);
        MoebelMenu.add(MoebelMenu_Toilette);
        MoebelMenu.add(MoebelMenu_Sink);
        MoebelMenu.add(MoebelMenu_Desk);
        
        items.add(MoebelMenu);
        
        return items;
    }
}
