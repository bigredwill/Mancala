
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 * @author #ODOT
 */
public class GameFrame extends JFrame implements GameBoard {

    private Model model;
    private ArrayList<PitView> pitViews = new ArrayList<>();
    private JButton undoButton;
    private JLabel currentPlayer;
    private JLabel pOneScore;
    private JLabel pTwoScore;
    private BoardTheme theme;
    //private BoardPanel board;

    public GameFrame(Model aModel, BoardTheme theme) {
        this.setBackground(Color.RED);
        this.theme = theme;
        this.model = aModel;
        model.addListener(this);
        JPanel parent = new JPanel();
        parent.setLayout(new BorderLayout());

        //make end pits
        PitView player1EndPit = new PitView(model, model.getPit(Model.PLAYER_ONE_MANCALA), this.theme);
        PitView player2EndPit = new PitView(model, model.getPit(Model.PLAYER_TWO_MANCALA), this.theme);
        player1EndPit.setBackground(model.getColor());
        player2EndPit.setBackground(model.getColor());

        pitViews.add(player1EndPit);
        pitViews.add(player2EndPit);
        parent.add(player1EndPit, BorderLayout.EAST);
        parent.add(player2EndPit, BorderLayout.WEST);

        currentPlayer = new JLabel(Integer.toString(model.getCurrentPlayer()));
        pOneScore = new JLabel("P1: " + Integer.toString(model.getPlayerOneScore()));
        pTwoScore = new JLabel("P2: " + Integer.toString(model.getPlayerTwoScore()));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        infoPanel.add(pTwoScore);
        infoPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        infoPanel.add(currentPlayer);
        infoPanel.add(Box.createRigidArea(new Dimension(450, 0)));
        infoPanel.add(pOneScore);
        parent.add(infoPanel, BorderLayout.NORTH);
        this.updateCurrentPlayer();

        JPanel undoPanel = new JPanel(new FlowLayout());
        undoButton = new JButton("UNDO");
        undoButton.setEnabled(false);
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");

                model.undo();
            }
        });
        undoPanel.add(undoButton, BorderLayout.NORTH);
        undoPanel.setBackground(Color.RED);
        parent.add(undoPanel, BorderLayout.SOUTH);

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
        add(parent);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 320);
        this.setResizable(false);
        this.setTitle("#ODOT MANCALLA");
        setVisible(true);
    }

    private void updateCurrentPlayer() {
        this.currentPlayer.setText("Current Player: " + Integer.toString(model.getCurrentPlayer()));
    }

    private void updateCurrentScores() {
        this.pOneScore.setText("P1: " + Integer.toString(model.getPlayerOneScore()));
        this.pTwoScore.setText("P2: " + Integer.toString(model.getPlayerTwoScore()));
    }

    @Override
    public void addPitView(int index, JPanel regularPitPanel, Color color) {
        PitView p = new PitView(model, model.getPit(index), theme);
        p.setBackground(color);
        this.pitViews.add(p);
        regularPitPanel.add(p);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.model = (Model) e.getSource();

        if (!model.canUndo()) {
            this.undoButton.setEnabled(false);
        } else {
            this.undoButton.setEnabled(true);
        }

        for (PitView pitView : pitViews) {
            pitView.updateView();
        }
        this.updateCurrentPlayer();
        this.updateCurrentScores();
        if (model.checkEndGame()) {
            this.undoButton.setEnabled(false);
        }
        this.repaint();

        if (model.checkEndGame()) {
            //game over
            this.displayerWinningPlayer();
            System.exit(-1);
        }
    }

    private void displayerWinningPlayer() {
        Pit[] board = model.getBoard();

        int player1Marbles = board[Model.PLAYER_ONE_MANCALA].getMarbles();
        int player2Marbles = board[Model.PLAYER_TWO_MANCALA].getMarbles();
        if (player1Marbles > player2Marbles) {
            JOptionPane.showMessageDialog(this, "GAME OVER! \n Player 1 Wins!");
        } else if (player2Marbles > player1Marbles) {
            JOptionPane.showMessageDialog(this, "GAME OVER! \n Player 2 Wins!");
        } else {
            JOptionPane.showMessageDialog(this, "GAME OVER! \n We are all winners!");
        }
    }
}
