package World;

import nature.Weather;
import things.buildings.CastleState;

public record WorldContext(Weather weather, TimeOfDay time, CastleState castleState) { }