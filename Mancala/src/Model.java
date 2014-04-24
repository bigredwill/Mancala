
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * The model for the Mancala board game
 * @author Will
 */
public class Model implements ChangeListener {
    
    private Pit[] board;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int PLAYER_ONE_MANCALA = 0;
    public static final int PLAYER_TWO_MANCALA = 7;
    
    public Model()
    {
        board = new Pit[14];
        createBoard(4);
        printBoard();
        
    }
    
    public Pit[] getBoard()
    {
        return this.board;
    }
    
    private void createBoard(int numMarbles)
    {
        //this.board has 14 slots   0-6 is p1, 7-13 is p2
        for(int i = 0; i < board.length; i ++)
        {
            //player one end pit
            if(i == PLAYER_ONE_MANCALA)
            {
                board[i] = new Pit(0, PLAYER_ONE, true);
            } else if (i == PLAYER_TWO_MANCALA) // player two endpit
            {
                board[i] = new Pit(0, PLAYER_TWO, true);
            } else { 
                if (i < PLAYER_TWO_MANCALA) //player one pits
                {
                    board[i] = new Pit(numMarbles, PLAYER_ONE, false);
                } else { //player two pits
                    board[i] = new Pit(numMarbles, PLAYER_TWO, false);
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
    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
