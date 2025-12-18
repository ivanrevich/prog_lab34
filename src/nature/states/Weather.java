package nature.states;

public enum Weather {
    SUNNY("ясно"),
    RAINY("дождливо"),
    CLOUDY("пасмурно");

    private final String description;
    Weather(String desc) { this.description = desc; }
    @Override public String toString() { return description; }

    public static Weather random() {
        return values()[new java.util.Random().nextInt(values().length)];
    }
}
