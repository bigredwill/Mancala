
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * An individual pit.
 *
 * @author Avi, Will, Michael
 */
public class Pit {

    private int player;
    private int marbles;
    private boolean isEnd;

    /**
     * Constructs a pit with specified number of marbles.
     *
     * @param someMarbles
     *
     * @param someMarbles
     */
    public Pit(int someMarbles, int aPlayer, boolean isEnd) {
        this.isEnd = isEnd;
        this.player = aPlayer;
        this.marbles = someMarbles;
    }

    public Pit(Pit other) {
        copyPit(other);
    }
    
    public void copyPit(Pit other) {
        this.player = other.player;
        this.marbles = other.marbles;
        this.isEnd = other.isEnd;
    }

    /**
     * Gets if end pit
     *
     * @return
     *
     * @return
     */
    public boolean isIsEnd() {

        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * Gets the player number (1 or 2)
     *
     * @return
     *
     * @return
     */
    public int getPlayer() {
        return this.player;
    }

    public void setPlayer(int aPlayer) {
        this.player = aPlayer;
    }

    /**
     * Get the number of models in the pit.
     *
     * @return
     *
     * @return
     */
    public int getMarbles() {
        return this.marbles;
    }

    /**
     * Set the number of marbles in the pit.
     *
     * @param someMarbles
     *
     * @param someMarbles
     */
    public void setMarbles(int someMarbles) {
        this.marbles = someMarbles;
    }

    /**
     * Adds one marble to the pit.
     */
    public void addMarble() {
        this.marbles++;
        System.out.println("adding marble " + getMarbles());
    }

    @Override
    public String toString() {
        return "Pit{" + "player=" + player + ", marbles=" + marbles + ", isEnd=" + isEnd + '}';
    }
}
