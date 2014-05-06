
import java.awt.Color;
import java.util.Scanner;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * This is the main driver class, ya heard
 *
 * @author Will
 */
public class Mancala
{

    public static void main(String args[])
    {
//        while(true)
//        {
        //Model model = new Model(4);
//            //GameFrame game = new GameFrame(model);
//            HomeFrame home = new HomeFrame();
//            Model model = home.getModel();
//            GameFrame game = new GameFrame(model);
//            Scanner reader = new Scanner(System.in);
        Model model = new Model(4, Color.BLACK);
        
//        JFrame frame = new JFrame();
//        
//        BlackGameBoard board = new BlackGameBoard(model);
//        frame.add(board);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.setSize(1100, 320);
//        frame.setResizable(false);
//        frame.setTitle("#ODOT MANCALLA");
//        frame.setVisible(true);
        
        MainFrame main = new MainFrame(model);
        main.start();




//        }
    }
}
