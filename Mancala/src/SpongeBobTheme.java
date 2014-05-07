/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avi
 */
public class SpongeBobTheme implements BoardTheme {

    /**
     * Loads the Marble
     *
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        return "/Images/marb4.png";
    }

    /**
     * Loads the end pit
     *
     * @return the path to the end pit
     */
    @Override
    public String getEndPitFile() {
        return "/Images/endPitSpongebob.gif";
    }

    /**
     * Loads the regular pits
     *
     * @return the path to the regular pit
     */
    @Override
    public String getPitFile() {
        return "/Images/pitSpongebob.gif";
    }
}
