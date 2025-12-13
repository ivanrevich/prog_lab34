package World;

import nature.Weather;
import things.buildings.CastleState;

public class WorldContext {
    private final Weather weather;
    private final TimeOfDay time;
    private final CastleState castleState;

    public WorldContext(Weather weather, TimeOfDay time, CastleState castleState) {
        this.weather = weather;
        this.time = time;
        this.castleState = castleState;
    }

    public Weather getWeather() {
        return weather;
    }

    public TimeOfDay getTime() {
        return time;
    }

    public CastleState getCastleState() {
        return castleState;
    }
}