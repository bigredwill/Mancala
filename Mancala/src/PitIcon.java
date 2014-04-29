
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Casa
 */
public class PitIcon extends ImageIcon
{

    int width;
    int height;
    int numMarbs;
    boolean isEnd;
    String bg;
    String mb = "/Images/marble.png";

    public PitIcon(int numMarbs, String bg, boolean isEnd)
    {
        this.numMarbs = numMarbs;
        this.bg = bg;
        if (isEnd)
        {
            height = 200;
            width = 100;
        } else
        {
            height = 100;
            width = 100;
        }


    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        super.paintIcon(c, g, x, y);
        BufferedImage in = null;
        BufferedImage marb = null;
        try
        {
            in = ImageIO.read(this.getClass().getResource(bg));
            marb = ImageIO.read(this.getClass().getResource(mb));
        } catch (IOException ex)
        {
            Logger.getLogger(PitIcon.class.getName()).log(Level.SEVERE, "couldn't paint icon", ex);
        }

        g.drawImage(in, 0, 0, c);
        paintMarbles(marb, c, g);
    }

    public void paintMarbles(BufferedImage b, Component c, Graphics g)
    {
        int yPos = -20;
        int xPos = -30;
//        for(int i = 0; i < 1; i++)
//        {   
//            g.drawImage(b, xPos,yPos, c); 
//            xPos+=20;
//            if((i+1)%4 == 0) { yPos += 20; xPos = -30;}
//        }
        Random rand = new Random(System.currentTimeMillis() * 30);
        for (int i = 0; i < numMarbs; i++)
        {
            xPos = -20 + rand.nextInt(getIconWidth() / 2);
            yPos = -20 + rand.nextInt(getIconHeight() / 2);
            g.drawImage(b, xPos, yPos, c);
        }
    }
    public void setNumMarbs(int marbs)
    {
        this.numMarbs = marbs;
    }
    @Override
    public int getIconWidth()
    {
        return width;
    }

    @Override
    public int getIconHeight()
    {
        return height;
    }
}
