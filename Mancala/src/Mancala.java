
import java.util.Scanner;


/**
 * This is the main driver class, ya heard
 *
 * @author Will
 */
public class Mancala {

    public static void main(String args[]) {
        Model model = new Model();
        GameFrame game = new GameFrame(model);
        
        
            Scanner reader = new Scanner(System.in);
            
            
            
            do {
                System.out.println(model.toString());
                System.out.println("Enter an index");
                String text = reader.next();
                int index = Integer.parseInt(text);
                Pit pit = model.getPit(index);
                model.executeTurn(pit);
            }
            while (true);
        
    }
}
