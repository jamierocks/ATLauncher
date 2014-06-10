package com.atlauncher.gui.tabs;

import com.atlauncher.App;
import com.atlauncher.gui.components.LocalizedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public final class SettingsTab extends JPanel {
    private final List<SaveListener> saveListeners = new LinkedList<SaveListener>();

    private final JTabbedPane TABS = new JTabbedPane(JTabbedPane.TOP);
    private final JPanel SAVE_PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JButton SAVE_BUTTON = new LocalizedButton("common.save"){{
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(needsRelaunch()){

                }
            }
        });
    }};

    public SettingsTab(){
        super(new BorderLayout());

        this.TABS.setBackground(App.THEME.getTabBackgroundColor());
        this.TABS.setFont(App.THEME.getDefaultFont().deriveFont(17.0F));
        this.TABS.setOpaque(true);
        this.add(this.TABS, BorderLayout.CENTER);
        this.add(this.SAVE_PANEL, BorderLayout.SOUTH);
    }

    private boolean needsRelaunch(){
        for(SaveListener listener : this.saveListeners){
            listener.validate();
            if(listener.needsRelaunch()){
                return true;
            }
        }

        return false;
    }

    public void addSaveListener(SaveListener listener){
        this.saveListeners.add(listener);
    }

    public static interface SaveListener{
        public void validate();
        public boolean needsRelaunch();
    }
}