
public class GroovyTheme implements BoardTheme {

    /**
     * Loads the Marble
     *
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        return "/Images/marb3.png";
    }

    /**
     * Loads the end pit
     *
     * @return the path to the end pit
     */
    @Override
    public String getEndPitFile() {
        return "/Images/tripEnd.gif";
    }

    /**
     * Loads the regular pits
     *
     * @return the path to the regular pit
     */
    @Override
    public String getPitFile() {
        return "/Images/tripPit.gif";
    }
}