package wartracker.ui;

import java.awt.*;

public class Theme {
    // Core palette — tactical dark
    public static final Color BG_DARKEST   = new Color(0x0A0C0F);
    public static final Color BG_DARK      = new Color(0x11151A);
    public static final Color BG_PANEL     = new Color(0x161C24);
    public static final Color BG_CARD      = new Color(0x1C2330);
    public static final Color BG_HOVER     = new Color(0x232D3A);
    public static final Color BG_SELECTED  = new Color(0x1E3A5F);

    // Accent — tactical amber / red
    public static final Color ACCENT_RED    = new Color(0xCC2B2B);
    public static final Color ACCENT_AMBER  = new Color(0xE8A020);
    public static final Color ACCENT_ORANGE = new Color(0xD45F1A);
    public static final Color ACCENT_GREEN  = new Color(0x2A7A2A);
    public static final Color ACCENT_BLUE   = new Color(0x1A5FA0);

    // Status colors
    public static final Color STATUS_ACTIVE    = new Color(0xFF4444);
    public static final Color STATUS_IMMINENT  = new Color(0xFF8C00);
    public static final Color STATUS_CEASEFIRE = new Color(0xFFD700);
    public static final Color STATUS_HISTORICAL= new Color(0x607080);

    // Text
    public static final Color TEXT_PRIMARY   = new Color(0xECF0F4);
    public static final Color TEXT_SECONDARY = new Color(0x8A9BAD);
    public static final Color TEXT_MUTED     = new Color(0x4A5A6A);
    public static final Color TEXT_ACCENT    = new Color(0xE8A020);

    // Borders
    public static final Color BORDER_DARK    = new Color(0x1E2A38);
    public static final Color BORDER_MID     = new Color(0x2A3848);

    // Fonts — military stencil feel
    public static final Font  FONT_TITLE     = new Font("Courier New", Font.BOLD, 22);
    public static final Font  FONT_HEADER    = new Font("Courier New", Font.BOLD, 14);
    public static final Font  FONT_SUBHEADER = new Font("Courier New", Font.BOLD, 12);
    public static final Font  FONT_BODY      = new Font("SansSerif", Font.PLAIN, 12);
    public static final Font  FONT_LABEL     = new Font("Courier New", Font.PLAIN, 11);
    public static final Font  FONT_SMALL     = new Font("Courier New", Font.PLAIN, 10);
    public static final Font  FONT_WAR_NAME  = new Font("Courier New", Font.BOLD, 13);
    public static final Font  FONT_MONO      = new Font("Courier New", Font.PLAIN, 12);

    public static Color getStatusColor(wartracker.model.War.Status s) {
        switch (s) {
            case ACTIVE:    return STATUS_ACTIVE;
            case IMMINENT:  return STATUS_IMMINENT;
            case CEASEFIRE: return STATUS_CEASEFIRE;
            default:        return STATUS_HISTORICAL;
        }
    }
}
