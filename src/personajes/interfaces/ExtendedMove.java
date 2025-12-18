package personajes.interfaces;

import personajes.states.ManMood;

public interface ExtendedMove extends BaseMove{
    void think(String thought);
    void fastOpenCloseEyes();
    Boolean checkMood(ManMood mood);
}
