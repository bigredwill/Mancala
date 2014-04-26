
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TIME 4:31, April 25
 * 
 * I hacked into the gameframe guys.
 *
 * @author Will Simons
 */
public class GameFrame extends JFrame implements ChangeListener
{

    private Model model;
    private BoardPanel board;
    public GameFrame(Model aModel)
    {
        this.model = aModel;
        board = new BoardPanel(model); 
        this.setLayout(new FlowLayout());
        setContentPane(board);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);
    }
    

    @Override
    public void stateChanged(ChangeEvent e)
    {
        this.model = (Model) e.getSource();
        board.updateModel(model);
        board.repaint();
    }
}