
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * An individual pit.
 *
 * @author Avi, Will, Michael
 */
public class Pit
{

    private int player;
    private int marbles;
    private boolean isEnd;
    private Ellipse2D.Double pit;

    /**
     * Constructs a pit with specified number of marbles.
     *
     * @param someMarbles
     */
    public Pit(int someMarbles, int aPlayer, boolean isEnd, Ellipse2D.Double pit)
    {
        this.isEnd = isEnd;
        this.player = aPlayer;
        this.marbles = someMarbles;
        this.pit = pit;
    }

    /**
     * Get the pit Ellipse2D.Double
     *
     * @return
     */
    public Ellipse2D.Double getPit()
    {
        return pit;
    }

    /**
     * Set the pit Ellipse2D.Double
     *
     * @return
     */
    public void setPit(Ellipse2D.Double pit)
    {
        this.pit = pit;
    }

    /**
     * Gets if end pit
     *
     * @return
     */
    public boolean isIsEnd()
    {
        return isEnd;
    }

    /**
     * Sets if end pit
     *
     * @param isEnd
     */
    public void setIsEnd(boolean isEnd)
    {
        this.isEnd = isEnd;
    }

    /**
     * Gets the player number (1 or 2)
     *
     * @return
     */
    public int getPlayer()
    {
        return this.player;
    }

    public void setPlayer(int aPlayer)
    {
        this.player = aPlayer;
    }

    /**
     * Get the number of models in the pit.
     *
     * @return
     */
    public int getMarbles()
    {
        return this.marbles;
    }

    /**
     * Set the number of marbles in the pit.
     *
     * @param someMarbles
     */
    public void setMarbles(int someMarbles)
    {
        this.marbles = someMarbles;
    }

    /**
     * Adds one marble to the pit.
     */
    public void addMarble()
    {
        this.marbles++;
    }
}
