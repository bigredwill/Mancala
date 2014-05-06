
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Will, 4/29, 2:30pm.  So we can substitute any image in, it works.  This is how
 * we will do different themes.
 * @author ODOT
 */
public class PitView extends JPanel
{

    Model model;
    Pit pit;
    JLabel imageLabel;
    PitIcon icon;
    private static final String blackEnd = "Images/blueEnd.png";
    private static final String blackReg = "Images/pitBlue.png";
    private static final String whiteEnd = "Images/pitEnd";
    private static final String whiteReg = "Images/pit0.png";
    private String end;
    private String reg;
    
    class PitViewListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("clicked");
            model.executeTurn(pit);
        }
        
    }
    /**
     * Constructs a pit 
     * @param model
     * @param pit 
     */
    public PitView(Model model, Pit pit)
    {
        this.model = model;
        this.pit = pit;
        imageLabel = new JLabel();
        this.add(imageLabel);
        if(model.getColor()== Color.BLACK)
        {
            end = blackEnd;
            reg = blackReg;
        } else {
            end = whiteEnd;
            reg = whiteReg;
        }
        System.out.println("creating pit");
        
        if(this.pit.isIsEnd())
        {

            icon = new PitIcon(pit.getMarbles(), end, true);
        } else {

            icon  = new PitIcon(pit.getMarbles(), reg, false);
        }
        
        
        imageLabel.setIcon(icon);
        this.addMouseListener(new PitView.PitViewListener());
        this.updateView();
    }
    
    public Model getModel()
    {
        return model;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public Pit getPit()
    {
        return pit;
    }

    public void setPit(Pit pit)
    {
        this.pit = pit;
    }

    /**
     * Updates the view of a single pit for the 
     */
    public void updateView()
    {
        int numberOfMarbles = this.pit.getMarbles();
        icon.setNumMarbs(numberOfMarbles);
        this.imageLabel.setText(Integer.toString(numberOfMarbles));
    }

}
