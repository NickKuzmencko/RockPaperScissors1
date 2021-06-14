package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner;
    private Map<Integer, Figure> map;

    public GameLogic() {
        this.scanner = new Scanner(System.in);
        this.map = insertFigures(map);
    }

    private Map<Integer, Figure> insertFigures(Map<Integer, Figure> map) {
        map = new HashMap<>();
        map.put(1, Figure.P);
        map.put(2, Figure.R);
        map.put(3, Figure.S);
        return map;
    }

    public Figure getUserInput() throws GameInputException {

        String input = scanner.next();
        if (validateInput(input)) {
            return Figure.valueOf(input);
        }

        throw new GameInputException("Invalid input: " + input);

    }

    public Figure generatePCInput() {
        Random random = new Random();
        int index = random.nextInt(3-1+1)+1;
        return map.get(index);

    }

    public boolean validateInput(String input) {
        Figure figure = null;
        try {
            figure = Figure.instanceOf(input);

        } catch (GameFigureException e) {
            System.out.println("There is invalid input: " + input + " exception: " + e.getMessage());

        }
        return figure != null;
    }

    public void start() {
        System.out.println("Select ROCK(R), PAPER(P) ,SCISSORS(S)");

        Figure userFigure=null;
        Figure pcFigure=null;

        try {
            userFigure = getUserInput();

        } catch (GameInputException e) {
            System.out.println(e.getMessage());
            start();
        }
        display("User",userFigure);

        pcFigure = generatePCInput();
        display("PC",pcFigure);
        checkWinner(userFigure,pcFigure);
        start();
    }

    private void checkWinner(Figure userFigure, Figure pcFigure)  {
        int check=selection(userFigure.getIndex(),pcFigure.getIndex());
        switch (check) {
            case 0:
                System.out.println("Tie");
                break;
            case 1:
                System.out.println(userFigure.getFullName() + " Beats " + pcFigure.getFullName() + " You won ");
                break;
            case -1:
                System.out.println(pcFigure.getFullName() + " Beats " + userFigure.getFullName() + " You lost ");
                break;
        }

    }
    public int selection (int userSelection, int computerSelection) {
        if (userSelection == computerSelection) return 0;
        switch (userSelection) {
            case 1:
                return (computerSelection == Figure.S.getIndex() ? 1 : -1);
            case 2:
                return (computerSelection == Figure.R.getIndex() ? 1 : -1);
            case 3:
                return (computerSelection == Figure.P.getIndex() ? 1 : -1);
        }
        return 0;
    }

    public void display(String who ,Figure figure){
        System.out.println(who+" selected "+figure.getFullName());
    }
}
