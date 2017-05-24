import javax.swing.*;


/**
 * Created by Pantho on 2017-05-24.
 */
public class IndexFrame {
    public static JFrame inFrame;

    public static void main(String[] args) {

        inFrame = new JFrame();
        inFrame.setSize(320, 350);
        inFrame.setResizable(false);
        inFrame.setTitle("Menu");
        inFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inFrame.setLocation(600,250);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        }catch (Exception e){
            System.out.println("Problem setting look and feel");
        }

        Menu in = new Menu();
        inFrame.add(in.getPanel1());
        inFrame.setVisible(true);

    }

}
