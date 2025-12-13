package personajes;

import World.WorldContext;
import nature.Weather;
import things.Thing;
import things.buildings.CastleState;
import things.weapons.Helmet;
import things.weapons.Spear;

import java.util.Random;

public class Personage extends Man implements BaseMove{
    private ManJob manJob;
    private Helmet helmet;
    private Spear spear;

    public Personage(String name, ManJob manJob, ManMood mood) {
        super(name, mood);
        this.manJob = manJob;
        if(manJob==ManJob.GUARDER){
            helmet = new Helmet();
            spear = new Spear();
        }
    }


    public Personage() {
        Random random = new Random();
        String[] names = {"Ганс", "Чербурашка", "Мальвина", "Незнайка", "Аркадий", "Ибрагим", "Василий"};

        super(names[random.nextInt(0, names.length)]);
        this.manJob=ManJob.random();
        if(manJob==ManJob.GUARDER){
            helmet = new Helmet();
            spear = new Spear();
        }
        setMood(ManMood.randomMood(manJob));
    }

    public void contact(Man observer, WorldContext context) {
        System.out.println(observer.getName() + " увидел как " + getMood() + " " + manJob + " по имени " + getName());

        if (helmet != null) System.out.println("На нём был " + helmet);
        if (spear != null) System.out.println("В руках " + spear);

        Dialogue dialogue = getMood().getDialogue();
        String line = dialogue.speak(getName(), observer.getName());
        System.out.println(line);

        if (manJob == ManJob.GUARDER && getMood() == ManMood.FIGHT) {
            System.out.println(getName() + " кричит: \"Стой! Кто идёт?!\"");
            attack(observer);
            go(GoType.RUN);
            observer.go(GoType.RUN);
            observer.setMood(ManMood.SAD);
        }else{
            setMood(ManMood.moodFromContact(observer));
            observer.setMood(ManMood.moodFromContact(this));
        }
        updateMoodBasedOnWorld(context);
        observer.updateMoodBasedOnWorld(context);
    }

    @Override
    public void updateMoodBasedOnWorld(WorldContext ctx) {
        ManMood newMood = getMood();

        if (ctx.time().isNight()) {
            if (manJob != ManJob.GUARDER) {
                newMood = ManMood.DREAM;
            }
        } else if (ctx.time().isMorning()) {
            newMood = ManMood.HUNGRY;
        }

        if (ctx.weather() == Weather.RAINY) {
            if (manJob != ManJob.KING) {
                newMood = ManMood.ANGRY;
            }
        }
        if (ctx.castleState() == CastleState.GUARDED && manJob == ManJob.GUARDER) {
            newMood = ManMood.WORK;
        }

        System.out.println(getName() +" "+ newMood);
        setMood(newMood);
    }

    public ManJob getManJob() {
        return manJob;
    }

    public void setManJob(ManJob manJob) {
        this.manJob = manJob;
    }

    @Override
    public void go(GoType goType) {
        System.out.println(super.getName()+" "+goType.name);
    }

    @Override
    public void see(Thing thing) {
        System.out.println(super.getName()+" увидел");
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
