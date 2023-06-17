package src;

/**
 * A class that represents a game of Connect 4.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class Game {

    /**
     * The main method of the Game class. This method starts the game.
     * @param args is the command line arguments.
     */
    public static void main(String[] args){
        RulesOfConnect4Game rules1 = new RulesOfConnect4Game();
        Board board1 = new Board(rules1);
        HumanPlayer humanPlayer = new HumanPlayer(CoinColor.Red, board1, rules1);
        ComputerPlayer computerPlayer = new ComputerPlayer(CoinColor.Yellow, board1, rules1);
        System.out.println("Welcome to the Connect 4 Game");
        System.out.println("Human Player is the first movement");
        while (!rules1.isGameOver(board1) && rules1.getWinner(board1) ==null){
            humanPlayer.playing(board1, rules1);
            computerPlayer.playing(board1, rules1);
        }
        System.out.println("The game is over");
    }


}
