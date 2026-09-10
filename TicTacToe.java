public class TicTacToe {
    private final int BOARDSIZE = 3;
    enum Status {
        WIN,
        DRAW,
        CONTINUE
    }
    private char board[][] = new char[BOARDSIZE][BOARDSIZE] ;
    private boolean firstPlayer;
    private boolean gameOver;

}
