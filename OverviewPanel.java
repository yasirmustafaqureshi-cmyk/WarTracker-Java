package wartracker.ui.panels;

import wartracker.data.WarRepository;
import wartracker.model.War;
import wartracker.ui.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

public class OverviewPanel extends JPanel {

    public OverviewPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BG_PANEL);

        JLabel heading = new JLabel("  GLOBAL CONFLICT OVERVIEW");
        heading.setFont(Theme.FONT_HEADER);
        heading.setForeground(Theme.TEXT_ACCENT);
        heading.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(12, 10, 12, 10)));
        heading.setBackground(Theme.BG_DARKEST);
        heading.setOpaque(true);
        add(heading, BorderLayout.NORTH);

        JPanel charts = new JPanel(new GridLayout(1, 2, 20, 0));
        charts.setBackground(Theme.BG_PANEL);
        charts.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        charts.add(new PieChart("BY STATUS", buildStatusData()));
        charts.add(new PieChart("BY CATEGORY", buildCategoryData()));

        JScrollPane scroll = new JScrollPane(charts);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(Theme.BG_PANEL);
        add(scroll, BorderLayout.CENTER);

        // Summary table
        add(buildSummaryTable(), BorderLayout.SOUTH);
    }

    private Map<String, Integer> buildStatusData() {
        Map<String, Integer> m = new LinkedHashMap<>();
        List<War> all = WarRepository.getAll();
        for (War.Status s : War.Status.values()) {
            int c = (int) all.stream().filter(w -> w.getStatus() == s).count();
            if (c > 0) m.put(s.getLabel(), c);
        }
        return m;
    }

    private Map<String, Integer> buildCategoryData() {
        Map<String, Integer> m = new LinkedHashMap<>();
        List<War> all = WarRepository.getAll();
        for (War w : all) {
            m.merge(w.getCategory().getLabel(), 1, Integer::sum);
        }
        return m;
    }

    private JPanel buildSummaryTable() {
        List<War> all = WarRepository.getAll();
        long active = all.stream().filter(w -> w.getStatus() == War.Status.ACTIVE).count();
        long imminent = all.stream().filter(w -> w.getStatus() == War.Status.IMMINENT).count();
        long hist = all.stream().filter(w -> w.getStatus() == War.Status.HISTORICAL).count();
        long religious = all.stream().filter(w -> w.getCategory() == War.Category.RELIGIOUS).count();
        long political = all.stream().filter(w -> w.getCategory() == War.Category.POLITICAL).count();

        JPanel panel = new JPanel(new GridLayout(2, 5, 1, 1));
        panel.setBackground(Theme.BORDER_DARK);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        addStatCell(panel, "ACTIVE WARS", String.valueOf(active), Theme.STATUS_ACTIVE);
        addStatCell(panel, "IMMINENT THREATS", String.valueOf(imminent), Theme.STATUS_IMMINENT);
        addStatCell(panel, "HISTORICAL", String.valueOf(hist), Theme.STATUS_HISTORICAL);
        addStatCell(panel, "RELIGIOUS WARS", String.valueOf(religious), new Color(0xAA44AA));
        addStatCell(panel, "POLITICAL WARS", String.valueOf(political), Theme.ACCENT_BLUE);
        addStatCell(panel, "TOTAL CATALOGUED", String.valueOf(all.size()), Theme.TEXT_ACCENT);
        addStatCell(panel, "REGIONS AFFECTED", "15+", Theme.ACCENT_GREEN);
        addStatCell(panel, "NUCLEAR FLASHPOINTS", "3", Theme.STATUS_ACTIVE);
        addStatCell(panel, "CENTURIES COVERED", "14+", Theme.TEXT_SECONDARY);
        addStatCell(panel, "DATA AS OF", "2026", Theme.TEXT_MUTED);

        return panel;
    }

    private void addStatCell(JPanel panel, String label, String value, Color color) {
        JPanel cell = new JPanel(new BorderLayout(0, 4));
        cell.setBackground(Theme.BG_CARD);
        cell.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));

        JLabel v = new JLabel(value);
        v.setFont(new Font("Courier New", Font.BOLD, 22));
        v.setForeground(color);

        JLabel l = new JLabel(label);
        l.setFont(Theme.FONT_SMALL);
        l.setForeground(Theme.TEXT_SECONDARY);

        cell.add(v, BorderLayout.CENTER);
        cell.add(l, BorderLayout.SOUTH);
        panel.add(cell);
    }

    // ---- Pie chart component ----
    static class PieChart extends JPanel {
        private final String title;
        private final Map<String, Integer> data;
        private static final Color[] PALETTE = {
            new Color(0xFF4444), new Color(0xFF8C00), new Color(0xFFD700),
            new Color(0x2A9D8F), new Color(0x4AABDD), new Color(0xAA44AA),
            new Color(0x44AA44), new Color(0x6699CC), new Color(0xCC9966),
            new Color(0x99CCFF), new Color(0xFF99CC)
        };

        PieChart(String title, Map<String, Integer> data) {
            this.title = title;
            this.data = data;
            setBackground(Theme.BG_CARD);
            setPreferredSize(new Dimension(340, 300));
            setBorder(BorderFactory.createLineBorder(Theme.BORDER_MID));
        }

        @Override
        protected void paintComponent(Graphics g0) {
            super.paintComponent(g0);
            Graphics2D g = (Graphics2D) g0;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();

            g.setColor(Theme.TEXT_ACCENT);
            g.setFont(Theme.FONT_SUBHEADER);
            g.drawString(title, 14, 22);

            int total = data.values().stream().mapToInt(i -> i).sum();
            if (total == 0) return;

            int diameter = Math.min(w / 2 - 30, h - 80);
            int cx = 20 + diameter / 2;
            int cy = 30 + diameter / 2;

            double startAngle = 0;
            int ci = 0;
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(data.entrySet());

            for (Map.Entry<String, Integer> e : entries) {
                double sweep = 360.0 * e.getValue() / total;
                Color c = PALETTE[ci % PALETTE.length];
                g.setColor(c);
                g.fill(new Arc2D.Double(cx - diameter / 2.0, cy - diameter / 2.0,
                        diameter, diameter, startAngle, sweep, Arc2D.PIE));
                g.setColor(Theme.BG_CARD);
                g.setStroke(new BasicStroke(1.5f));
                g.draw(new Arc2D.Double(cx - diameter / 2.0, cy - diameter / 2.0,
                        diameter, diameter, startAngle, sweep, Arc2D.PIE));
                startAngle += sweep;
                ci++;
            }

            // Legend
            int lx = cx + diameter / 2 + 20;
            int ly = 40;
            ci = 0;
            g.setFont(new Font("Courier New", Font.PLAIN, 9));
            for (Map.Entry<String, Integer> e : entries) {
                Color c = PALETTE[ci % PALETTE.length];
                g.setColor(c);
                g.fillRect(lx, ly - 8, 10, 10);
                g.setColor(Theme.TEXT_PRIMARY);
                String pct = String.format("%s (%d)", e.getKey(), e.getValue());
                g.drawString(pct, lx + 14, ly);
                ly += 16;
                ci++;
            }
        }
    }
}
