package wartracker.model;

import java.util.List;

public class War {

    public enum Status {
        ACTIVE("ACTIVE", "#FF4444"),
        HISTORICAL("HISTORICAL", "#888888"),
        IMMINENT("IMMINENT", "#FF8C00"),
        CEASEFIRE("CEASEFIRE", "#FFD700");

        private final String label;
        private final String hexColor;

        Status(String label, String hexColor) {
            this.label = label;
            this.hexColor = hexColor;
        }

        public String getLabel() { return label; }
        public String getHexColor() { return hexColor; }
    }

    public enum Category {
        RELIGIOUS("Religious"),
        POLITICAL("Political"),
        TERRITORIAL("Territorial"),
        COLONIAL("Colonial"),
        CIVIL("Civil War"),
        WORLD("World War"),
        INDEPENDENCE("Independence"),
        ETHNIC("Ethnic"),
        ECONOMIC("Economic"),
        IDEOLOGICAL("Ideological");

        private final String label;

        Category(String label) { this.label = label; }
        public String getLabel() { return label; }
    }

    private final String id;
    private final String name;
    private final String startYear;
    private final String endYear;        // null = ongoing
    private final Status status;
    private final Category category;
    private final String region;
    private final List<String> parties;
    private final String description;
    private final String casualties;
    private final String cause;
    private final String outcome;        // null = ongoing

    public War(String id, String name, String startYear, String endYear,
               Status status, Category category, String region,
               List<String> parties, String description,
               String casualties, String cause, String outcome) {
        this.id = id;
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
        this.status = status;
        this.category = category;
        this.region = region;
        this.parties = parties;
        this.description = description;
        this.casualties = casualties;
        this.cause = cause;
        this.outcome = outcome;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getStartYear() { return startYear; }
    public String getEndYear() { return endYear; }
    public Status getStatus() { return status; }
    public Category getCategory() { return category; }
    public String getRegion() { return region; }
    public List<String> getParties() { return parties; }
    public String getDescription() { return description; }
    public String getCasualties() { return casualties; }
    public String getCause() { return cause; }
    public String getOutcome() { return outcome; }

    public String getDuration() {
        if (endYear == null) return startYear + " – Present";
        return startYear + " – " + endYear;
    }

    @Override
    public String toString() { return name; }
}
