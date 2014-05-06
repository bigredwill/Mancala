
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
     * @param model
     * @param pit 
     */
    public PitView(Model model, Pit pit, BoardTheme theme)
    {
        this.model = model;
        this.pit = pit;
        imageLabel = new JLabel();
        this.add(imageLabel);
        //this.setBackground(Color.red);
        this.theme = theme;
        if(this.pit.isIsEnd())
        {
//            backg = "Images/pitEnd.png";
            
            icon = new PitIcon(pit.getMarbles(), true, theme);
        } else {
//            backg = "Images/pit0.png";
            
            icon  = new PitIcon(pit.getMarbles(), false, theme);
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
