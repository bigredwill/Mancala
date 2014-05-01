
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * TIME 5:43, April 25
 *
 * I hacked into the gameframe guys. i hacked into the mainframe
 *
 * @author Will Simons
 */
public class GameFrame extends JFrame implements ChangeListener {

    private Model model;
    private ArrayList<PitView> pitViews = new ArrayList<>();
    //private BoardPanel board;

    public GameFrame(Model aModel) {
        this.model = aModel;
        //board = new BoardPanel(model);
        
        model.addListener(this);
        Container parent = this.getContentPane();
        parent.setLayout(new BorderLayout());


        //make end pits
        PitView player1EndPit = new PitView(model, model.getPit(Model.PLAYER_ONE_MANCALA));
        PitView player2EndPit = new PitView(model, model.getPit(Model.PLAYER_TWO_MANCALA));

        pitViews.add(player1EndPit);
        pitViews.add(player2EndPit);

        parent.add(player1EndPit, BorderLayout.EAST);
        parent.add(player2EndPit, BorderLayout.WEST);

        JPanel regularPitPanel = new JPanel();

        this.addPitView(8, regularPitPanel);
        this.addPitView(9, regularPitPanel);
        this.addPitView(10, regularPitPanel);
        this.addPitView(11, regularPitPanel);
        this.addPitView(12, regularPitPanel);
        this.addPitView(13, regularPitPanel);
        
        this.addPitView(6, regularPitPanel);
        this.addPitView(5, regularPitPanel);
        this.addPitView(4, regularPitPanel);
        this.addPitView(3, regularPitPanel);
        this.addPitView(2, regularPitPanel);
        this.addPitView(1, regularPitPanel);


        SpringUtilities.makeGrid(regularPitPanel, 2, 6, 0, 0, 5, 5);
        parent.add(regularPitPanel, BorderLayout.CENTER);



        //setContentPane(board);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 250);
        this.setResizable(false);
        this.setTitle("#ODOT MANCALLA");
        setVisible(true);
    }

    private void addPitView(int index, JPanel regularPitPanel) {
        PitView p = new PitView(model, model.getPit(index));
        this.pitViews.add(p);
        regularPitPanel.add(p);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model = (Model) e.getSource();
        for (PitView pitView : pitViews) {
            pitView.updateView();
        }
        this.repaint();
    }
}
