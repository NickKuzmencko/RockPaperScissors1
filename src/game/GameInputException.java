package game;

public class GameInputException extends Exception {
    private final String message;

    public GameInputException(String message) {
        super(message);
        this.message = message;
    }
}
