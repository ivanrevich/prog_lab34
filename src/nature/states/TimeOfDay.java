package nature.states;

public enum TimeOfDay {
    MORNING("утро"),
    DAY("день"),
    EVENING("вечер"),
    NIGHT("ночь");

    private final String name;
    TimeOfDay(String name) { this.name = name; }
    @Override public String toString() { return name; }

    public static TimeOfDay random() {
        return values()[new java.util.Random().nextInt(values().length)];
    }

    public boolean isNight() { return this == NIGHT; }
    public boolean isMorning() { return this == MORNING; }
}