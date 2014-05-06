/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avi
 */
public class SpongeBobTheme implements BoardTheme {

    @Override
    public String getMarbleFile() {
        String mb = "/Images/marb1.png";
        return mb;
    }

    @Override
    public String getEndPitFile() {
        return "/Images/endPitSpongebob.gif";
    }

    @Override
    public String getPitFile() {
        return "/Images/pitSpongebob.gif";
    }
}
