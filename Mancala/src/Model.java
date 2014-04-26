
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * The model for the Mancala board game
 * @author Will
 */
public class Model {
    
    private Pit[] board;
    private ArrayList<ChangeListener> listeners;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int PLAYER_ONE_MANCALA = 0;
    public static final int PLAYER_TWO_MANCALA = 7;
    
    public Model()
    {
        board = new Pit[14];
        createBoard(2);
        printBoard();
        
    }
    
    public Pit[] getBoard()
    {
        return this.board;
    }
    
    private void createBoard(int numMarbles)
    {
        int column = 10;
        int row = 10;
        //this.board has 14 slots   0-6 is p1, 7-13 is p2
        for(int i = 0; i < board.length; i ++)
        {
            //player one end pit
            if(i == PLAYER_ONE_MANCALA)
            {
                board[i] = new Pit(0, PLAYER_ONE, true, new Ellipse2D.Double(row+ i*100, column , 50, 150));
            } else if (i == PLAYER_TWO_MANCALA) // player two endpit
            {
                board[i] = new Pit(0, PLAYER_TWO, true, new Ellipse2D.Double(row + i*100, column , 50, 150));
            } else { 
                if (i < PLAYER_TWO_MANCALA) //player one pits
                {
                    board[i] = new Pit(numMarbles, PLAYER_ONE, false, new Ellipse2D.Double(row  + i*100, column, 50, 50));
                } else { //player two pits
                    board[i] = new Pit(numMarbles, PLAYER_TWO, false, new Ellipse2D.Double(row-700+i*100, column + 100, 50, 50));
                }
            }
        }        
    }
    
    public void printBoard()
    {
        for(Pit p : board)
        {
            System.out.println(p.getPlayer() + " : " + p.getMarbles());
        }
        
    }

    /**
     * Get listeners.
     * @return 
     */
    public ArrayList<ChangeListener> getListeners()
    {
        return listeners;
    }
    /**
     * Add listeners
     * @param listeners 
     */
    public void attachListener(ChangeListener l)
    {
        listeners.add(l);
    }
    
    public void update()
    {
        for(ChangeListener l : listeners)
        {
            l.stateChanged(new ChangeEvent(this));
        }
    }
    
}
