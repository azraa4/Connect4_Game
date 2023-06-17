package src;
import java.util.*;

/**
 * A class that represents a human player in a Connect 4 game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class HumanPlayer extends Player {
    private Board board;

    private RulesOfConnect4Game rules;



    /**
     * Constructs a new HumanPlayer object with the specified color and game board.
     *
     * @param color is the color of the player's coins.
     * @param board is the game board
     * @param rules is the rules of the Connect4 game
     *
     */
    public HumanPlayer(CoinColor color, Board board, RulesOfConnect4Game rules){
        super(color,board, rules);
        color = CoinColor.Red;
        this.board = board;
        this.rules = rules;
    }

    /**
     * Represents the human player's turn in the game.
     * the user to enter a column number,
     * and then drops the player's coin into that column.
     *
     */
    @Override
    public void playing(Board board, RulesOfConnect4Game rules){
        int columnNo;
        Scanner connect4 = new Scanner(System.in);
        System.out.println("Please choose where you want to put the red coin");
        System.out.println("Column no = ");
        columnNo = connect4.nextInt();
        Coin coin1 = new Coin(CoinColor.Red, board.getCurrentRowCount(columnNo), columnNo);
        if(board.isValidMove(coin1, columnNo)) {
            board.placeCoin(coin1, columnNo);
            if (rules.getWinner(board) == CoinColor.Red) {
                System.out.println("You have won.");
            }
        }else{
            System.out.println("Wrong column no.");
        }
    }
}
