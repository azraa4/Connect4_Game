package src;

/**
 * A class that represents the game board for the Connect 4 game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class Board {

    /**
     * The 2D array of coins that represents the game board.
     */
    private Coin[][] board;


    /**
     * The number of rows on the game board.
     */
    private int row;

    /**
     * The number of columns on the game board.
     */
    private int column;

    /**
     * The rules of the Connect 4 game.
     */
    private RulesOfConnect4Game rules;

    /**
     * Constructs a new Board object with the specified rules.
     *
     * @param rules is the rules of the Connect 4 game.
     */
    public Board(RulesOfConnect4Game rules){
        this.rules = rules;
        this.column = 7;
        this.row = 6;
        this.board = new Coin[row][column];
        for(int a = 0; a < row; a++){
            for(int b = 0; b < column; b++){
                board[a][b] = null;
            }
        }
    }

    /**
     * Returns the number of rows on the game board.
     *
     * @return the number of rows
     */
    public int getRow(){
        return this.row;
    }

    /**
     * Returns the number of columns on the game board.
     *
     * @return the number of columns
     */
    public int getColumn(){
        return this.column;
    }

    /**
     * Returns the coin at the specified row and column.
     *
     * @param row is the row of the coin.
     * @param col is the column of the coin.
     * @return the coin at the specified row and column, or null if the square is empty.
     */
    public Coin getCoin(int row, int col){
        return board[row][col];
    }

    /**
     * Returns the current count of non-empty squares.
     *
     * @param column is the specific column.
     * @return the current count of non-empty squares in the column.
     */
    public int getCurrentRowCount(int column) {
        int noEmpty = 0;
        for (int i = 0; i < getRow(); i++) {
            if (board[i][column] != null) {
                noEmpty++;
            }
        }
        return noEmpty;
    }


    /**
     * Sets the coin at the specified row and column.
     *
     * @param row is the row of the coin.
     * @param col is the column of the coin.
     * @param coin is the coin to set.
     */
    public void setCoin(int row, int col, Coin coin) {
        board[row][col]=coin;
    }

    /**
     * Checks if a drop is valid in the specified column.
     *
     * @param coin is the coin to be placed on the board.
     * @param column is the column to check.
     * @return true if the column is valid, false otherwise.
     */
    public boolean isValidMove(Coin coin, int column){
        boolean moving = false;
        if(column >= 0 && column < this.column){
            if (board[getCurrentRowCount(column)][column] == null) {
                moving = true;
                }
        }
        return moving;
    }

    /**
     * Places a coin on the board at the specified row and column.
     *
     * @param coin is the coin to be placed on the board.
     * @param col the column to place the coin in.
     */
    public void placeCoin(Coin coin, int col){
        if(isValidMove(coin, col) && !isBoardFull()) {
            board[coin.getRow()][col] = coin;
        }
        else {
            System.out.println("Please choose another place.");
        }
    }


    /**
     * Checks if the game board is full.
     *
     * @return true if the game board is full, false otherwise.
     */
    public boolean isBoardFull(){
        for(int i =0; i < this.row; i++){
            for(int j =0 ; j < this.column; j++){
                if(board[i][j] == null){
                 return false;
                }
            }
        }
        return true;

    }

}
