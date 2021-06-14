package game;

public class GameRunner {
    public static void main (String[] args){
        run();
    }

    private static void run() {
        GameLogic gameLogic =new GameLogic();
        gameLogic.start();

    }
}
