
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * The model for the Mancala board game
 * @author Will
 */
public class Model implements ChangeListener {
    
    private Pit[] board;
    
    public Model()
    {
        board = new Pit[14];
        createBoard();
        
    }
    
    private void createBoard()
    {
        for(int i = 0; i < board.length; i ++)
        {
            board[i] = new Pit(4);
        }
    }
    
    public void printBoard()
    {
        for(int i = 1; i < board.length/2-1; i++)
        {
            System.out.print(board[i] + " ");
        }
        System.out.println("\n"+board[0] + "\t" + board[6]);
        for(int i = 7; i < board.length; i++)
        {
            System.out.print(board[i] + " ");
        }
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
