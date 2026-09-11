public class TicTacToe {
    private final int BOARDSIZE = 3;
    //made the enum private as per the instructions
    private enum Status {
        WIN,
        DRAW,
        CONTINUE
    }
    private char board[][] = new char[BOARDSIZE][BOARDSIZE] ;
    private boolean firstPlayer;
    private boolean gameOver;

    /* here's what I think the rest of the class construction should look like I think? 
    public void play() {
        all the really annoying stuff
    }
    private void printStatus(int player);
    private Status gameStatus() {
         if (check if someone won) {
            return Status.WIN;
        }

        if (check if board is full and no win ) {
            return Status.DRAW;
        }
    
        return Status.CONTINUE;
    };
    public void printBoard(){
        for (int i = 0; i < BOARDSIZE; i++){
            for (int j = 0; j < BOARDSIZE; j++){
            and then it probably uses printSymbol(i, board[i][j]) or smth like that 
            }
        }
    };
    private void printSymbol(int column, char value){
        GUYS IDK ON THIS ONE IM SORRY
    }; 
    private bool validMove(int row, int column){
        return board[i][j] ==NULL;
    };
    
    
    */

}
