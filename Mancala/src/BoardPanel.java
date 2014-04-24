
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Just a trial run, just a rough draft.
 *
 * @author Casa
 */
public class BoardPanel extends JPanel implements MouseListener
{

    Model model;
    ArrayList<Ellipse2D.Double> pits;

    public BoardPanel(Model aModel)
    {

        this.model = aModel;
        this.addMouseListener(this);
        pits = new ArrayList<>();
        repaint();
        
    }

    /**
     * iterates through pits in the model,
     *
     * @param g2
     */
    private void drawPits(Graphics2D g2)
    {
        pits.removeAll(pits);
        int column = 10;
        int row = 10;
        int count = 0;
        for (Pit p : model.getBoard())
        {
            g2.draw(p.getPit());
            drawMarbles(p, g2);
//            Ellipse2D.Double pit;
//            if (p.isIsEnd()) //if it's an end pit
//            {
//                pit = new Ellipse2D.Double(row, column, 50, 150);
//                drawMarbles(p, g2, row, column, 50, 150);
//            } else
//            { //if it's a regular pit
//                pit = new Ellipse2D.Double(row, column, 50, 50);
//                drawMarbles(p, g2, row, column, 50, 50);
//            }
//            pits.add(pit);
//            //draw the pit
//            //marbles are being drawn before the pit, might need to change when stylized
//            g2.draw(pit);
//            row += 100;
//            count++;
//            if (count == 8) //end of row, both end pits have been drawn
//            {
//                column += 100;
//                row = 110; //start after first endpit
//            }
        }


    }

    /**
     * This can be refined to make the marbles look sexy. Using Ellipses as a
     * place holder. Draws the marbles in the pit
     *
     * @param p
     * @param g2
     * @param row
     * @param column
     * @param width
     * @param height
     */
    public void drawMarbles(Pit p, Graphics2D g2)
    {
        for (int i = 0; i < p.getMarbles(); i++)
        {
            Ellipse2D.Double pit = new Ellipse2D.Double(p.getPit().getX() + i * 10, p.getPit().getY(), 10, 10);
            g2.draw(pit);
        }

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawPits(g2);
    }
    
    
    /**
     * Updates the model
     *
     * @param aModel
     */
    public void updateModel(Model aModel)
    {
        this.model = aModel;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getPoint());
       for(Pit p : model.getBoard())
       {
           
           if(!p.isIsEnd() && p.getPit().contains(e.getPoint()))
           {
               p.addMarble();
               System.out.println("clicked");
           }
       }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
      
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    
    }

}
