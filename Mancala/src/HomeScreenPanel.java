
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Avi
 */
public class HomeScreenPanel extends JPanel {
    JButton layout1;
    JButton layout2;
    
    public HomeScreenPanel(JPanel parent) {
        //initalize buttons
        layout1 = new JButton("red");
        layout2 = new JButton("blue");
    }
    
}
