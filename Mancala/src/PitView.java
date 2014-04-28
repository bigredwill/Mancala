
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Avi
 */
public class PitView extends JPanel {

    Model model;
    Pit pit;
    //JLabel label;
    //JLabel imageLabel = new JLabel(new ImageIcon ("/Users/Avi/Desktop/spongebob.jpg"));
    JLabel imageLabel = new JLabel(new ImageIcon(this.getClass().getResource("Images/pit0.png")));

    public PitView(Model model, Pit pit) {
        this.model = model;
        this.pit = pit;
        //label = new JLabel("hello");

        //this.add(label);
        this.add(imageLabel);

//        ImageIcon image = new ImageIcon("/Users/Avi/Desktop/spongebob.jpg");
//        JLabel label = new JLabel("", image, JLabel.CENTER);
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(label, BorderLayout.CENTER);
        this.updateView();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Pit getPit() {
        return pit;
    }

    public void setPit(Pit pit) {
        this.pit = pit;
    }
    
    public void updateView() {
        //already know the pit
        int numberOfMarbles = this.pit.getMarbles();
        
        //for all pits
        String fileName = "Images/pit" + numberOfMarbles + ".png";
        
        this.imageLabel.setIcon(new ImageIcon(this.getClass().getResource(fileName)));
        this.imageLabel.setText(Integer.toString(numberOfMarbles));
    }

//    public JLabel getLabel() {
//        return label;
//    }
//
//    public void setLabel(JLabel label) {
//        this.label = label;
//    }
}
