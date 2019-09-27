import javax.swing.JFrame;
import java.awt.BorderLayout;


/**
 * This is the window of the Program
 * 
 * Instance Variables
 * FRAME_WIDTH  this is the width of the window (suprise suprise)
 * FRAME_HEIGHT  this is the height of the window
 * buttons  this is the object that deals with all the buttons on the bottom of the window
 * canvas  this is the object that deals with any graphics that are seen on the drawing area
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 */
public class DrawingEditor extends JFrame
{
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;
    
    ControlPanel buttons;
    DrawingPanel canvas;
    
    /**
     * Constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        canvas = new DrawingPanel(FRAME_WIDTH, FRAME_HEIGHT);
        buttons = new ControlPanel(canvas);
                
        this.add(buttons, BorderLayout.SOUTH);
        this.add(canvas, BorderLayout.CENTER);
        
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * The main method, this method starts the program
     * 
     * @param  args   the thing that we always put as an argument in a main method
     * 
     */
    public static void main(String[] args)
    {
        DrawingEditor frame = new DrawingEditor();
    }
}


