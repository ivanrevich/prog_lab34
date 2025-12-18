package things.buildings.states;

public enum CastleState {
    INTACT("целый"),
    DAMAGED("повреждённый"),
    RUINED("разрушенный"),
    GUARDED("под охраной");

    private final String desc;
    CastleState(String desc) { this.desc = desc; }
    @Override public String toString() { return desc; }
}