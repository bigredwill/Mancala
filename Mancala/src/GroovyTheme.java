public class GroovyTheme implements BoardTheme {
    /**
     * Loads the Marble
     * @return the path to the marble
     */
    @Override
    public String getMarbleFile() {
        return "/Images/marb3.png";
    }

    @Override
    public String getEndPitFile() {
        return "/Images/tripEnd.gif";
    }

    @Override
    public String getPitFile() {
        return "/Images/tripPit.gif";
    }
}