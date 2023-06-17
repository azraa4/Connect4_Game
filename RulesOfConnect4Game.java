package src;

/**
 * A class that represents the rules of Connect 4.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class RulesOfConnect4Game {
    /**
     * The board that the game is played on.
     */
    private Board board;

    public RulesOfConnect4Game(){

    }

    /**
     * Determines the winner of the Connect 4 game.
     *
     * @param board is the game board for Connect 4.
     * @return the CoinColor of the winning player, or null if there is no winner yet.
     */
    public CoinColor getWinner(Board board){
        CoinColor winnerColor;

        //row
        for(int i=0; i<board.getRow(); i++){
            for(int j=0; j< board.getColumn(); j++) {
                if (i >= 0 && i < board.getRow() && j >= 0 && j < board.getColumn()) {
                    if (board.getCoin(i, j) != null) {
                        if (j + 1 < board.getColumn() && j + 2 < board.getColumn() && j + 3 < board.getColumn()) {
                            if (board.getCoin(i, j + 1) != null && board.getCoin(i, j + 2) != null &&
                                    board.getCoin(i, j + 3) != null) {
                                winnerColor = board.getCoin(i, j).getColor();
                                if (winnerColor == board.getCoin(i, j + 1).getColor() &&
                                        winnerColor == board.getCoin(i, j + 2).getColor() &&
                                        winnerColor == board.getCoin(i, j + 3).getColor()) {
                                    return winnerColor;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        //column
        for(int i=0; i<board.getRow(); i++){
            for(int j=0; j< board.getColumn(); j++){
                if (i >= 0 && i < board.getRow() && j >= 0 && j < board.getColumn()) {
                    if (board.getCoin(i, j) != null) {
                        if (i + 1 < board.getRow() && i + 2 < board.getRow() && i + 3 < board.getRow()) {
                            if (board.getCoin(i + 1, j) != null && board.getCoin(i + 2, j) != null &&
                                    board.getCoin(i + 3, j) != null) {
                                winnerColor = board.getCoin(i, j).getColor();
                                if (winnerColor == board.getCoin(i + 1, j).getColor() &&
                                        winnerColor == board.getCoin(i + 2, j).getColor() &&
                                        winnerColor == board.getCoin(i + 3, j).getColor()) {
                                    return winnerColor;
                                }
                            }
                        }
                    }
                }
            }
        }

        //diagonals
        for(int i=0; i<board.getRow(); i++){
            for(int j=0; j< board.getColumn(); j++) {
                if (i >= 0 && i < board.getRow() && j >= 0 && j < board.getColumn()) {
                    if (board.getCoin(i, j) != null) {
                        winnerColor = board.getCoin(i, j).getColor();
                        if (i + 1 < board.getRow() && i + 2 < board.getRow() && i + 3 < board.getRow()
                                && j + 1 < board.getColumn() && j + 2 < board.getColumn() && j + 3 < board.getColumn()) {
                            if (board.getCoin(i + 1, j + 1) != null && board.getCoin(i + 2, j + 2) != null &&
                                    board.getCoin(i + 3, j + 3) != null) {
                                if (winnerColor == board.getCoin(i + 1, j + 1).getColor() &&
                                        winnerColor == board.getCoin(i + 2, j + 2).getColor() &&
                                        winnerColor == board.getCoin(i + 3, j + 3).getColor()) {
                                    return winnerColor;
                                }
                            }
                        }
                    }
                }
            }
        }


        for(int i=0; i<board.getRow(); i++){
            for(int j=0; j< board.getColumn(); j++) {
                if (i >= 0 && i < board.getRow() && j >= 0 && j < board.getColumn()) {
                    if (board.getCoin(i, j) != null) {
                        winnerColor = board.getCoin(i, j).getColor();
                        if (i-1 >= 0 && i - 1 < board.getRow() && i-2 >= 0 && i - 2 < board.getRow() && i-3 >= 0 && i - 3 < board.getRow()
                                && j + 1 < board.getColumn() && j + 2 < board.getColumn() && j + 3 < board.getColumn()) {
                            if (board.getCoin(i - 1, j + 1) != null && board.getCoin(i - 2, j + 2) != null &&
                                    board.getCoin(i - 3, j + 3) != null) {
                                if (winnerColor == board.getCoin(i - 1, j + 1).getColor() &&
                                        winnerColor == board.getCoin(i - 2, j + 2).getColor() &&
                                        winnerColor == board.getCoin(i - 3, j + 3).getColor()) {
                                    return winnerColor;
                                }
                            }
                        }
                    }
                }
            }
        }


        return null;
    }

    /**
     * Checks if the Connect 4 game is over.
     *
     * @param board is the game board for Connect 4.
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver(Board board){
      return board.isBoardFull() || getWinner(board) != null;
    }

}
