
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author odot
 */
public class GameBoard extends JPanel
{

    private Model model;
    private ArrayList<PitView> pitViews = new ArrayList<>();
    private JLabel pitPanel;
    private JButton undoButton;
    private JLabel currentPlayer;
    private JPanel parent;
    JPanel regularPitPanel;

    public GameBoard(Model m)
    {
        pitViews = new ArrayList<>();
        this.model = m;
        parent = new JPanel();
        parent.setLayout(new BorderLayout());
        createPitView();
        parent.add(regularPitPanel, BorderLayout.CENTER);
        this.add(parent);
    }
    void updateCurrentPlayer()
    {
        this.currentPlayer.setText("Current Player: " + Integer.toString(model.getCurrentPlayer()));
    }

    void updateBoard(Model m)
    {
        this.model = m;
        
        if (!model.canUndo()) {
            this.undoButton.setEnabled(false);
        } else {
            this.undoButton.setEnabled(true);
        }
        
        for (PitView pitView : pitViews) {
            pitView.updateView();
            System.out.println("iter");
        }
        this.updateCurrentPlayer();
        this.repaint();
    }

    void createPitView()
    {
        //make end pits
        PitView player1EndPit = new PitView(model, model.getPit(Model.PLAYER_ONE_MANCALA));
        PitView player2EndPit = new PitView(model, model.getPit(Model.PLAYER_TWO_MANCALA));
        player1EndPit.setBackground(model.getColor());
        player2EndPit.setBackground(model.getColor());


        pitViews.add(player1EndPit);
        pitViews.add(player2EndPit);
        
        parent.add(player1EndPit, BorderLayout.EAST);
        parent.add(player2EndPit, BorderLayout.WEST);

     //   regularPitPanel.setBackground(model.getColor());

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

    }

    void addPitView(int index, JPanel regPanel, Color color)
    {
        PitView p = new PitView(model, model.getPit(index));
        p.setBackground(color);
        this.pitViews.add(p);
        regPanel.add(p);
    }
}
