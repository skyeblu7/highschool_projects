import java.awt.Color;
import javax.swing.JFrame;
public class BrighterDemo
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        Color myColor = new Color(50, 100, 150);
        frame.getContentPane().setBackground(myColor);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(myColor);
        
         JFrame frame2 = new JFrame();
        frame2.setSize(207, 200);
        Color myColor2 = new Color(50, 100, 150);
        frame2.getContentPane().setBackground(myColor2);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        System.out.println(myColor);
    }
}