package game;

public enum Figure {

    R("R", "Rock", 1), P("P", "Paper", 2), S("S", "Scissors", 3);

    private final String name;
    private final String fullName;
    private  final int index;
    Figure(String name, String fullName, int index) {
        this.name = name;
        this.fullName = fullName;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public int getIndex() {
        return index;
    }

    public static Figure instanceOf(String input) throws GameFigureException {
        if (Figure.S.name.equals(input)) {
            return S;
        }
        if (Figure.P.name.equals(input)) {
            return P;
        }
        if (Figure.R.name.equals(input)) {
            return R;
        }
        throw new GameFigureException("There is no figure like :" + input);

    }
}
