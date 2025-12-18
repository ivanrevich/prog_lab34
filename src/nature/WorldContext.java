package nature;

import nature.states.TimeOfDay;
import nature.states.Weather;
import things.buildings.states.CastleState;

public record WorldContext(Weather weather, TimeOfDay time, CastleState castleState) { }