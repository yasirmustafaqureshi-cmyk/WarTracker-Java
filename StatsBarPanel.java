package wartracker.ui.panels;

import wartracker.data.WarRepository;
import wartracker.model.War;
import wartracker.ui.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatsBarPanel extends JPanel {

    public StatsBarPanel() {
        setBackground(Theme.BG_DARKEST);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_MID));
        setLayout(new FlowLayout(FlowLayout.LEFT, 30, 8));
        refresh();
    }

    public void refresh() {
        removeAll();
        List<War> all = WarRepository.getAll();
        long active   = all.stream().filter(w -> w.getStatus() == War.Status.ACTIVE).count();
        long imminent = all.stream().filter(w -> w.getStatus() == War.Status.IMMINENT).count();
        long hist     = all.stream().filter(w -> w.getStatus() == War.Status.HISTORICAL).count();

        addStat("● ACTIVE", (int)active,   Theme.STATUS_ACTIVE);
        addStat("◆ IMMINENT", (int)imminent, Theme.STATUS_IMMINENT);
        addStat("◇ HISTORICAL", (int)hist,    Theme.STATUS_HISTORICAL);
        addStat("TOTAL CONFLICTS", all.size(), Theme.TEXT_ACCENT);

        revalidate();
        repaint();
    }

    private void addStat(String label, int value, Color color) {
        JPanel chip = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        chip.setBackground(Theme.BG_DARKEST);

        JLabel lbl = new JLabel(label + "  ");
        lbl.setFont(Theme.FONT_SMALL);
        lbl.setForeground(color);

        JLabel val = new JLabel(String.valueOf(value));
        val.setFont(new Font("Courier New", Font.BOLD, 13));
        val.setForeground(Theme.TEXT_PRIMARY);

        chip.add(lbl);
        chip.add(val);
        add(chip);
    }
}
