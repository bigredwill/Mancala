public class GroovyTheme implements BoardTheme {

    @Override
    public String getMarbleFile() {
        String mb = "/Images/marb3.png";
        return mb;
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