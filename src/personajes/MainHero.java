package personajes;

import things.Thing;

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
    public void goTo(Thing thing) {
        System.out.println(super.getName() + " пришёл к "+thing.toString());
    }

    @Override
    public Boolean checkMood(ManMood mood) {
        return getMood()==mood;
    }

    @Override
    public void go() {
        System.out.println(super.getName() + " зашагал дальше");
    }

    @Override
    public void see(Thing thing) {
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
}
