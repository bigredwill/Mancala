import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Just a trial run, just a rough draft.
 * @author Casa
 *
 * @author Avi
 */
public class BoardPanel extends JPanel
{
    Model model;
    public BoardPanel(Model aModel)
    {
        this.model = aModel;
        repaint();
    }
    
    public void updateModel(Model aModel)
    {
        this.model = aModel;
    }
    /**
     * iterates through pits in the model, 
     * @param g2 
     */
    private void drawPits(Graphics2D g2)
    {
        int column = 10;
        int row = 10;
        int count = 0;
        for(Pit p : model.getBoard())
        {
            Ellipse2D.Double pit;
            if(count == 0 || count == 7) //if it's an end pit
            {
                pit = new Ellipse2D.Double(row, column, 50, 150);
                drawMarbles(p, g2, row, column, 50, 150);
            }
            else{ //if it's a regular pit
                pit = new Ellipse2D.Double(row, column, 50, 50);
                drawMarbles(p, g2, row, column, 50, 50);
            }
            //draw the pit
            //marbles are being drawn before the pit, might need to change when stylized
            g2.draw(pit);
            row+=100;
            count++;
            if(count == 8) //end of row, both end pits have been drawn
            {
                column +=100;
                row = 110; //start after first endpit
            } 
        }
        
        
    }
    /**
     * This can be refined to make the marbles look sexy.
     * Using Ellipses as a place holder.
     * Draws the marbles in the pit
     * @param p
     * @param g2
     * @param row
     * @param column
     * @param width
     * @param height 
     */
    public void drawMarbles(Pit p, Graphics2D g2, int row, int column, int width, int height)
    {
        for(int i = 0; i < p.getMarbles(); i ++)
        {
            Ellipse2D.Double pit = new Ellipse2D.Double(row+i*10, column, 10, 10);
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
}
