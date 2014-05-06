
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Will Simons
 */
public class MainFrame extends JFrame implements ChangeListener
{

    private Model model;
    private GameBoard board;
    HomePanel home;

    public MainFrame(Model m)
    {
        this.model = m;
        home = new HomePanel(m);
        model.addListener(this);
        add(home);
        home.setVisible(true);
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 320);
        this.setResizable(false);
        this.setTitle("#ODOT MANCALLA");
        setVisible(true);
    }

    public void start()
    {
        //HomeSelectionLoop


        while (!home.isGameSelected())
        {
        }
        System.out.println("gameSelectd");
        this.model = home.getModel();

        //GameSelectionLoop
        if (this.model.getColor() == Color.WHITE)
        {
            System.out.println("white");
            board = new BlackGameBoard(this.model);
        } else
        {
            System.out.println("black " + model.getColor());
            
            board = new WhiteGameBoard(this.model);
        }
        
        home.setVisible(false);
        this.remove(home);
        this.add(board);
        this.revalidate();
        board.setVisible(true);
        
//        while(!model.checkEndGame()){}

    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        this.model = (Model) e.getSource();

        board.updateBoard(model);
        this.repaint();
    }
}
