import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class deals with all the buttons in the program
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 * 
 * Instance Variables
 * 
 * pickColorButton    The button that will determine the color of the next shape put onto the canvas
 * addCircleButton    The button that adds a circle to the canvas
 * addSquareButton    the button that adds a square to the canvas
 * currentDrawingColor   the color on the panel by the buttons that tells you what color is currently selected
 * canvas    the canvas of the program, a reference to the DrawingPanel
 */
public class ControlPanel extends JPanel
{
    private JButton pickColorButton, addCircleButton, addSquareButton;
    private JPanel currentDrawingColor;
    private DrawingPanel canvas;
    
    public ControlPanel(DrawingPanel drawingPanel)
    {
        // import the DrawingPanel class to get the current color
        canvas = drawingPanel;
        
        // instantiate the buttons and current drawing color
        this.pickColorButton = new JButton("Pick Color");        
        this.addCircleButton = new JButton("Add Circle");
        this.addSquareButton = new JButton("Add Square");
        this.currentDrawingColor = new JPanel();
        
        // Create the listeners for each button
        ButtonClickListener pickColorButtonListener = new ButtonClickListener();
        ButtonClickListener addCircleButtonListener = new ButtonClickListener();
        ButtonClickListener addSquareButtonListener = new ButtonClickListener();
        
        // Getting and setting the current drawing color  
        currentDrawingColor.setBackground(canvas.getColor());
        
        // adding the buttons to the panel
        this.add(this.pickColorButton);
        this.add(this.currentDrawingColor);
        this.add(this.addCircleButton);
        this.add(this.addSquareButton);
        
        // adding the listners to the buttons
        pickColorButton.addActionListener(pickColorButtonListener);
        addCircleButton.addActionListener(addCircleButtonListener);
        addSquareButton.addActionListener(addSquareButtonListener);
    }
    
    /**
    * the ButtonClickListener class implements the ActionListener class and
    * deals with all actions that occur on the buttons
    * 
    * @author Kristopher Koepcke
    * @version 3/4/2016
    *  
    */
    public class ButtonClickListener implements ActionListener
    {
        /**
        * runs the appropriate method depending on which button has been pressed
        *
        * @param  event   the event that occurs, has lots of detail about it
        */
        public void actionPerformed(ActionEvent event)
        {
            if (event.getActionCommand().equals(pickColorButton.getText())) // if the event equals the name of the pickColorButton ("Pick Color") button
            {
                canvas.pickColor();  // run the pickColor method from the canvas
                currentDrawingColor.setBackground(canvas.getColor()); // set the drawing color indicator thing to the color that has been chosen           
            }
            else if(event.getActionCommand().equals(addCircleButton.getText())) // if the event equals the name of the addCircleButton button ("Add Circle")
            {                
                canvas.addCircle(); // run the addCircle method from the canvas
            }
            else if(event.getActionCommand().equals(addSquareButton.getText())) // if the event equals the name of the addSquareButton button ("Add Square")
            {                
                canvas.addSquare(); // run the addSquare method from the canvas
            }
            canvas.repaint(); // repaint the canvas
        }
    }
}