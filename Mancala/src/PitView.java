
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
    JLabel piece1 = new JLabel(new ImageIcon ("/Users/Avi/Desktop/test2.jpg"));

    public PitView(Model model, Pit pit) {
        this.model = model;
        this.pit = pit;
        //label = new JLabel("hello");

        //this.add(label);
        this.add(piece1);

        ImageIcon image = new ImageIcon("/Users/Avi/Desktop/test2.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

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

//    public JLabel getLabel() {
//        return label;
//    }
//
//    public void setLabel(JLabel label) {
//        this.label = label;
//    }
}
