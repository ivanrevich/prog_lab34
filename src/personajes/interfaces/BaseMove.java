package personajes.interfaces;

import personajes.states.GoType;
import personajes.Man;
import things.Thing;

public interface BaseMove {
    void go(GoType goType);
    void see(Thing thing);
    void attack(Man man);
}
