
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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

    /**
     * Constructs a pit 
     * @param model
     * @param pit 
     */
    public PitView(Model model, Pit pit)
    {
        this.model = model;
        this.pit = pit;
        imageLabel = new JLabel(new ImageIcon(this.getClass().getResource("Images/pit0.png")));
        this.add(imageLabel);
        String backg = "";
        
        if(this.pit.isIsEnd())
        {
            backg = "Images/pitEnd.png";
            icon = new PitIcon(pit.getMarbles(), backg, true);
        } else {
            backg = "Images/pit0.png";
            icon  = new PitIcon(pit.getMarbles(), backg, false);
        }
        
        
        imageLabel.setIcon(icon);

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
