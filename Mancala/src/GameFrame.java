
import java.awt.BorderLayout;
import java.awt.Color;
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
public class GameFrame extends JFrame implements GameBoard {

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
        player1EndPit.setBackground(model.getColor());
        player2EndPit.setBackground(model.getColor());

        pitViews.add(player1EndPit);
        pitViews.add(player2EndPit);

        parent.add(player1EndPit, BorderLayout.EAST);
        parent.add(player2EndPit, BorderLayout.WEST);

        JPanel regularPitPanel = new JPanel();
        regularPitPanel.setBackground(model.getColor());

        this.addPitView(8, regularPitPanel, model.getColor());
        this.addPitView(9, regularPitPanel, model.getColor());
        this.addPitView(10, regularPitPanel, model.getColor());
        this.addPitView(11, regularPitPanel, model.getColor());
        this.addPitView(12, regularPitPanel, model.getColor());
        this.addPitView(13, regularPitPanel, model.getColor());
        
        this.addPitView(6, regularPitPanel, model.getColor());
        this.addPitView(5, regularPitPanel, model.getColor());
        this.addPitView(4, regularPitPanel, model.getColor());
        this.addPitView(3, regularPitPanel, model.getColor());
        this.addPitView(2, regularPitPanel, model.getColor());
        this.addPitView(1, regularPitPanel, model.getColor());


        SpringUtilities.makeGrid(regularPitPanel, 2, 6, 0, 0, 5, 5);
        parent.add(regularPitPanel, BorderLayout.CENTER);



        //setContentPane(board);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 250);
        this.setResizable(false);
        this.setTitle("#ODOT MANCALLA");
        setVisible(true);
    }

    public void addPitView(int index, JPanel regularPitPanel, Color color) {
        PitView p = new PitView(model, model.getPit(index));
        p.setBackground(color);
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
