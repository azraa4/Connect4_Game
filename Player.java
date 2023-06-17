package src;

/**
 * An abstract class that represents a player in a Connect 4 game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public abstract class Player {

    /**
     * The color of the player's coins.
     */
    private CoinColor color;


    /**
     * Constructs a new Player object with the specified color and game board.
     *
     * @param color is the color of the player's coins.
     */
    public Player(CoinColor color, Board board, RulesOfConnect4Game rules){
        this.color = color;
    }

    /**
     * Returns the color of the player's coins.
     *
     * @return the color of the player's coins.
     */
    public CoinColor getColor(){
        return color;
    }


    /**
     * Represents the player's turn in the game.
     * to define their specific playing strategy.
     *
     * @return
     * @abstract This method must be implemented by subclasses.
     */
    public abstract void playing(Board board, RulesOfConnect4Game rules);

}
