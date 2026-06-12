package wartracker.ui;

import wartracker.model.War;
import wartracker.ui.panels.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

    private final WarListPanel listPanel = new WarListPanel();
    private final WarDetailPanel detailPanel = new WarDetailPanel();
    private final StatsBarPanel statsBar = new StatsBarPanel();
    private final JTabbedPane rightTabs = new JTabbedPane();

    public MainWindow() {
        setTitle("WAR TRACKER — Global Conflict Intelligence System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350, 820);
        setMinimumSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);

        applyLAF();
        buildUI();
        setVisible(true);
    }

    private void applyLAF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        UIManager.put("TabbedPane.background", Theme.BG_DARK);
        UIManager.put("TabbedPane.foreground", Theme.TEXT_SECONDARY);
        UIManager.put("TabbedPane.selected", Theme.BG_PANEL);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("ScrollBar.background", Theme.BG_DARK);
        UIManager.put("ScrollBar.thumb", Theme.BG_HOVER);
        UIManager.put("ScrollBar.track", Theme.BG_DARK);
    }

    private void buildUI() {
        setBackground(Theme.BG_DARKEST);
        getContentPane().setBackground(Theme.BG_DARKEST);

        // Title bar
        JPanel titleBar = buildTitleBar();

        // Stats
        statsBar.setPreferredSize(new Dimension(0, 38));

        // Right side tabs
        rightTabs.setBackground(Theme.BG_DARK);
        rightTabs.setForeground(Theme.TEXT_SECONDARY);

        styleTab();
        rightTabs.addTab("INTEL BRIEF", detailPanel);
        rightTabs.addTab("TIMELINE", buildTimelineTab());
        rightTabs.addTab("OVERVIEW", new OverviewPanel());

        // Main split
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, rightTabs);
        split.setDividerLocation(310);
        split.setDividerSize(2);
        split.setBackground(Theme.BORDER_MID);
        split.setContinuousLayout(true);
        split.setBorder(null);

        // Wire selection
        listPanel.setSelectionListener(war -> {
            detailPanel.displayWar(war);
            rightTabs.setSelectedIndex(0);
        });

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Theme.BG_DARKEST);
        content.add(statsBar, BorderLayout.NORTH);
        content.add(split, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titleBar, BorderLayout.NORTH);
        getContentPane().add(content, BorderLayout.CENTER);
        getContentPane().add(buildStatusBar(), BorderLayout.SOUTH);
    }

    private JPanel buildTitleBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(Theme.BG_DARKEST);
        bar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, Theme.ACCENT_RED.darker()),
            BorderFactory.createEmptyBorder(10, 18, 10, 18)));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        left.setBackground(Theme.BG_DARKEST);

        JLabel icon = new JLabel("⚔");
        icon.setFont(new Font("SansSerif", Font.PLAIN, 28));
        icon.setForeground(Theme.ACCENT_RED);

        JPanel textStack = new JPanel(new GridLayout(2, 1, 0, 0));
        textStack.setBackground(Theme.BG_DARKEST);

        JLabel title = new JLabel("WAR TRACKER");
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        title.setForeground(Theme.TEXT_PRIMARY);

        JLabel subtitle = new JLabel("Global Conflict Intelligence System  —  Historical • Active • Imminent");
        subtitle.setFont(Theme.FONT_SMALL);
        subtitle.setForeground(Theme.TEXT_MUTED);

        textStack.add(title);
        textStack.add(subtitle);

        left.add(icon);
        left.add(textStack);

        // Live indicator
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 6));
        right.setBackground(Theme.BG_DARKEST);

        JLabel live = new JLabel("● LIVE DATA");
        live.setFont(Theme.FONT_LABEL);
        live.setForeground(Theme.STATUS_ACTIVE);

        Timer blink = new Timer(800, null);
        blink.addActionListener(e -> {
            live.setForeground(live.getForeground().equals(Theme.STATUS_ACTIVE)
                ? Theme.BG_DARKEST : Theme.STATUS_ACTIVE);
        });
        blink.start();

        JLabel date = new JLabel("JUNE 2026");
        date.setFont(Theme.FONT_LABEL);
        date.setForeground(Theme.TEXT_MUTED);

        right.add(live);
        right.add(date);

        bar.add(left, BorderLayout.WEST);
        bar.add(right, BorderLayout.EAST);
        return bar;
    }

    private JScrollPane buildTimelineTab() {
        TimelinePanel tp = new TimelinePanel();
        JScrollPane scroll = new JScrollPane(tp);
        scroll.setBackground(Theme.BG_PANEL);
        scroll.getViewport().setBackground(Theme.BG_PANEL);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getHorizontalScrollBar().setBackground(Theme.BG_DARK);
        scroll.getVerticalScrollBar().setBackground(Theme.BG_DARK);
        return scroll;
    }

    private JPanel buildStatusBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 4));
        bar.setBackground(new Color(0x070A0D));
        bar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Theme.BORDER_DARK));

        addStatus(bar, "● ACTIVE CONFLICTS", Theme.STATUS_ACTIVE);
        addStatus(bar, "◆ IMMINENT THREATS", Theme.STATUS_IMMINENT);
        addStatus(bar, "◇ HISTORICAL RECORD", Theme.STATUS_HISTORICAL);
        addStatus(bar, " | Data sourced from open-source intelligence, UN reports, ACLED, SIPRI", Theme.TEXT_MUTED);

        return bar;
    }

    private void addStatus(JPanel bar, String text, Color color) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Courier New", Font.PLAIN, 9));
        l.setForeground(color);
        bar.add(l);
    }

    private void styleTab() {
        rightTabs.setFont(Theme.FONT_SUBHEADER);
        rightTabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
}
