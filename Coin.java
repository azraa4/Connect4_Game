package src;

/**
 * A class representing a coin in a game.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-05-08
 */
public class Coin {
    /**
     * The color of the coin.
     */
    private CoinColor color;
    /**
     * The row position of the coin.
     */
    private int row;
    /**
     * The column position of the coin.
     */
    private int column;

    /**
     * Constructs a new Coin object with the specified color, row, and column positions.
     *
     * @param color is the color of the coin.
     * @param row is the row position of the coin.
     * @param column is the column position of the coin.
     */
    public Coin(CoinColor color, int row, int column){
        this.color = color;
        this.row = row;
        this.column =column;
    }

    /**
     * Returns the color of the coin.
     *
     * @return The color of the coin.
     */
    public CoinColor getColor(){
        return color;
    }

    /**
     * Returns the row position of the coin.
     *
     * @return The row position of the coin.
     */
    public int getRow(){
        return row;
    }

    /**
     * Returns the column position of the coin.
     *
     * @return The column position of the coin.
     */
    public int getColumn(){
        return column;
    }


}
