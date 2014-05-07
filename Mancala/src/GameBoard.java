
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author #ODOT
 */
public interface GameBoard extends ChangeListener
{
    public void stateChanged(ChangeEvent e);
    void addPitView(int index, JPanel regularPitPanel, Color color);
}
