
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The model holding all of the data for the game.
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
    private int undoCounter = 0;

    /**
     * Initializes a model with a specified number of marbles.
     *
     * @param numMarbles number of marbles to initialize model with.
     */
    public Model(int numMarbles) {
        board = new Pit[14];
        createBoard(numMarbles);
    }

    /**
     * Returns the current board.
     *
     * @return Pit[] pit array representing the board.
     */
    public Pit[] getBoard() {
        return this.board;
    }

    /**
     * Creates a board with a specified number of marbles.
     *
     * @param numMarbles number of marbles to create the board with.
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

    /**
     * Prints the board.
     */
    public void printBoard() {
        for (Pit p : board) {
            System.out.println(p.getPlayer() + " : " + p.getMarbles());
        }
    }

    /**
     * Returns true if the turn was successfully executed, else false.
     *
     * @param pit the pit
     * @return true if the turn was successfully executed, else false.
     */
    public boolean executeTurn(Pit pit) {
        //Make sure pit is a valid pit.
        if (isValidPit(pit) == false) {
            //invalid pit
            return false;
        }
        //if it was valid, update the model's pit array to what should happen
        this.distributeMarbles(pit);
        //Turn executed succesfully.
        return true;
    }

    /**
     * Adds a listener to notify for changes in the data.
     *
     * @param listener
     */
    public void addListener(ChangeListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Removes a listener from the model.
     *
     * @param listener A ChangeListener.
     */
    public void removeListener(ChangeListener listener) {
        this.listeners.remove(listener);
    }

    /**
     * If the pit is the current players pit, not and end pit, and has marbles,
     * it is valid.
     *
     * @param pit to validate
     * @return true if valid, false if invalid.
     */
    private boolean isValidPit(Pit pit) {
        if (pit.isEnd() == true) {
            //end pit, cant click on it
            return false;
        }

        if (pit.getPlayer() != this.currentPlayer) {
            //valid pit
            System.out.println("That isn't your pit.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Distributes marbles from a specified pit.
     *
     * @param pit the pit to distribute marbles from.
     * @return if the marbles were distributed correctly.
     */
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
                currentPitIndex = this.getEndingIndex(pitIndex, 1);
            } else {
                //get the index of the last visited pit
                int lastPitIndex = this.getPitIndex(lastPitVisted);
                currentPitIndex = this.getEndingIndex(lastPitIndex, 1);
            }

            Pit currentPit = board[currentPitIndex];
            lastPitVisted = currentPit;

            //check if it is end pit
            if (currentPit.isEnd() == true) {
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


        if (lastPitVisted.isEnd() == true) {
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
                previousBoard = null;
                System.out.println("UNDO COUNTER RESET");
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

    /**
     * Checks if the current player has any undo's left.
     *
     * @return True/False if player can/can't undo.
     */
    public boolean canUndo() {
        if (previousBoard != null && undoCounter < 3) {
            return true;
        }
        return false;
    }

    /**
     * Creates an instance of the current model so that the player can undo and
     * go back to this version of the game.
     */
    private void setUndo() {
        Pit[] temp = new Pit[this.board.length];


        for (int i = 0; i < board.length; i++) {
            Pit p = new Pit(board[i]);
            temp[i] = p;
        }
        this.previousBoard = temp;
        this.previousPlayer = this.currentPlayer;
    }

    /**
     * Notifies change listeners of changes to the model.
     *
     * @param event (Model) A change to the model.
     */
    private void dispatch(ChangeEvent event) {
        for (ChangeListener listener : this.listeners) {
            listener.stateChanged(event);
        }
    }

    /**
     * Tries to capture the pit opposite the empty pit landed in.
     *
     * @param lastPitVisited The pit that was landed in.
     */
    private void capture(Pit lastPitVisited) {
        if (lastPitVisited == null) {
            return;
        }

        if (lastPitVisited.getMarbles() == 1 && !lastPitVisited.isEnd()) {
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

    /**
     * Gets the corresponding index of the pit in the Pit[] array.
     *
     * @param pit Pit that you would like to know the index of.
     * @return int corresponding to the index of the pit.
     */
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

    /**
     * Provides offset for distributing marbles.
     *
     * @param pitIndex
     * @param i
     * @return
     */
    private int getEndingIndex(int pitIndex, int i) {
        int endingIndex = pitIndex - i;
        if (endingIndex < 0) {
            //adjust it
            endingIndex = endingIndex + board.length;

        }
        return endingIndex;

    }

    /**
     * Gets a string representing the model as a string.
     *
     * @return String representing the current model.
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        int counter = 0;
        for (Pit pit : board) {
            buffer.append(pit.toString()).append("    ").append(counter).append("\n");
            counter++;
        }
        return buffer.toString();
    }

    /**
     * Gets a pit from the Pit[] corresponding to the pit index.
     *
     * @param index the index of the pit to get.
     * @return Pit of the index provided.
     */
    public Pit getPit(int index) {
        if (index < board.length && index >= 0) {
            return board[index];
        }
        return null;
    }

    /**
     * Gets the current player.
     *
     * @return int representing current player in model.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the current player.
     *
     * @param currentPlayer int representing current player.
     */
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Gets player one's score.
     *
     * @return int representing marbles in mancala.
     */
    public int getPlayerOneScore() {
        return board[PLAYER_ONE_MANCALA].getMarbles();
    }

    /**
     * Gets player two's score.
     *
     * @return int representing marbles in mancala.
     */
    public int getPlayerTwoScore() {
        return board[PLAYER_TWO_MANCALA].getMarbles();
    }

    /**
     * Checks if the game is over.
     *
     * @return True/False if games is over.
     */
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

    /**
     * Undoes the move that was just made.
     */
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

    /**
     * Gets the number of marbles on player one's side.
     *
     * @return int of the number of marbles on player one's side.
     */
    private int player1MarbleCount() {
        int counter = 0;
        for (int i = PLAYER_ONE_MANCALA + 1; i < PLAYER_TWO_MANCALA; i++) {
            counter += board[i].getMarbles();
        }
        return counter;
    }

    /**
     * Gets the number of marbles on player two's side.
     *
     * @return int of the number of marbles on player two's side.
     */
    private int player2MarbleCount() {
        int counter = 0;
        for (int i = PLAYER_TWO_MANCALA + 1; i < board.length; i++) {
            counter += board[i].getMarbles();
        }
        return counter;
    }

    /**
     * When the game ends, move all of the marbles on the respective player's
     * side to their mancala.
     */
    private void moveRemainingMarbles() {
        int player1Marbles = this.player1MarbleCount();
        int player2Marbles = this.player2MarbleCount();

        board[PLAYER_ONE_MANCALA].setMarbles(board[PLAYER_ONE_MANCALA].getMarbles() + player1Marbles);
        board[PLAYER_TWO_MANCALA].setMarbles(board[PLAYER_TWO_MANCALA].getMarbles() + player2Marbles);

        for (Pit pit : board) {
            if (pit.isEnd() == false) {
                pit.setMarbles(0);
            }
        }
    }
}
