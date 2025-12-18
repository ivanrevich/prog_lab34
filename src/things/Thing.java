package things;

import things.states.ThingState;

public abstract class Thing {
    public final String title;
    private ThingState state;

    protected Thing(String title) {
        this.title = title;
        state = ThingState.APPEARED;
    }

    public void changeVisibleState(){
        if(state==ThingState.APPEARED){
            misapprehended();
        }else if(state==ThingState.MISAPPREHENDED){
            appeared();
        }
    }

    public void appeared(){
        state = ThingState.APPEARED;
        System.out.println(title+" появилось");
    }
    public void misapprehended(){
        state = ThingState.MISAPPREHENDED;
        System.out.println(title+" исчезло");
    }

    public ThingState getState() {
        return state;
    }

    public void setState(ThingState state) {
        this.state = state;
    }
}
