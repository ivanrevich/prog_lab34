package personajes.states;

import personajes.Man;
import personajes.interfaces.Dialogue;

import java.util.Random;

public enum ManMood {
    WOKE_UP("проснулся"),
    IDLE("ничего не делает"),
    DREAM("спит"),
    WORK("работает"),
    ANGRY("злиться"),
    FIGHT("напал"),
    HUNGRY("голодный"),
    SAD("грустит");

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
                ManMood[] kingMoods = {DREAM, DREAM, ANGRY, IDLE, SAD};
                return kingMoods[random.nextInt(kingMoods.length)];
            case FARMER:
                ManMood[] farmerMoods = {WORK, HUNGRY, DREAM, SAD};
                return farmerMoods[random.nextInt(farmerMoods.length)];
            case GUARDER:
                ManMood[] guardMoods = {FIGHT, FIGHT, WORK, ANGRY, ANGRY, SAD};
                return guardMoods[random.nextInt(guardMoods.length)];
            case null, default:
                return MOODS[RANDOM.nextInt(MOODS.length)];
        }
    }
    public static ManMood moodFromContact(Man man) {
        Random random = new Random();
        if(random.nextInt(10)<2){
            return man.getMood();
        }
        return randomMood();
    }



    public Dialogue getDialogue() {
        return switch (this) {
            case IDLE -> (name, ctx) -> name+" спросил: \"Чего ты хочешь?\"";
            case DREAM -> (name, ctx) -> name + " бормочет во сне: \"ещё пять минуточек...\"";
            case HUNGRY -> (name, ctx) -> name + " жалобно: \"У тебя нет еды?\"";
            case ANGRY -> (name, ctx) -> name + " рявкает: \"Чего тебе?!\"";
            case FIGHT -> (name, ctx) -> name + " рычит: \"В бой!\"";
            case WORK -> (name, ctx) -> name + " отвлекся от работы: \"Привет, " + ctx + "\"";
            case SAD -> (name, ctx) -> name + " грустный и разочарованный";
            case WOKE_UP -> (name, ctx)-> name+" проснулся";
        };
    }

    @Override
    public String toString() {
        return title;
    }
}
