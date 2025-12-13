package personajes;

import things.Thing;

public interface ExtendedMove extends BaseMove{
    void think(String thought);
    void fastOpenCloseEyes();
    Boolean checkMood(ManMood mood);
}
