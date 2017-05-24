import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

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

        openReadmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
