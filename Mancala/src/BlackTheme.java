/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avi
 */
public class BlackTheme implements BoardTheme {

    @Override
    public String getMarbleFile() {
        String mb = "/Images/marb2.png";
        return mb;
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
