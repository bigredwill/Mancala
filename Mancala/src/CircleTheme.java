
/**
 *
 * @author #ODOT
 */
public class CircleTheme implements BoardTheme {

    /**
     * Loads the Marble
     *
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        String mb = "/Images/marb1.png";
        return mb;
    }

    /**
     * Loads the end pit
     *
     * @return the path to the end pit
     */
    @Override
    public String getEndPitFile() {
        return "/Images/endPit2.png";
    }

    /**
     * Loads the regular pits
     * @return the path to the regular pit
     */
    @Override
    public String getPitFile() {
        return "/Images/pit2.png";
    }
}
