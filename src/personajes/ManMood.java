package personajes;

import java.util.Random;

public enum ManMood {
    DREAM("спит"),
    WORK("работает"),
    ANGRY("злой"),
    FIGHT("напал"),
    HUNGRY("голодный");

    private final String title;
    ManMood(String s) {
        title=s;
    }

    private static final Random RANDOM = new Random();
    private static final ManMood[] MOODS = values();

    public static ManMood randomMood(){
        return MOODS[RANDOM.nextInt(MOODS.length)];
    }
    public static ManMood randomMood(ManJob job) {
        Random random = new Random();
        switch (job) {
            case KING:
                // Король редко злится или голоден; чаще "работает" (правит) или спокоен (спит редко)
                ManMood[] kingMoods = {WORK, DREAM, ANGRY}; // ANGRY — редко
                return kingMoods[random.nextInt(kingMoods.length)];
            case FARMER:
                // Фермер часто работает или голоден
                ManMood[] farmerMoods = {WORK, HUNGRY, DREAM, ANGRY};
                return farmerMoods[random.nextInt(farmerMoods.length)];
            case GUARDER:
                // Охранник — в бою или на страже; почти не спит
                ManMood[] guardMoods = {FIGHT, WORK, ANGRY};
                return guardMoods[random.nextInt(guardMoods.length)];
            default:
                return MOODS[RANDOM.nextInt(MOODS.length)];
        }
    }

    public Dialogue getDialogue() {
        return switch (this) {
            case DREAM -> (name, ctx) -> name + " бормочет во сне: \"ещё пять минуточек...\"";
            case HUNGRY -> (name, ctx) -> name + " жалобно: \"У тебя нет еды?\"";
            case ANGRY -> (name, ctx) -> name + " рявкает: \"Чего тебе?!\"";
            case FIGHT -> (name, ctx) -> name + " рычит: \"В бой!\"";
            case WORK -> (name, ctx) -> name + " отвлекся от работы: \"Привет, " + ctx + "\"";
        };
    }

    @Override
    public String toString() {
        return title;
    }
}
