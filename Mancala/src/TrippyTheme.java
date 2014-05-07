/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Avi
 */
public class TrippyTheme implements BoardTheme{
    /**
     * Loads the Marble
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        return "/Images/marb2.png";
    }

    @Override
    public String getEndPitFile() {
//        return "/Images/endPit2.png";
        return "/Images/tripEnd.gif";
    }

    @Override
    public String getPitFile() {
//        return "/Images/pit2.png";
        return "/Images/tripPit.gif";
    }
    
    
}
