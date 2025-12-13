package exceptions;

public class ThingInvisibleException extends RuntimeException {
    public ThingInvisibleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Невозможно рассмотреть объект, так как он исчез!";
    }
}
