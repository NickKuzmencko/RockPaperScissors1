package game;

public class GameFigureException extends Exception {
    private final String message;

    public GameFigureException(String message) {
        super(message);
        this.message = message;
    }
}
