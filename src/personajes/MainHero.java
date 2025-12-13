package personajes;

import World.WorldContext;
import exceptions.ThingInvisibleException;
import nature.Weather;
import things.Thing;
import things.ThingState;

import java.util.ArrayList;
public class MainHero extends Man implements ExtendedMove{
    public ArrayList<Thing> seenThings = new ArrayList<Thing>();

    public ArrayList<Personage> seenPersons = new ArrayList<Personage>();

    public MainHero(String name){
        super(name, ManMood.randomMood());
    }
    @Override
    public void think(String thought) {
        System.out.println("'"+thought+"' - подумал " + super.getName());
    }

    @Override
    public void fastOpenCloseEyes() {
        System.out.println(super.getName()+" крепко-накрепко зажмурил глаза и быстро открыл их");
    }

    @Override
    public Boolean checkMood(ManMood mood) {
        return getMood()==mood;
    }

    @Override
    public void go(GoType goType) {

        System.out.println(super.getName() + " "+goType.name);
    }

    @Override
    public void see(Thing thing) throws ThingInvisibleException {
        if (thing.getState() == ThingState.MISAPPREHENDED) {
            throw new ThingInvisibleException("Невозможно рассмотреть '" + thing.title + "' — он не видим!");
        }
        seenThings.add(thing);
        System.out.println(super.getName() + " посмотрел на " + thing.toString());
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void updateMoodBasedOnWorld(WorldContext ctx) {
        ManMood newMood = getMood();

        if (ctx.time().isNight()) {
            newMood = ManMood.DREAM;
        } else if (ctx.time().isMorning()) {
            newMood = ManMood.HUNGRY;
        }

        if (ctx.weather() == Weather.RAINY) {
            newMood = ManMood.SAD;
        }

        System.out.println(getName() +" "+ newMood);
        setMood(newMood);
    }
}
