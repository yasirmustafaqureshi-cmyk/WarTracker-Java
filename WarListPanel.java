package wartracker.ui.panels;

import wartracker.data.WarRepository;
import wartracker.model.War;
import wartracker.ui.Theme;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class WarListPanel extends JPanel {

    public interface SelectionListener {
        void onWarSelected(War war);
    }

    private final DefaultListModel<War> listModel = new DefaultListModel<>();
    private final JList<War> warList;
    private JTextField searchField;
    private JComboBox<String> statusFilter;
    private JComboBox<String> categoryFilter;
    private SelectionListener listener;
    private List<War> currentWars;

    public WarListPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BG_DARK);
        setPreferredSize(new Dimension(310, 0));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.BORDER_MID));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Theme.BG_DARKEST);
        header.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)));
        JLabel title = new JLabel("CONFLICT DATABASE");
        title.setFont(Theme.FONT_SUBHEADER);
        title.setForeground(Theme.TEXT_ACCENT);
        header.add(title, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);

        // Filters
        JPanel filters = buildFilters();
        add(filters, BorderLayout.NORTH);

        // List
        warList = new JList<>(listModel);
        warList.setBackground(Theme.BG_DARK);
        warList.setForeground(Theme.TEXT_PRIMARY);
        warList.setSelectionBackground(Theme.BG_SELECTED);
        warList.setSelectionForeground(Theme.TEXT_PRIMARY);
        warList.setBorder(BorderFactory.createEmptyBorder());
        warList.setCellRenderer(new WarCellRenderer());
        warList.setFixedCellHeight(-1);
        warList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listener != null) {
                War w = warList.getSelectedValue();
                if (w != null) listener.onWarSelected(w);
            }
        });

        JScrollPane scroll = new JScrollPane(warList);
        scroll.setBackground(Theme.BG_DARK);
        scroll.getViewport().setBackground(Theme.BG_DARK);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().setBackground(Theme.BG_DARK);

        // Stack header + filters + list
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(Theme.BG_DARK);
        top.add(header, BorderLayout.NORTH);
        top.add(filters, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        loadWars(WarRepository.getAll());
    }

    private JPanel buildFilters() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 0, 0));
        panel.setBackground(Theme.BG_DARKEST);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        // Search
        searchField = new JTextField();
        searchField.setBackground(Theme.BG_CARD);
        searchField.setForeground(Theme.TEXT_PRIMARY);
        searchField.setCaretColor(Theme.TEXT_ACCENT);
        searchField.setFont(Theme.FONT_LABEL);
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Theme.BORDER_MID),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        searchField.putClientProperty("JTextField.placeholderText", "Search conflicts...");
        searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { applyFilters(); }
        });

        String[] statuses = {"All Status", "ACTIVE", "IMMINENT", "HISTORICAL", "CEASEFIRE"};
        statusFilter = styledCombo(statuses);
        statusFilter.addActionListener(e -> applyFilters());

        String[] cats = {"All Categories", "Religious", "Political", "Civil War", "World War",
                "Ethnic", "Colonial", "Independence", "Ideological", "Territorial", "Economic"};
        categoryFilter = styledCombo(cats);
        categoryFilter.addActionListener(e -> applyFilters());

        panel.add(searchField);
        panel.add(statusFilter);
        panel.add(categoryFilter);
        return panel;
    }

    private JComboBox<String> styledCombo(String[] items) {
        JComboBox<String> cb = new JComboBox<>(items);
        cb.setBackground(Theme.BG_CARD);
        cb.setForeground(Theme.TEXT_PRIMARY);
        cb.setFont(Theme.FONT_LABEL);
        cb.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
        return cb;
    }

    private void applyFilters() {
        String query = searchField.getText().trim();
        String status = (String) statusFilter.getSelectedItem();
        String cat = (String) categoryFilter.getSelectedItem();

        List<War> wars;
        if (!query.isEmpty()) {
            wars = WarRepository.search(query);
        } else {
            wars = WarRepository.getAll();
        }

        List<War> filtered = new ArrayList<>();
        for (War w : wars) {
            boolean statusOk = status.equals("All Status") || w.getStatus().getLabel().equals(status);
            boolean catOk = cat.equals("All Categories") || w.getCategory().getLabel().equals(cat);
            if (statusOk && catOk) filtered.add(w);
        }
        loadWars(filtered);
    }

    private void loadWars(List<War> wars) {
        currentWars = wars;
        listModel.clear();
        for (War w : wars) listModel.addElement(w);
    }

    public void setSelectionListener(SelectionListener l) {
        this.listener = l;
    }

    // ---- Cell renderer ----
    private static class WarCellRenderer extends JPanel implements ListCellRenderer<War> {
        private final JLabel nameLabel = new JLabel();
        private final JLabel durationLabel = new JLabel();
        private final JLabel statusBadge = new JLabel();
        private final JLabel regionLabel = new JLabel();
        private final JPanel statusBar = new JPanel();

        WarCellRenderer() {
            setLayout(new BorderLayout(0, 2));
            setOpaque(true);

            JPanel top = new JPanel(new BorderLayout(4, 0));
            top.setOpaque(false);

            statusBar.setPreferredSize(new Dimension(4, 0));
            statusBar.setOpaque(true);

            nameLabel.setFont(Theme.FONT_WAR_NAME);
            durationLabel.setFont(Theme.FONT_SMALL);
            durationLabel.setForeground(Theme.TEXT_SECONDARY);
            regionLabel.setFont(Theme.FONT_SMALL);
            regionLabel.setForeground(Theme.TEXT_MUTED);
            statusBadge.setFont(new Font("Courier New", Font.BOLD, 9));
            statusBadge.setOpaque(true);
            statusBadge.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

            JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 1));
            textPanel.setOpaque(false);
            textPanel.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));

            JPanel nameRow = new JPanel(new BorderLayout());
            nameRow.setOpaque(false);
            nameRow.add(nameLabel, BorderLayout.WEST);
            nameRow.add(statusBadge, BorderLayout.EAST);

            textPanel.add(nameRow);

            JPanel metaRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            metaRow.setOpaque(false);
            metaRow.add(durationLabel);
            JLabel sep = new JLabel("  |  ");
            sep.setFont(Theme.FONT_SMALL);
            sep.setForeground(Theme.TEXT_MUTED);
            metaRow.add(sep);
            metaRow.add(regionLabel);
            textPanel.add(metaRow);

            top.add(statusBar, BorderLayout.WEST);
            top.add(textPanel, BorderLayout.CENTER);

            add(top, BorderLayout.CENTER);
            setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_DARK),
                BorderFactory.createEmptyBorder(7, 8, 7, 8)));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends War> list,
                War war, int index, boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(war.getName());
            durationLabel.setText(war.getDuration());
            regionLabel.setText(war.getRegion());

            Color sc = Theme.getStatusColor(war.getStatus());
            statusBar.setBackground(sc);

            statusBadge.setText(war.getStatus().getLabel());
            statusBadge.setBackground(sc.darker().darker());
            statusBadge.setForeground(sc);

            nameLabel.setForeground(isSelected ? Theme.TEXT_PRIMARY : Theme.TEXT_PRIMARY);
            setBackground(isSelected ? Theme.BG_SELECTED : (index % 2 == 0 ? Theme.BG_DARK : Theme.BG_PANEL));
            return this;
        }
    }
}
