package com.atlauncher.gui.tabs;

import com.atlauncher.App;
import com.atlauncher.data.Pack;
import com.atlauncher.gui.NothingToDisplay;
import com.atlauncher.gui.PackDisplay;
import com.atlauncher.gui.components.LocalizedButton;
import com.atlauncher.gui.dialogs.AddPackDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public final class PacksTab extends JPanel {
    private final ControlPanel CONTROL_PANEL = new ControlPanel();
    private final JPanel CONTENT_PANEL = new JPanel(new GridBagLayout());
    private final JScrollPane SCROLLER = new JScrollPane(this.CONTENT_PANEL);

    public PacksTab(){
        super(new BorderLayout());
        reload();

        this.add(this.CONTROL_PANEL, BorderLayout.NORTH);
        this.add(this.SCROLLER, BorderLayout.CENTER);
    }

    public void reload(){
        this.CONTENT_PANEL.removeAll();
        this.load(true);
        SwingUtilities.updateComponentTreeUI(this.CONTENT_PANEL);
    }

    private void load(final boolean filter){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.BOTH;
                final int position = SCROLLER.getVerticalScrollBar().getValue();
                int count = 0;
                for(Pack p : getPacks()){
                    if(p.canInstall()){
                        if(filter){
                            boolean show = true;

                            if(CONTROL_PANEL.SEARCH_FIELD.getText() != null){
                                if(!Pattern.compile(Pattern.quote(CONTROL_PANEL.SEARCH_FIELD.getText()), Pattern.CASE_INSENSITIVE).matcher(p.getName()).find()){
                                    show = false;
                                }
                            }

                            if(CONTROL_PANEL.SERVERS_CHECK.isSelected()){
                                if(!p.canCreateServer()){
                                    show = false;
                                }
                            }

                            if(CONTROL_PANEL.PRIVATE_CHECK.isSelected()){
                                if(!p.isPrivate()){
                                    show = false;
                                }
                            }

                            if(show){
                                CONTENT_PANEL.add(new PackDisplay(p), gbc);
                                gbc.gridy++;
                                count++;
                            }
                        } else{
                            CONTENT_PANEL.add(new PackDisplay(p), gbc);
                            gbc.gridy++;
                            count++;
                        }
                    }
                }

                if(count == 0){
                    CONTENT_PANEL.add(new NothingToDisplay(App.settings.getLocalizedString("pack.nodisplay", "\n\n")), gbc);
                }

                SCROLLER.getVerticalScrollBar().setValue(position);
            }
        });
    }

    private List<Pack> getPacks(){
        return App.settings.sortPacksAlphabetically() ? App.settings.getPacksSortedAlphabetically() : App.settings.getPacksSortedPositionally();
    }

    private final class ControlPanel extends JPanel{
        private final JButton ADDPACK_BUTTON = new LocalizedButton("pack.addpack"){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddPackDialog();
                    PacksTab.this.reload();
                }
            });
        }};
        private final JButton CLEAR_BUTTON = new LocalizedButton("common.clear"){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SEARCH_FIELD.setText("");
                    SERVERS_CHECK.setSelected(false);
                    PRIVATE_CHECK.setSelected(false);
                    PacksTab.this.reload();
                }
            });
        }};
        private final JButton SEARCH_BUTTON = new LocalizedButton("common.search"){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PacksTab.this.reload();
                }
            });
        }};
        private final JTextField SEARCH_FIELD = new JTextField(16);
        private final JCheckBox SERVERS_CHECK = new JCheckBox(App.settings.getLocalizedString("pack.cancreateserver")){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PacksTab.this.reload();
                }
            });
        }};
        private final JCheckBox PRIVATE_CHECK = new JCheckBox(App.settings.getLocalizedString("pack.privatepacksonly")){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PacksTab.this.reload();
                }
            });
        }};

        public ControlPanel(){
            super(new FlowLayout(FlowLayout.LEFT));

            this.add(this.ADDPACK_BUTTON);
            this.add(this.CLEAR_BUTTON);
            this.add(this.SEARCH_FIELD);
            this.add(this.SEARCH_BUTTON);
            this.add(this.SERVERS_CHECK);
            this.add(this.PRIVATE_CHECK);
        }
    }
}