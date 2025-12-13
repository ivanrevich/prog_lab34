package World;

import exceptions.ThingInvisibleException;
import nature.NatureObject;
import nature.Sea;
import nature.Sky;
import personajes.GoType;
import personajes.MainHero;
import personajes.ManMood;
import personajes.Personage;
import things.Thing;
import things.buildings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class World {
    private MainHero hero;
    private Personage[] personages;
    private Sky sky;
    private Sea sea;
    private Castle castle;

    private final ArrayList<Thing> AllThings = new ArrayList<Thing>();

    private TimeOfDay timeOfDay = TimeOfDay.random();

    public void updateTime() {
        timeOfDay = TimeOfDay.values()[(timeOfDay.ordinal() + 1) % TimeOfDay.values().length];
        System.out.println("Наступило " + timeOfDay);
    }

    public World() {
        WorldGenerating();
    }

    private void WorldGenerating() {
        castle = new Castle();
        sea = new Sea();
        sky = new Sky();


        //// GENERATING MAIN HERO
        hero = new MainHero("Нильс");

        //// GENERATING PERSONAGES
        int countOfPersonages = 1 + (int) (Math.random() * 5);
        personages = new Personage[countOfPersonages];
        for (int i = 0; i < countOfPersonages; i++) {
            personages[i] = new Personage();
        }
        //// ADD IT TO WORLD OBJECTS
        AllThings.add(castle);
        AllThings.add(sea);
        AllThings.add(sky);

        AllThings.addAll(Arrays.asList(castle.getAllConstructions()));
    }

    public void PlayStory() {
        WorldContext context = new WorldContext(
                sky.getWeather(),
                timeOfDay,
                castle.getStateCastle()
        );

        Random random = new Random();
        while (hero.seenThings.size() != AllThings.size() || hero.seenPersons.size() != personages.length) {
            Personage pers = personages[random.nextInt(0, personages.length)];
            Thing th = AllThings.get(random.nextInt(0, AllThings.size()));

            if (!hero.seenThings.contains(th)) {
                if (random.nextBoolean() && th instanceof NatureObject) th.changeVisibleState();
                if (hero.getMood() != ManMood.DREAM) {
                    try {
                        hero.see(th);
                    } catch (ThingInvisibleException e) {
                        System.out.println(e.getMessage());
                    }
                    if (random.nextBoolean() && th instanceof Door) {
                        ((Door) th).getDoorState();
                        ((Door) th).tryToOpen();
                        if (((Door) th).isOpen()) {
                            hero.go(GoType.COME_IN);
                        }
                    }
                    if (random.nextInt(0, 10) == 5) {
                        hero.think("Может, я все-таки сплю?");
                        hero.fastOpenCloseEyes();
                        if (hero.checkMood(ManMood.DREAM)) {
                            hero.think("Похоже на сон");
                        } else {
                            hero.think("Да, нет вроде не сплю");
                        }
                        try {
                            hero.see(th);
                        } catch (ThingInvisibleException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    hero.go(GoType.GO_NEXT);
                } else {
                    if (!timeOfDay.isNight() || random.nextBoolean()) {
                        hero.setMood(ManMood.WOKE_UP);
                        hero.setMood(ManMood.HUNGRY);
                    }
                }
            }

            if (!hero.seenPersons.contains(pers)) {
                pers.contact(hero, context);

                hero.seenPersons.add(pers);
            }

            if (random.nextInt(100) <= 5) {
                sky.changeWeather();
                updateTime();
                context = new WorldContext(sky.getWeather(), timeOfDay, castle.getStateCastle());
            }
        }
    }
}
