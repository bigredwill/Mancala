/**
 * An individual pit.
 *
 * @author #ODOT
 */
public class Pit {

    private int player;
    private int marbles;
    private boolean endPit;

    /**
     * Constructs a pit with a given number of marbles
     * @param numberOfMarbles the number of marbles in the pit
     * @param player the player who has the pit
     * @param isEnd true if it is a mancala, otherwise false
     */
    public Pit(int numberOfMarbles, int player, boolean isEnd) {
        this.endPit = isEnd;
        this.player = player;
        this.marbles = numberOfMarbles;
    }

    /**
     * Copies all aspects of a pit to this pit
     * @param other the other pit
     */
    public Pit(Pit other) {
        copyPit(other);
    }
    
    /**
     * copies another pit's player owner, number of marbles and isEnd characteristic
     * @param other the other pit
     */
    public void copyPit(Pit other) {
        this.player = other.player;
        this.marbles = other.marbles;
        this.endPit = other.endPit;
    }

    /**
     * Returns true if the pit is a mancala, else false
     * @return true if the pit is a mancala, else false
     */
    public boolean isEnd() {

        return endPit;
    }

    /*
     * Sets a pit to be an end pit or not
     * @param isEnd true if it is an end pit, else false
     */
    public void setEnd(boolean isEnd) {
        this.endPit = isEnd;
    }

    /**
     * Gets the player that has this pit
     * @return the player number
     */
    public int getPlayer() {
        return this.player;
    }

    /**
     * Sets the player who has this pit
     * @param player the player who has this pit
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    /**
     * Gets the number of marbles in this pit
     * @return the number of marbles in this pit
     */
    public int getMarbles() {
        return this.marbles;
    }

    /**
     * Set the number of marbles in the pit.
     *
     * @param numberOfMarbles the number of marbles in the pit to be set
     */
    public void setMarbles(int numberOfMarbles) {
        this.marbles = numberOfMarbles;
    }

    /**
     * Adds one marble to the pit.
     */
    public void addMarble() {
        this.marbles++;
        System.out.println("adding marble " + getMarbles());
    }

    /**
     * The overriden toString function to see characteristics of the pit
     * @return a String that contains information about the pit.
     */
    @Override
    public String toString() {
        return "Pit{" + "player=" + player + ", marbles=" + marbles + ", isEnd=" + endPit + '}';
    }
}
