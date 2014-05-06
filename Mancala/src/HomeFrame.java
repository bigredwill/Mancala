
import java.awt.Color;
import java.awt.Graphics2D;
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
public class HomeFrame extends JFrame
{
    private Model model;
    
    public HomeFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel mainFrame = new JPanel();
        JButton whiteTheme = new JButton("White Theme");
        JButton blackTheme = new JButton("Black Theme");
        model = new Model(4, Color.WHITE);
        
        final JTextField numMarbles = new JTextField("4");
        
        mainFrame.add(whiteTheme);
        mainFrame.add(blackTheme);
        mainFrame.add(numMarbles);
        setContentPane(mainFrame);
        setVisible(true);
        pack();
        
        whiteTheme.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1)
                {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                }
                else
                {
                   // GameFrame game = new GameFrame(new Model(marbles), Color.WHITE);
                    model = new Model(marbles, Color.WHITE);
                    
                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new WhiteTheme());
                    gf.setVisible(true);
                }
            }
        });
        
        blackTheme.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1)
                {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                }
                else
                {   
                    ///GameFrame game = new GameFrame(new Model(marbles), Color.BLACK);
                    model = new Model(marbles, Color.BLACK);
                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new BlackTheme());
                    gf.setVisible(true);
                }
            }
        });
    }
    
    public Model getModel()
    {
        return this.model;
    }
}
