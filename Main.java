package wartracker;

import wartracker.ui.MainWindow;
import wartracker.ui.Theme;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // System properties for sharper rendering
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // Global Swing defaults for dark theme
                UIManager.put("Panel.background", Theme.BG_PANEL);
                UIManager.put("Label.foreground", Theme.TEXT_PRIMARY);
                UIManager.put("TextField.background", Theme.BG_CARD);
                UIManager.put("TextField.foreground", Theme.TEXT_PRIMARY);
                UIManager.put("TextField.caretForeground", Theme.TEXT_ACCENT);
                UIManager.put("ComboBox.background", Theme.BG_CARD);
                UIManager.put("ComboBox.foreground", Theme.TEXT_PRIMARY);
                UIManager.put("List.background", Theme.BG_DARK);
                UIManager.put("List.foreground", Theme.TEXT_PRIMARY);
                UIManager.put("ScrollPane.background", Theme.BG_DARK);
                UIManager.put("Viewport.background", Theme.BG_DARK);
                UIManager.put("TabbedPane.background", Theme.BG_DARK);
                UIManager.put("TabbedPane.foreground", Theme.TEXT_SECONDARY);
                UIManager.put("TabbedPane.selected", Theme.BG_PANEL);
                UIManager.put("TabbedPane.selectHighlight", Theme.ACCENT_RED);
                UIManager.put("TextArea.background", Theme.BG_CARD);
                UIManager.put("TextArea.foreground", Theme.TEXT_PRIMARY);
                UIManager.put("SplitPane.background", Theme.BG_DARKEST);
                UIManager.put("SplitPaneDivider.background", Theme.BORDER_MID);

            } catch (Exception ignored) {}

            new MainWindow();
        });
    }
}
