/**
 *
 * @author #ODOT
 */
public class BlackTheme implements BoardTheme {

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
        return "/Images/endPit1.png";
    }

    @Override
    public String getPitFile() {
//        return "/Images/pit2.png";
        return "/Images/pit1.png";
    }
    
    
}
