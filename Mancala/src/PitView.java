
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author #ODOT
 */
public class PitView extends JPanel {
    Model model;
    Pit pit;
    JLabel imageLabel;
    BoardTheme theme;
    PitIcon icon;

    class PitViewListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("clicked");
            model.executeTurn(pit);
        }
    }

    /**
     * Constructs a pit
     *
     * @param model the model that the pit is being constructed for
     * @param pit the pit that houses the info of the pit
     * @param theme the theme to be used to display the pit
     */
    public PitView(Model model, Pit pit, BoardTheme theme) {
        this.model = model;
        this.pit = pit;
        imageLabel = new JLabel();
        this.add(imageLabel);
        this.theme = theme;
        if (this.pit.isEnd()) {
            icon = new PitIcon(pit.getMarbles(), true, theme);
        } else {
            icon = new PitIcon(pit.getMarbles(), false, theme);
        }


        imageLabel.setIcon(icon);
        this.addMouseListener(new PitView.PitViewListener());
        this.updateView();
    }

    /**
     * Gets the model
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the model
     * @param model the new model to be set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets the pit
     * @return the pit
     */
    public Pit getPit() {
        return pit;
    }

    /**
     * Sets the pit
     * @param pit the pit to be set
     */
    public void setPit(Pit pit) {
        this.pit = pit;
    }

    /**
     * Updates the view of a single pit for the
     */
    public void updateView() {
        int numberOfMarbles = this.pit.getMarbles();
        icon.setNumMarbs(numberOfMarbles);
        this.imageLabel.setText(Integer.toString(numberOfMarbles));
    }
}
