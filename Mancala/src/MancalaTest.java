

/**
 * CS151 Group Project. TEAM #ODOT.
 * 
 * Avi Dey
 * Will Ritter Simons
 * Michael Daniels
 * 
 * The main class for the MancalaTest Game.
 *
 * @author #ODOT
 */
public class MancalaTest
{
    /**
     * Opens and runs the game starting from the homeframe (initial screen)
     * @param args Command Line arguments.
     */
    public static void main(String args[])
    {
        HomeFrame home = new HomeFrame();
        home.setSize(1100, 340);
        home.setResizable(false);
        home.setVisible(true);
    }
}
