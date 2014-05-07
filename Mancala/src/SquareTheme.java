
/**
 *
 * @author #ODOT
 */
public class SquareTheme implements BoardTheme {

    /**
     * Loads the Marble
     *
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        return "/Images/marb2.png";
    }

    /**
     * Loads the end pit
     *
     * @return the path to the end pit
     */
    @Override
    public String getEndPitFile() {
        return "/Images/endPit1.png";
    }

    /**
     * Loads the regular pits
     *
     * @return the path to the regular pit
     */
    @Override
    public String getPitFile() {
        return "/Images/pit1.png";
    }
}
