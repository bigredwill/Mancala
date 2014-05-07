
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * A class to aid in making a panel with a background image
 * @author #ODOT
 */
public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image = null;
    private int iWidth2;
    private int iHeight2;

    /**
     * The constructor that takes an image to be drawn
     * @param image the desired background image for the panel
     */
    public ImagePanel(Image image) {
        this.image = image;
        this.iWidth2 = image.getWidth(this) / 2;
        this.iHeight2 = image.getHeight(this) / 2;
    }

    /**
     * The method that paints the panel with the supplied image
     * @param g the graphics parameter
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = this.getParent().getWidth() / 2 - iWidth2;
            int y = this.getParent().getHeight() / 2 - iHeight2;
            g.drawImage(image, x, y, this);
        }
    }
}