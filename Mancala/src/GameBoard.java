
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michaeldaniels
 */
public interface GameBoard extends ChangeListener
{
    public void stateChanged(ChangeEvent e);
    void addPitView(int index, JPanel regularPitPanel, Color color);
}
