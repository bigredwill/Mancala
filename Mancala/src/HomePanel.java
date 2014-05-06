
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaeldaniels
 */
public class HomePanel extends JPanel
{
    private Model model;
    private boolean gameSelected;
    public HomePanel(Model m)
    {
        gameSelected = false;
        model = m;
        
        JButton whiteTheme = new JButton("White Theme");
        JButton blackTheme = new JButton("Black Theme");

        final JTextField numMarbles = new JTextField("4");
        
        add(whiteTheme);
        add(blackTheme);
        add(numMarbles);
        //System.out.println("created");
        setVisible(true);
        
        whiteTheme.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1)
                {
                    JOptionPane.showMessageDialog(numMarbles, "Enter a number between 1 and 4");
                }
                else
                {
                   // GameFrame game = new GameFrame(new Model(marbles), Color.WHITE);
                    model = new Model(marbles, Color.WHITE);
                    gameSelected = true;
                    System.out.println("true");
                }
            }
        });
        
        
        blackTheme.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1)
                {
                    JOptionPane.showMessageDialog(numMarbles, "Enter a number between 1 and 4");
                }
                else
                {
                    model = new Model(marbles, Color.BLACK);
                    gameSelected = true;
                    System.out.println("true");
                }
            }
        });
    }
    
    public Model getModel()
    {
        return this.model;
    }
    
    public boolean isGameSelected()
    {
        System.out.println("isGameSelected " + gameSelected);
        return this.gameSelected;
    }
}
