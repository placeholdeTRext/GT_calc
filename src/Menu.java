import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pantho on 2017-05-24.
 */
public class Menu {
    private JPanel panel1;
    public JButton startTheCalculatorButton;
    private JButton instructionsButton;
    private JButton openReadmeButton;
    private JButton exitProgramButton;

    public static JFrame caFrame;


    public Menu() {

        exitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (null,
                        "Are you sure you want to exit?","Confirming Exit",
                        0,JOptionPane.QUESTION_MESSAGE);
                if(dialogResult == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        startTheCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caFrame = new JFrame();
                caFrame.setSize(540, 200);
                caFrame.setResizable(false);
                caFrame.setTitle("2x2 game Calculator");
                caFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                caFrame.setLocation(750,350);

                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                }catch (Exception f){
                    System.out.println("Problem setting look and feel.");
                }

                Calc ca = new Calc();
                caFrame.add(ca.getPanel1());
                caFrame.setVisible(true);
                IndexFrame.inFrame.setVisible(false);
            }

        });

        openReadmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame reFrame = new JFrame();
                reFrame.setSize(875, 443);
                reFrame.setLocation(950,120);
                reFrame.setResizable(false);
                reFrame.setTitle("Readme");
                reFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                JPanel rePanel = new JPanel();
                reFrame.add(rePanel);

                if (SubFunc.soak%2==0) {
                    reFrame.setVisible(true);
                } else {
                    openReadmeButton.setEnabled(false);
                }
                SubFunc.soak++;

                JTextArea reText = new JTextArea
                        (
                                "======\n" +
                                "README\n" +
                                "======\n" +
                                "\n" +
                                "Picture a 2x2 matrix, with each element showing the payoff for two players. The payoffs are shown separated\n" +
                                "by a comma. This matrix presents four possible scenarios, determined by Player1's decisions (U,D) and\n" +
                                "Player2's decisions (L,R).\n" +
                                "\n" +
                                "\t    \t L\t     R\n" +
                                "\t    U\ta,b\t    c,d\n" +
                                "\t    D\te,f\t    g,h\n" +
                                "\n" +
                                "We can interpret 'a,b' as the combination of payoffs should Player1 choose strategy 'U', and Player2 choose\n" +
                                "strategy 'L'. In this case, the payoff for Player1 is 'a' and the payoff for Player2 is 'b'.\n" +
                                "\n" +
                                "A Nash Equilibrium is a pair of strategies where no player has any incentive to change their choice. This\n" +
                                "can be shown as a combination of pure strategies, for example (U,L) where Player1 chooses U and Player2 L,\n" +
                                "or as a mixed strategy, like ([y; 1-y], R) where Player2 will always play R and Player1 plays U with a\n" +
                                "probability of y and D with a probability of 1-y.\n" +
                                "\n" +
                                "What the program means when it says 'non-essential' is that sometimes we find mixed Nash equilibria which\n" +
                                "is the same as our pure Nash equilibria."
                );
                reText.setEditable(false);
                rePanel.add(reText);
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame stFrame = new JFrame();
                stFrame.setSize(360, 190);
                stFrame.setLocation(200,300);
                stFrame.setResizable(false);
                stFrame.setTitle("Instructions");
                stFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                JPanel stPanel = new JPanel();
                stFrame.add(stPanel);

                if (SubFunc.neon%2==0) {
                    stFrame.setVisible(true);
                } else {
                    instructionsButton.setEnabled(false);
                }
                SubFunc.neon++;

                JTextArea stText = new JTextArea(
                        "              ============\n" +
                        "              INSTRUCTIONS\n" +
                        "              ============\n" +
                        "\n" +
                        "1- Put in two numbers into each of the text\n" +
                        "boxes separated by a comma.    eg: 5,4\n" +
                        "\n" +
                        "2- Press the Find Nash Equilibrium button");
                stText.setEditable(false);
                stPanel.add(stText);
            }
        });

    }
    public JPanel getPanel1() {
        return panel1;
    }
//I don't know why this is here. It was automatically inserted and apparently I need it for my program to work
    public AbstractButton startTheCalculatorButton() {
        return null;
    }
}
