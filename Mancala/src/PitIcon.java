
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author #ODOT
 */
public class PitIcon extends ImageIcon {

    ArrayList<Point> points;
    int width;
    int height;
    int numMarbs;
    int oldNum;
    int randSeed;
    boolean isEnd;
    boolean firstPaint;
//    String mb = "/Images/marble.png";
    BoardTheme theme = null;
    //String mb = "/Images/greenMarb.png";

    /**
     * Constructs a pit with a num of marbles.
     *
     * @param numMarbs
     * @param bg
     * @param isEnd
     */
    public PitIcon(int numMarbs, boolean isEnd, BoardTheme theme) {
        points = new ArrayList<>();
        firstPaint = true;
        this.numMarbs = numMarbs;
        this.oldNum = 0;
        this.theme = theme;
        this.isEnd = isEnd;
        if (isEnd) {
            height = 225;
            width = 100;
        } else {
            height = 100;
            width = 100;
        }


    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        super.paintIcon(c, g, x, y);
        BufferedImage in = null;
        BufferedImage marb = null;
        try {
            if (isEnd) {
                in = ImageIO.read(this.getClass().getResource(theme.getEndPitFile()));
            } else {
                in = ImageIO.read(this.getClass().getResource(theme.getPitFile()));
            }
            marb = ImageIO.read(this.getClass().getResource(theme.getMarbleFile()));
        } catch (IOException ex) {
            Logger.getLogger(PitIcon.class.getName()).log(Level.SEVERE, "couldn't paint icon", ex);
        }
        
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(in, 0, 0, c);
        paintMarbles(marb, c, g);
    }

    /**
     * Helper function for paintIcon draws marbles.
     *
     * @param b
     * @param c
     * @param g
     */
    public void paintMarbles(BufferedImage b, Component c, Graphics g) {
        //If numMarbs has changed, or icon is being created
        if (oldNum != numMarbs || firstPaint) {
            points.removeAll(points);
            int yPos = -20;
            int xPos = -30;
            Random rand = new Random();
            for (int i = 0; i < numMarbs; i++) {
                xPos = -20 + rand.nextInt(getIconWidth() / 2);
                yPos = -20 + rand.nextInt(getIconHeight() / 2);
                points.add(new Point(xPos, yPos));
                g.drawImage(b, xPos, yPos, c);
            }
            firstPaint = false;
        } else //draw points in same position
        {
            for (Point p : points) {
                g.drawImage(b, p.x, p.y, c);
            }
        }
    }

    /**
     * Sets the number of marbles to draw.
     *
     * @param marbs
     */
    public void setNumMarbs(int marbs) {
        this.oldNum = this.numMarbs;
        this.numMarbs = marbs;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
