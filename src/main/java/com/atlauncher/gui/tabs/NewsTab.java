package com.atlauncher.gui.tabs;

import com.atlauncher.App;
import com.atlauncher.utils.Utils;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class NewsTab extends JPanel {
    private final ContextMenu CONTEXT_MENU = new ContextMenu();
    private final HTMLEditorKit NEWS_KIT = new HTMLEditorKit(){{
        this.setStyleSheet(Utils.createStyleSheet("news"));
    }};
    private final JEditorPane NEWS_PANE = new JEditorPane("text/html", null){{
        this.setEditable(false);
        this.setEditorKit(NEWS_KIT);
        this.setSelectionColor(App.THEME.getSelectionColor());
        this.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    Utils.openBrowser(e.getURL());
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(getSelectedText() != null){
                    if(e.getButton() == MouseEvent.BUTTON3){
                        CONTEXT_MENU.show(NEWS_PANE, e.getX(), e.getY());
                    }
                }
            }
        });
    }};

    public NewsTab(){
        super(new BorderLayout());
        this.add(new JScrollPane(this.NEWS_PANE, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        this.load();
    }

    public void load(){
        this.NEWS_PANE.setText(App.settings.getNewsHTML());
        this.NEWS_PANE.setCaretPosition(0);
    }

    public void setupLanguage(){
        this.CONTEXT_MENU.COPY_ITEM.setText(App.settings.getLocalizedString("common.copy"));
    }

    private final class ContextMenu extends JPopupMenu{
        private final JMenuItem COPY_ITEM = new JMenuItem("Copy"){{
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(NEWS_PANE.getSelectedText()), null);
                }
            });
        }};

        public ContextMenu(){
            super();
            this.add(this.COPY_ITEM);
        }
    }
}