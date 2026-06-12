package wartracker.ui.panels;

import wartracker.data.WarRepository;
import wartracker.model.War;
import wartracker.ui.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.List;

public class TimelinePanel extends JPanel {

    private static final int ROW_H = 26;
    private static final int LEFT_MARGIN = 200;
    private static final int RIGHT_MARGIN = 30;
    private static final int YEAR_MIN = 600;
    private static final int YEAR_MAX = 2030;

    private List<War> wars;

    public TimelinePanel() {
        wars = WarRepository.getAll();
        setBackground(Theme.BG_PANEL);
        setPreferredSize(new Dimension(900, computeHeight()));
    }

    private int computeHeight() {
        return wars.size() * ROW_H + 80;
    }

    private int yearToX(int year, int width) {
        double range = YEAR_MAX - YEAR_MIN;
        double frac = (year - YEAR_MIN) / range;
        return LEFT_MARGIN + (int)(frac * (width - LEFT_MARGIN - RIGHT_MARGIN));
    }

    private int parseYear(String s) {
        if (s == null) return 2026;
        s = s.trim().replace(" BC", "").replace("BC", "");
        try {
            int v = Integer.parseInt(s);
            return s.contains("BC") ? -v : v;
        } catch (NumberFormatException e) {
            return 2026;
        }
    }

    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Background
        g.setColor(Theme.BG_PANEL);
        g.fillRect(0, 0, w, h);

        // Header
        g.setColor(Theme.TEXT_ACCENT);
        g.setFont(Theme.FONT_SUBHEADER);
        g.drawString("CONFLICT TIMELINE", 10, 22);

        // Century gridlines
        g.setFont(new Font("Courier New", Font.PLAIN, 9));
        for (int year = 700; year <= 2026; year += 100) {
            int x = yearToX(year, w);
            g.setColor(Theme.BORDER_DARK);
            g.drawLine(x, 35, x, h - 10);
            g.setColor(Theme.TEXT_MUTED);
            g.drawString(year < 0 ? Math.abs(year) + "BC" : String.valueOf(year), x - 14, 44);
        }

        // Horizontal axis
        g.setColor(Theme.BORDER_MID);
        g.drawLine(LEFT_MARGIN, 50, w - RIGHT_MARGIN, 50);

        // War bars
        int y = 58;
        for (War war : wars) {
            int startY = parseYear(war.getStartYear());
            int endY = war.getEndYear() == null ? 2026 : parseYear(war.getEndYear());
            if (startY < 0) startY = YEAR_MIN; // clamp ancient wars

            int x1 = Math.max(LEFT_MARGIN, yearToX(Math.max(startY, YEAR_MIN), w));
            int x2 = Math.min(w - RIGHT_MARGIN, yearToX(endY, w));
            if (x2 < x1) x2 = x1 + 4;

            Color barColor = Theme.getStatusColor(war.getStatus());

            // Name label
            g.setFont(new Font("Courier New", Font.PLAIN, 9));
            g.setColor(Theme.TEXT_SECONDARY);
            String name = war.getName();
            if (name.length() > 28) name = name.substring(0, 26) + "..";
            g.drawString(name, 6, y + ROW_H / 2 + 4);

            // Bar
            int barH = 12;
            int barY = y + (ROW_H - barH) / 2;

            // Glow effect for active/imminent
            if (war.getStatus() == War.Status.ACTIVE || war.getStatus() == War.Status.IMMINENT) {
                g.setColor(new Color(barColor.getRed(), barColor.getGreen(), barColor.getBlue(), 30));
                g.fillRoundRect(x1 - 2, barY - 2, x2 - x1 + 4, barH + 4, 4, 4);
            }

            GradientPaint grad = new GradientPaint(x1, barY, barColor.brighter(),
                    x2, barY, barColor.darker());
            g.setPaint(grad);
            g.fillRoundRect(x1, barY, Math.max(x2 - x1, 3), barH, 3, 3);

            // Ongoing arrow
            if (war.getEndYear() == null) {
                g.setColor(barColor);
                int ax = x2 + 2;
                int[] px = {ax, ax + 6, ax};
                int[] py = {barY, barY + barH / 2, barY + barH};
                g.fillPolygon(px, py, 3);
            }

            y += ROW_H;
        }
    }
}
