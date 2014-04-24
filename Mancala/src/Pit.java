/**
 * An individual pit.
 * @author Avi, Will, Michael
 */
public class Pit {
    
    private int marbles;
    /**
     * Constructs a pit with specified number of marbles.
     * @param someMarbles 
     */
    public Pit(int someMarbles)
    {
        this.marbles = someMarbles;
    }
    
    /**
     * Get the number of models in the pit.
     * @return 
     */
    public int getMarbles()
    {
        return this.marbles;
    }
    
    /**
     * Set the number of marbles in the pit.
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
