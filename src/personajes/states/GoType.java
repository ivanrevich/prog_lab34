package personajes.states;

public enum GoType {
    RUN("бежит"),
    COME_IN("вошёл"),
    GO_NEXT("пошёл дальше");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    GoType(String s) {
        name = s;
    }
}
