import java.util.Scanner;
public class TicTacToe {
    private final int BOARDSIZE = 3;
    //made the enum private as per the instructions
    private enum Status {
        WIN,
        DRAW,
        CONTINUE
    }
    private char board[][] = new char[BOARDSIZE][BOARDSIZE] ;
    private boolean firstPlayer = true; //uninitialized booleans default to false, which makes player O go first
    private boolean gameOver;
    public void play() {
        Scanner input = new Scanner(System.in);
        while(!gameOver) {
            //display the board
            printBoard();
            //determine whose turn it is and output to console
            if(firstPlayer) {
                printStatus(1);
            } else {
                printStatus(2);
            }
            //prompts user for move
            int row;
            int column;
            boolean moveIsValid;
            do {
                System.out.print("Please enter the row (0, 1, or 2): ");
                row = input.nextInt();
                System.out.print("Please enter the column (0, 1, or 2): ");
                column = input.nextInt();
                moveIsValid = validMove(row, column);
                if (!moveIsValid) {
                    System.out.println("Sorry, not a valid move. Here is the board again:");
                    printBoard();
                }
            } while (!moveIsValid);
            //if we're here the move is valid, so make the player's mark
            if(firstPlayer) {
                board[row][column] = 'X';
            } else {
                board[row][column] = 'O';
            }
            //see if there's a winner
            Status statusOfGame = gameStatus();
            if(statusOfGame == Status.WIN) {
                if(firstPlayer) {
                    System.out.println("Player X wins!");
                } else {
                    System.out.println("Player O wins!");
                }
                gameOver = true;
                printBoard();
            } else if (statusOfGame == Status.DRAW) {
                System.out.println("The game is a draw!");
                gameOver = true;
                printBoard();
            } else {
                //switch whose turn it is
                firstPlayer = !firstPlayer;
            }
        }
    }

    private Status gameStatus(){
        //check rows for a win
        for (int row = 0; row < BOARDSIZE; row++) {
            if (
                    board[row][0] != '\u0000'
                            && board[row][0] == board[row][1]
                            && board[row][1] == board[row][2]
            ) {
                return Status.WIN;
            }
        }
        //checks columns for a win
        for (int column = 0; column < BOARDSIZE; column++ ) {
            if(
                    board[0][column] != '\u0000'
                    && board[0][column] == board[1][column]
                    && board[1][column] == board[2][column]
            ) {
                return Status.WIN;
            }
        }
        //checks top left to bottom right diagonal for a win
        if(board[0][0] != '\u0000'
                && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            return Status.WIN;
        }
        //checks top right to bottom left diagonal for a win
        if(board[0][2] != '\u0000'
                && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return Status.WIN;
        }
        //checks for empty spaces left to claim
        for(int row = 0; row < BOARDSIZE; row++) {
            for(int column = 0; column < BOARDSIZE; column++) {
                if(board[row][column] == '\u0000') {
                    return Status.CONTINUE;
                }
            }
        }
        //if no wins and no continues
       return Status.DRAW;
    }
    private boolean validMove(int row, int column) {
        if(row >=0 && row < BOARDSIZE && column >= 0 && column < BOARDSIZE) {
            if (board[row][column] == '\u0000') {
                return true;
            }
        }
        return false;
    }
    private void printStatus(int player) {
        if(player == 1) {
            System.out.println("It is player X's turn.");
        } else {
            System.out.println("It is player O's turn.");
        }
    }
    public void printBoard() {
        for (int row = 0; row < BOARDSIZE; row++) {
            for (int column = 0; column < BOARDSIZE; column++) {
                printSymbol(column, board[row][column]);
            }
            System.out.println();   // finished this row
            if (row < BOARDSIZE - 1) {
                System.out.println("---+---+---");
            }
        }
    }
    private void printSymbol(int column, char value) {
        System.out.print(" " + value + " ");

        if (column < BOARDSIZE - 1) {
            System.out.print("|");
        }
    }

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
    public static void main(String[] args) {

        TicTacToe newGame = new TicTacToe();
        newGame.play();
    }
}
