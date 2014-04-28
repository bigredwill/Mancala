import java.util.ArrayList;
import javax.swing.event.ChangeListener;

/**
 * The model for the Mancala board game
 *
 * @author Will, Avi
 * 4-27-14 4:45pm
 */
public class Model {

    private Pit[] board;
    private ArrayList<ChangeListener> listeners = new ArrayList<>();
    private int currentPlayer = PLAYER_ONE;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int PLAYER_ONE_MANCALA = 0;
    public static final int PLAYER_TWO_MANCALA = 7;

    public Model() {
        board = new Pit[14];
        createBoard(4);
        //();

    }

    public Pit[] getBoard() {
        return this.board;
    }

    /**
     * private void createBoard(int numMarbles) { //this.board has 14 slots 0-6
     * is p1, 7-13 is p2 for (int i = 0; i < board.length; i++) { //player one
     * end pit if (i == PLAYER_ONE_MANCALA) { board[i] = new Pit(0, PLAYER_ONE,
     * true); } else if (i == PLAYER_TWO_MANCALA) // player two endpit {
     * board[i] = new Pit(0, PLAYER_TWO, true); } else { if (i <
     * PLAYER_TWO_MANCALA) //player one pits { board[i] = new Pit(numMarbles,
     * PLAYER_ONE, false); } else { //player two pits board[i] = new
     * Pit(numMarbles, PLAYER_TWO, false); } } }
     *
     *
     * }
     */
    private void createBoard(int numMarbles) {
        //player 1 initalization 
        this.board[PLAYER_ONE_MANCALA] = new Pit(0, PLAYER_ONE, true);
        for (int i = PLAYER_ONE_MANCALA + 1; i < PLAYER_TWO_MANCALA; i++) {
            this.board[i] = new Pit(numMarbles, PLAYER_ONE, false);
        }

        this.board[PLAYER_TWO_MANCALA] = new Pit(0, PLAYER_TWO, true);
        for (int i = PLAYER_TWO_MANCALA + 1; i < board.length; i++) {
            this.board[i] = new Pit(numMarbles, PLAYER_TWO, false);
        }

        this.currentPlayer = PLAYER_ONE;
    }

    public void printBoard() {
        for (Pit p : board) {
            System.out.println(p.getPlayer() + " : " + p.getMarbles());
        }

    }

    /**
     * returns true if the turn was successfully executed, else false.
     *
     * @param pit the pit
     * @return returns true if the turn was successfully executed, else false.
     */
    public boolean executeTurn(Pit pit) {
        //validate if the pit is valid. if it fails return false
        if (isValidPit(pit) == false) {
            //invalid pit
            return false;
        }
        //if it was valid, update the model's pit array to what should happen
        this.distributeMarbles(pit);
        return true;



    }

    public void addListener(ChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(ChangeListener listener) {
        this.listeners.remove(listener);
    }

    private boolean isValidPit(Pit pit) {
        if (pit.isIsEnd() == true) {
            //end pit, cant click on it
            return false;
        }

        //check player
        if (pit.getPlayer() == this.currentPlayer) {
            //valid pit
            return true;
        }

        return false;
    }

    private void distributeMarbles(Pit pit) {
        //update the array
        if (pit.getMarbles() == 0) {
            //no marbles
            return;
        }

        int pitIndex = this.getPitIndex(pit);



        //pits from pitIndex to pitIndex + marbles should be incremented by 1
        int numberOfIterations = pit.getMarbles();
        pit.setMarbles(0);

        //i is the ith marbles

        Pit lastPitVisted = null;
        for (int i = 1; i <= numberOfIterations; i++) {
            //the current pit adjusted
            //int currentPitIndex = this.getPitIndex(pitIndex, i);
            int currentPitIndex;
            if (lastPitVisted == null) {
                currentPitIndex = this.getPitIndex(pitIndex, 1);
            } else {
                //get the index of the last visited pit
                int lastPitIndex = this.getPitIndex(lastPitVisted);
                currentPitIndex = this.getPitIndex(lastPitIndex, 1);
            }

            Pit currentPit = board[currentPitIndex];
            lastPitVisted = currentPit;

            //check if it is end pit
            if (currentPit.isIsEnd() == true) {
                //if end pit is current users end pit increment that one
                if (currentPit.getPlayer() == this.currentPlayer) {
                    //increment that one
                    currentPit.setMarbles(currentPit.getMarbles() + 1);
                } else {
                    //not the current player's end pit
                    currentPitIndex--;
                    lastPitVisted = board[currentPitIndex];
                    currentPit = lastPitVisted;
                    currentPit.setMarbles(currentPit.getMarbles() + 1);
                }
            } else {
                //not an end pit just add one
                currentPit.setMarbles(currentPit.getMarbles() + 1);
            }
        }
        //iterate over the changelisteners

    }

    private int getPitIndex(Pit pit) {

        //figure out which index pit you passed
        int pitIndex = 0;
        for (Pit indexPit : board) {
            if (indexPit == pit) {
                return pitIndex;
            }
            pitIndex++;
        }
        return -1;
    }

    private int getPitIndex(int pitIndex, int i) {
        int endingIndex = pitIndex - i;
        if (endingIndex < 0) {
            //adjust it
            endingIndex = endingIndex + board.length;

        }
        return endingIndex;

    }
    
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        int counter = 0;
        for (Pit pit : board) {
            buffer.append(pit.toString()).append( "    " +  counter).append("\n");
            counter++;
        }
        return buffer.toString();
    }
    
    public Pit getPit(int index) {
        if (index < board.length && index >= 0) {
            return board[index];
        }
        return null;
    }
}
