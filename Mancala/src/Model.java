
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The model for the Mancala board game
 *
 * @author #ODOT
 */
public class Model {

    private Pit[] board;
    private Pit[] previousBoard = null;
    private ArrayList<ChangeListener> listeners = new ArrayList<>();
    private int currentPlayer = PLAYER_ONE;
    private int previousPlayer = PLAYER_TWO;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int PLAYER_ONE_MANCALA = 0;
    public static final int PLAYER_TWO_MANCALA = 7;
    public static final int NUM_REGULAR_PITS = 6;
    public static Color color;
    private int undoCounter = 0;

    public Model(int numMarbles, Color aColor) {
        board = new Pit[14];
        createBoard(numMarbles);
        color = aColor;
        //();

    }

    public Pit[] getBoard() {
        return this.board;
    }

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
        if (pit.getPlayer() != this.currentPlayer) {
            //valid pit
            System.out.println("That isn't your pit.");
            return false;
        } else {
            return true;
        }
    }

    private boolean distributeMarbs(Pit pit) {
        if (pit.getMarbles() == 0) {
            return false;
        }
        return true;
    }

    private boolean distributeMarbles(Pit pit) {
        if (pit.getMarbles() == 0) {
            //no marbles
            System.out.println("There are no marbles in this pit.");
            return false;
        }

        setUndo();

        int pitIndex = this.getPitIndex(pit);
        int numberOfIterations = pit.getMarbles();
        pit.setMarbles(0);

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
                    if (currentPitIndex != 0) {
                        currentPitIndex--;
                    } else {
                        currentPitIndex = board.length - 1;
                    }
                    System.out.println("currentpitindex " + currentPitIndex);
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
        if (lastPitVisted.getPlayer() == currentPlayer) {
            this.capture(lastPitVisted);
        }


        if (lastPitVisted.isIsEnd() == true) {
            System.out.println("free turn!");
            //current player stays the same
        } else {
            int lastPlayer = currentPlayer;

            if (currentPlayer == PLAYER_ONE) {
                currentPlayer = PLAYER_TWO;

            } else {
                currentPlayer = PLAYER_ONE;
            }
            if (lastPlayer != currentPlayer && undoCounter >= 3) {
                undoCounter = 0;
            }
        }




        System.out.println("Next turn by: " + currentPlayer);

        if (checkEndGame()) {
            this.moveRemainingMarbles();
        }

        ChangeEvent event = new ChangeEvent(this);
        dispatch(event);


        return true;

    }

    public boolean canUndo() {
        if (previousBoard != null && undoCounter < 3) {
            return true;
        }
        return false;
    }

    private void setUndo() {
        Pit[] temp = new Pit[this.board.length];


        for (int i = 0; i < board.length; i++) {
            Pit p = new Pit(board[i]);
            temp[i] = p;
        }
        this.previousBoard = temp;
        this.previousPlayer = this.currentPlayer;
    }

    private void dispatch(ChangeEvent event) {
        for (ChangeListener listener : this.listeners) {
            listener.stateChanged(event);
        }
    }

    private void capture(Pit lastPitVisited) {
        if (lastPitVisited == null) {
            return;
        }

        if (lastPitVisited.getMarbles() == 1 && !lastPitVisited.isIsEnd()) {
            //capture
            int index = this.getPitIndex(lastPitVisited);
            int captureIndex = Math.abs(index - board.length);
            Pit capturePit = this.getPit(captureIndex);

            if (capturePit.getMarbles() != 0) {
                if (this.currentPlayer == PLAYER_ONE) {
                    Pit player1Mancalla = board[PLAYER_ONE_MANCALA];
                    player1Mancalla.setMarbles(player1Mancalla.getMarbles() + capturePit.getMarbles() + 1);
                } else if (this.currentPlayer == PLAYER_TWO) {
                    Pit player2Mancalla = board[PLAYER_TWO_MANCALA];
                    player2Mancalla.setMarbles(player2Mancalla.getMarbles() + capturePit.getMarbles() + 1);
                }


                capturePit.setMarbles(0);
                lastPitVisited.setMarbles(0);


                System.out.println("CAPTURE");
            }
        }
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
            buffer.append(pit.toString()).append("    " + counter).append("\n");
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

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getPlayerOneScore() {
        return board[PLAYER_ONE_MANCALA].getMarbles();
    }

    public int getPlayerTwoScore() {
        return board[PLAYER_TWO_MANCALA].getMarbles();
    }

    public boolean checkEndGame() {

        boolean isGameOver;

        int player1MarbleCount = this.player1MarbleCount();
        int player2MarbleCount = this.player2MarbleCount();
        if (player1MarbleCount == 0 || player2MarbleCount == 0) {
            isGameOver = true;
            return isGameOver;
        } else {
            isGameOver = false;
            return isGameOver;
        }
    }

    void undo() {
        if (canUndo()) {
            for (int i = 0; i < board.length; i++) {
                board[i].copyPit(previousBoard[i]);
            }
            previousBoard = null;
            this.currentPlayer = this.previousPlayer;
            ChangeEvent event = new ChangeEvent(this);
            dispatch(event);

            System.out.println("undo method called");
            this.undoCounter++;
        }
    }

    public Color getColor() {
        return this.color;
    }

    private int player1MarbleCount() {
        int counter = 0;
        for (int i = PLAYER_ONE_MANCALA + 1; i < PLAYER_TWO_MANCALA; i++) {
            counter += board[i].getMarbles();
        }
        return counter;
    }

    private int player2MarbleCount() {
        int counter = 0;
        for (int i = PLAYER_TWO_MANCALA + 1; i < board.length; i++) {
            counter += board[i].getMarbles();
        }
        return counter;
    }

    private void moveRemainingMarbles() {
        int player1Marbles = this.player1MarbleCount();
        int player2Marbles = this.player2MarbleCount();

        board[PLAYER_ONE_MANCALA].setMarbles(board[PLAYER_ONE_MANCALA].getMarbles() + player1Marbles);
        board[PLAYER_TWO_MANCALA].setMarbles(board[PLAYER_TWO_MANCALA].getMarbles() + player2Marbles);

        for (Pit pit : board) {
            if (pit.isIsEnd() == false) {
                pit.setMarbles(0);
            }
        }
    }
}
