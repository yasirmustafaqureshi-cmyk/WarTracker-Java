package wartracker.ui.panels;

import wartracker.model.War;
import wartracker.ui.Theme;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class WarDetailPanel extends JPanel {

    private final JLabel titleLabel = new JLabel("SELECT A CONFLICT");
    private final JLabel statusBadge = new JLabel();
    private final JLabel categoryBadge = new JLabel();
    private final JLabel durationLabel = new JLabel();
    private final JLabel regionLabel = new JLabel();
    private final JTextArea descArea = new JTextArea();
    private final JLabel casualtiesVal = new JLabel();
    private final JTextArea causeArea = new JTextArea();
    private final JTextArea outcomeArea = new JTextArea();
    private final JTextArea partiesArea = new JTextArea();
    private final JPanel contentPanel;

    public WarDetailPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BG_PANEL);

        // Top header bar
        JPanel header = buildHeader();
        add(header, BorderLayout.NORTH);

        // Scrollable content
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Theme.BG_PANEL);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));

        JScrollPane scroll = new JScrollPane(contentPanel);
        scroll.setBackground(Theme.BG_PANEL);
        scroll.getViewport().setBackground(Theme.BG_PANEL);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().setBackground(Theme.BG_DARK);
        add(scroll, BorderLayout.CENTER);

        buildContent();
        showPlaceholder();
    }

    private JPanel buildHeader() {
        JPanel h = new JPanel(new BorderLayout(10, 0));
        h.setBackground(Theme.BG_DARKEST);
        h.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(12, 20, 12, 20)));

        titleLabel.setFont(Theme.FONT_TITLE);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);

        JPanel badges = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        badges.setBackground(Theme.BG_DARKEST);

        statusBadge.setFont(new Font("Courier New", Font.BOLD, 11));
        statusBadge.setOpaque(true);
        statusBadge.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));

        categoryBadge.setFont(new Font("Courier New", Font.BOLD, 11));
        categoryBadge.setOpaque(true);
        categoryBadge.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
        categoryBadge.setBackground(new Color(0x1A3A5F));
        categoryBadge.setForeground(new Color(0x4AABDD));

        badges.add(categoryBadge);
        badges.add(statusBadge);

        h.add(titleLabel, BorderLayout.WEST);
        h.add(badges, BorderLayout.EAST);
        return h;
    }

    private void buildContent() {
        contentPanel.add(buildMetaRow());
        contentPanel.add(Box.createVerticalStrut(16));
        contentPanel.add(buildSection("DESCRIPTION", descArea, true));
        contentPanel.add(Box.createVerticalStrut(12));
        contentPanel.add(buildSection("PARTIES INVOLVED", partiesArea, false));
        contentPanel.add(Box.createVerticalStrut(12));
        contentPanel.add(buildCasualtiesRow());
        contentPanel.add(Box.createVerticalStrut(12));
        contentPanel.add(buildSection("ROOT CAUSES", causeArea, true));
        contentPanel.add(Box.createVerticalStrut(12));
        contentPanel.add(buildSection("OUTCOME / CURRENT STATUS", outcomeArea, true));
    }

    private JPanel buildMetaRow() {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        row.setBackground(Theme.BG_PANEL);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        durationLabel.setFont(Theme.FONT_MONO);
        durationLabel.setForeground(Theme.TEXT_ACCENT);
        regionLabel.setFont(Theme.FONT_MONO);
        regionLabel.setForeground(Theme.TEXT_SECONDARY);

        JLabel dIcon = makeIcon("⏱  DURATION: ");
        JLabel rIcon = makeIcon("◎  REGION: ");

        row.add(dIcon); row.add(durationLabel);
        JLabel sep = new JLabel("   |   ");
        sep.setForeground(Theme.TEXT_MUTED);
        sep.setFont(Theme.FONT_MONO);
        row.add(sep);
        row.add(rIcon); row.add(regionLabel);
        return row;
    }

    private JLabel makeIcon(String text) {
        JLabel l = new JLabel(text);
        l.setFont(Theme.FONT_LABEL);
        l.setForeground(Theme.TEXT_MUTED);
        return l;
    }

    private JPanel buildSection(String heading, JTextArea area, boolean wrap) {
        JPanel panel = new JPanel(new BorderLayout(0, 6));
        panel.setBackground(Theme.BG_CARD);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel.setAlignmentX(LEFT_ALIGNMENT);

        JLabel headLabel = new JLabel(heading);
        headLabel.setFont(Theme.FONT_SUBHEADER);
        headLabel.setForeground(Theme.TEXT_ACCENT);

        area.setBackground(Theme.BG_CARD);
        area.setForeground(Theme.TEXT_PRIMARY);
        area.setFont(Theme.FONT_BODY);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(wrap);
        area.setBorder(BorderFactory.createEmptyBorder());
        area.setOpaque(false);

        panel.add(headLabel, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildCasualtiesRow() {
        JPanel panel = new JPanel(new BorderLayout(0, 4));
        panel.setBackground(new Color(0x2A0A0A));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Theme.ACCENT_RED.darker()),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        panel.setAlignmentX(LEFT_ALIGNMENT);

        JLabel heading = new JLabel("ESTIMATED CASUALTIES");
        heading.setFont(Theme.FONT_SUBHEADER);
        heading.setForeground(Theme.ACCENT_RED);

        casualtiesVal.setFont(new Font("Courier New", Font.BOLD, 16));
        casualtiesVal.setForeground(new Color(0xFF6B6B));

        panel.add(heading, BorderLayout.NORTH);
        panel.add(casualtiesVal, BorderLayout.CENTER);
        return panel;
    }

    public void displayWar(War war) {
        titleLabel.setText(war.getName());

        Color sc = Theme.getStatusColor(war.getStatus());
        statusBadge.setText("● " + war.getStatus().getLabel());
        statusBadge.setBackground(sc.darker().darker());
        statusBadge.setForeground(sc);

        categoryBadge.setText(war.getCategory().getLabel().toUpperCase());

        durationLabel.setText(war.getDuration());
        regionLabel.setText(war.getRegion());
        descArea.setText(war.getDescription());

        StringBuilder partiesSB = new StringBuilder();
        for (String p : war.getParties()) partiesSB.append("• ").append(p).append("\n");
        partiesArea.setText(partiesSB.toString().trim());

        casualtiesVal.setText(war.getCasualties());
        causeArea.setText(war.getCause());
        outcomeArea.setText(war.getOutcome() != null ? war.getOutcome() : "Ongoing — no resolution reached.");

        contentPanel.revalidate();
        contentPanel.repaint();
        // Scroll to top
        SwingUtilities.invokeLater(() -> {
            Component scroll = contentPanel.getParent().getParent();
            if (scroll instanceof JScrollPane) {
                ((JScrollPane) scroll).getVerticalScrollBar().setValue(0);
            }
        });
    }

    private void showPlaceholder() {
        statusBadge.setText("");
        statusBadge.setBackground(Theme.BG_DARKEST);
        categoryBadge.setText("");
        durationLabel.setText("—");
        regionLabel.setText("—");
        descArea.setText("Select a conflict from the list to view full intelligence briefing.");
        partiesArea.setText("—");
        casualtiesVal.setText("—");
        causeArea.setText("—");
        outcomeArea.setText("—");
    }
}
