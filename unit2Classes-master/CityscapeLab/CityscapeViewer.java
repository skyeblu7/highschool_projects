import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeViewer
{
    // the cityscape will be animated for 60 seconds
    static final int ANIMATION_TIME_IN_MILISECONDS = 6000;
    
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
        
        frame.setSize(800 /* x */, 700 /* y */);
        frame.setTitle("Cityscape");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // use the Scanner class to prompt the user for some configurable aspect of the cityscape
        Scanner s = new Scanner(System.in);
        System.out.print("What color windows do you want?(Enter in RGB format)\nRed: ");
        int r = s.nextInt();
        System.out.print("Green: ");
        int g = s.nextInt();
        System.out.print("Blue: ");
        int b = s.nextInt();
        Color color = new Color(r,g,b);
        
        
        // a frame contains a single component; create the Cityscape component and add it to the frame
        CityscapeComponent component = new CityscapeComponent( color );
        frame.add(component);
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        // animate the cityscape
        for( int time = 0; time < ANIMATION_TIME_IN_MILISECONDS; time++ )
        {
            component.nextFrame(time);
            Thread.sleep(50);
        }
        
    }

}