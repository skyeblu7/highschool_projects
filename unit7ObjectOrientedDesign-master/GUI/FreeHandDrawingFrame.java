import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FreeHandDrawingFrame extends JFrame
{
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;
    
    DrawingCanvas canvas;
    ButtonPanel buttons;
    
    public FreeHandDrawingFrame()
    {
        canvas = new DrawingCanvas(FRAME_WIDTH, FRAME_HEIGHT);
        buttons = new ButtonPanel(canvas);
        
        this.add(buttons, BorderLayout.SOUTH);
        this.add(canvas, BorderLayout.CENTER);
        
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public static void main(String[] args)
    {
        FreeHandDrawingFrame window = new FreeHandDrawingFrame();
    }
}