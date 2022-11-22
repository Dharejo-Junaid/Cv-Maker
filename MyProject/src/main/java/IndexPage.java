import javax.swing.*;
import java.awt.*;

public class IndexPage {

    JFrame frame = new JFrame("Cv Maker");
    JLabel imageLabel=new JLabel();
    JLabel message1=new JLabel("Create a Curriculum-Vitae to get a better Job");
    JButton conButton=new JButton("Continue");

    IndexPage() {

        ImageIcon img=new ImageIcon(getClass().getResource("Logo1.png"));

        // Frame setup;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(img.getImage());
        frame.setLayout(null);

        // Image Setup;
        imageLabel.setIcon(img);
        imageLabel.setBounds(0, 30, 850, 300);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(imageLabel);

        // Highlighted Message;
        message1.setBounds(0, 350, 850, 40);
        message1.setFont(new Font("Consolas", Font.ITALIC, 20));
        message1.setHorizontalAlignment(JLabel.CENTER);
        message1.setForeground(new Color(0, 54, 118));
        frame.add(message1);

        // Continue Button;
        conButton.setFont(new Font("Times new Roman", Font.ITALIC, 20));
        conButton.setBounds(350, 505, 120, 40);
        conButton.setFocusable(false);
        conButton.setBackground(new Color(0, 54, 118));
        conButton.setForeground(Color.WHITE);
        conButton.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                frame.dispose();
                new CvMaker();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        frame.add(conButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new IndexPage();
    }
}