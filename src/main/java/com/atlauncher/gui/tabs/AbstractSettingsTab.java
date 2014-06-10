package com.atlauncher.gui.tabs;

import com.atlauncher.utils.Utils;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractSettingsTab extends JPanel {
    public static final Insets LABEL_INSETS = new Insets(5, 0, 5, 10);
    public static final Insets FIELD_INSETS = new Insets(5, 5, 5, 0);
    public static final Insets LABEL_S_INSETS = new Insets(0, 0, 0, 10);
    public static final Insets FIELD_S_INSETS = new Insets(0, 0, 0, 0);

    public static final ImageIcon HELP_ICON = Utils.getIconImage("/assets/image/Help.png");
    public static final ImageIcon RESTART_ICON = Utils.getIconImage("/assets/image/Exclamation.png");

    protected final GridBagConstraints gbc;

    protected AbstractSettingsTab(){
        super(new GridBagLayout());
        this.gbc = new GridBagConstraints();
    }
}