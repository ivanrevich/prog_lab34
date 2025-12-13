package personajes;

public enum GoType {
    RUN("бежит"),
    COME_IN("вошёл"),
    GO_NEXT("пошёл дальше");

    String name;

    GoType(String s) {
        name = s;
    }
}
