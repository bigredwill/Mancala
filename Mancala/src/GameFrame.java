
import java.awt.FlowLayout;
import javax.swing.*;

/**
 * I hacked into the gameframe guys.
 *
 * @author Will Simons
 */
public class GameFrame extends JFrame
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
}
