/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avi
 */
public class WhiteTheme implements BoardTheme {
    /**
     * Loads the Marble
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        String mb = "/Images/marb1.png";
        return mb;
    }

    @Override
    public String getEndPitFile() {
        return "/Images/endPit2.png";
    }

    @Override
    public String getPitFile() {
        return "/Images/pit2.png";
    }
    
    
}
