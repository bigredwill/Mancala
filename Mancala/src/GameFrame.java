import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
/**
 * TIME 5:43, April 25
 *
 * I hacked into the gameframe guys.
 * i hacked into the mainframe
 *
 * @author Will Simons
 */
public class GameFrame extends JFrame implements ChangeListener
{
 
    private Model model;
    //private BoardPanel board;
    public GameFrame(Model aModel)
    {
        this.model = aModel;
        //board = new BoardPanel(model);
        
        model.addListener(this);
        Container parent = this.getContentPane();
        parent.setLayout(new BorderLayout());
        
        
        //make end pits
        PitView player1EndPit = new PitView(model, model.getPit(Model.PLAYER_ONE_MANCALA));
        PitView player2EndPit = new PitView(model, model.getPit(Model.PLAYER_TWO_MANCALA));
        
        parent.add(player1EndPit, BorderLayout.EAST);
        parent.add(player2EndPit, BorderLayout.WEST);
        
        ArrayList<PitView> pitViews = new ArrayList<>();
        for (Pit pit : model.getBoard()) {
            PitView pitView = new PitView(model, pit);
            pitViews.add(pitView);
        }
        
        //setContentPane(board);
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 200);
        setVisible(true);
    }
   
 
    @Override
    public void stateChanged(ChangeEvent e)
    {
        this.model = (Model) e.getSource();
        //board.updateModel(model);
        //board.repaint();
    }
}
