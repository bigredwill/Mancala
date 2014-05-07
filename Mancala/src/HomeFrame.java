
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaeldaniels
 */
public class HomeFrame extends JFrame {

    private Model model;

    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel picLabel = null;

        ImagePanel imagePanel = null;
        try {
            BufferedImage in = ImageIO.read(this.getClass().getResource("/Images/MarioBackground.png"));
            imagePanel = new ImagePanel(in);
            //this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(this.getClass().getResource("/Images/endPit1.png"))))));
        } catch (IOException e) {
            //e.printStackTrace();
        }
        //JLabel label = new JLabel(new ImageIcon("/Images/tripEnd.gif"));
        //mainFrame.add(label);
        final JPanel mainFrame = imagePanel;
        
        //mainFrame.drawImage(background, 0, 0, null);
        //mainFrame.setBackground(Color.green);
        JButton whiteTheme = new JButton("White Theme");
        JButton blackTheme = new JButton("Black Theme");
        JButton spongebobTheme = new JButton("Spongebob Theme");
        JButton groovyTheme = new JButton("Groovy Theme");

        model = new Model(4, Color.WHITE);

        final JTextField numMarbles = new JTextField("4");

        mainFrame.add(whiteTheme);
        mainFrame.add(blackTheme);
        mainFrame.add(spongebobTheme);
        mainFrame.add(groovyTheme);
        mainFrame.add(numMarbles);

        setContentPane(mainFrame);
        setVisible(true);
        pack();

        whiteTheme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1) {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                } else {
                    // GameFrame game = new GameFrame(new Model(marbles), Color.WHITE);
                    model = new Model(marbles, Color.WHITE);

                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new WhiteTheme());
                    gf.setVisible(true);
                }
            }
        });

        blackTheme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1) {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                } else {
                    ///GameFrame game = new GameFrame(new Model(marbles), Color.BLACK);
                    model = new Model(marbles, Color.BLACK);
                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new BlackTheme());
                    gf.setVisible(true);
                }
            }
        });

        spongebobTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1) {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                } else {
                    ///GameFrame game = new GameFrame(new Model(marbles), Color.BLACK);
                    model = new Model(marbles, Color.BLACK);
                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new SpongeBobTheme());
                    gf.setVisible(true);
                }
            }
        });


        groovyTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int marbles = Integer.parseInt(numMarbles.getText());
                if (marbles > 4 || marbles < 1) {
                    JOptionPane.showMessageDialog(mainFrame, "Enter a number between 1 and 4");
                } else {
                    ///GameFrame game = new GameFrame(new Model(marbles), Color.BLACK);
                    model = new Model(marbles, Color.BLACK);
                    setVisible(false);
                    GameFrame gf = new GameFrame(model, new GroovyTheme());
                    gf.setVisible(true);
                }
            }
        });
    }

    public Model getModel() {
        return this.model;
    }
}
