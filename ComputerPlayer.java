package src;

/**
 * A class that represents a computer player in a Connect 4 game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class ComputerPlayer extends Player{

    private Board board;

    private RulesOfConnect4Game rules;

    /**
     * Constructs a new ComputerPlayer object with the specified player name, color, and game board.
     *
     * @param color is the color of the player's coins.
     */
    public ComputerPlayer(CoinColor color , Board board , RulesOfConnect4Game rules){
        super(color, board, rules);
        color = CoinColor.Yellow;
    }

    /**
     * Represents the computer player's turn in the game
     * using the Minimax algorithm.
     *
     */
    public void playing(Board board, RulesOfConnect4Game rules) {
        TreeNode<Integer[][]> board2 = new TreeNode<>(new Integer[7][6]);
        TreeNode<Integer[][]> perfectChild = minimax(board2, 0, true);
        Integer[][] perfectPlaying = perfectChild.getData();
        Coin coin1 = new Coin(CoinColor.Yellow, board.getCurrentRowCount(perfectPlaying[0].length), perfectPlaying[0].length);
        if (board.isValidMove(coin1, perfectPlaying[0].length)) {
            board.placeCoin(coin1, perfectPlaying[0].length);
            if (rules.getWinner(board) == CoinColor.Yellow) {
                System.out.println("You have won.");
            }
        } else {
            System.out.println("Wrong column number.");
        }
    }


    /**
     * The Minimax algorithm evaluates all possible moves
     * using a game tree to determine the best move for the computer player.
     * The algorithm works by first creating a tree of all possible moves.
     * The algorithm then recursively evaluates the value of each node in the tree.
     *
     * @param board is the board that is represented by this node.
     * @param depth is the depth of the current node in the tree
     *
     * @return the best move for the current player
     */
    public static TreeNode<Integer[][]> minimax(TreeNode<Integer[][]> board, int depth, boolean maxPlayer) {
        if (depth == 0) {
            return board;
        }

        TreeNode<Integer[][]> bestMove = null;
        int bestValue = Integer.MIN_VALUE;

        for (TreeNode<Integer[][]> child : board.getChildren()) {
            if (child.getData()[0][0] == 0) {
                int value = minimax(child, depth - 1, !maxPlayer).getData()[0][0];

                if (maxPlayer && value > bestValue) {
                    bestMove = child;
                    bestValue = value;
                } else if (!maxPlayer && value < bestValue) {
                    bestMove = child;
                    bestValue = value;
                }
            }
        }

        return bestMove;
    }



}
