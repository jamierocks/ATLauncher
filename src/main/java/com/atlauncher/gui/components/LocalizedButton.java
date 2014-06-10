package com.atlauncher.gui.components;

import com.atlauncher.App;

import javax.swing.*;

public class LocalizedButton extends JButton {
    private final String tag;

    public LocalizedButton(String tag){
        super(App.settings.getLocalizedString(tag));
        this.tag = tag;
    }

    @Override
    public void setText(String text){
        super.setText(App.settings.getLocalizedString(text));
    }

    public void relocalize(){
        this.setText(this.tag);
    }
}