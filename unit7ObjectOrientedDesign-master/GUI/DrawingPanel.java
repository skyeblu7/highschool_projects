import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JColorChooser;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Cursor;
import java.awt.Point;

/**
 * The class DrawingPanel deals with all adding of shapes to the canvas, the current
 * color, the changing of the color, the changing of the mouse, and keeps track of the mouse
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 * 
 * Instance Variables
 * 
 * shapes     all of the shapes that are on the canvas
 * drawingColor     the current drawing color
 * activeShape     the currently selected shape
 * shapeToBeResized    the shape that is going to be resized (indicated as an index number, -1 if there is no shape to be resized)
 * mouseWas     the position of the mouse exactly before the mouse moved
 * FRAME_WIDTH    the width of the frame
 * FRAME_HEIGHT    the height of the frame
 */
public class DrawingPanel extends JPanel 
{
    private ArrayList<Shape> shapes;  
    private Color drawingColor;
    private Shape activeShape;
    
    private int shapeToBeResized;
    private Point2D.Double mouseWas;
        
    private int FRAME_WIDTH;
    private int FRAME_HEIGHT;
    
    public DrawingPanel(int width, int height)
    {
        // gets the width and height from the DrawingEditor class
        FRAME_WIDTH = width;
        FRAME_HEIGHT = height;
        
        // sets the background of the canvas and the starting drawing color
        this.setBackground(Color.white);
        drawingColor = Color.black;
        
        // sets the default 'was' position of the mouse and 
        // default shape in the shapes list to be resized (there is no shape, so -1)
        shapeToBeResized = -1;
        mouseWas = null;
        
        // creates a new arraylist that only takes objects of type Shape and 
        // sets the default active shape to null (because no shape has been selected)
        shapes = new ArrayList<Shape>();
        this.activeShape = null;
        
        // adds the listeners to the canvas
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
    }
    /**
     * returns the current color
     * 
     * @return     returns the current color
     */
    public Color getColor()
    {
        return this.drawingColor; // returns the current color
    }
    /**
     * returns the preferred size
     * 
     * @return     returns the preferred size
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(FRAME_WIDTH, FRAME_HEIGHT); // returns the preferrred size
    }
    /**
     * Called from ControlPanel when the “Pick Color” button is 
     * clicked. Brings up a JColorChooser and sets the chosen color 
     * as the new drawing color. Leaves the drawing color unchanged 
     * if the user clicks “Cancel.”
     * 
     */
    public void pickColor()
    {          
        // creates a new JColorChooser
        JColorChooser colorChooser = new JColorChooser(drawingColor);
        // creates a Color object to store the chosen color, if the user
        // chooses "Cancel", then the return value is null
        Color hopefullyAColor = colorChooser.showDialog(this, "Choose a color!", drawingColor);
        
        if(hopefullyAColor != null) // if the color returned is not null, thereby it being a color
        {
            drawingColor = hopefullyAColor; // set the drawing color to this color
            this.repaint(); // repaint the canvas
        }
        else // else if the color is null
        {
            drawingColor = this.drawingColor; // then set the color to what it is now
        }
    }
    /**
     * Called from ControlPanel when the "Add Circle" 
     * button is clicked. Adds a new circle to the list. 
     * The new circle has its center at the center of the 
     * drawing panel, a random radius (within a reasonable range) 
     * and the current drawing color. The new circle is designated 
     * as the “active shape.”
     * 
     */
    public void addCircle()
    {
        // adds a new circle to the shapes list
        shapes.add(new Circle(new Point2D.Double(FRAME_WIDTH/2, FRAME_HEIGHT/2), 50, drawingColor));
        this.repaint(); // repaints the canvas
    }
    /**
     * Called from ControlPanel when the "Add Square" 
     * button is clicked. Adds a new square to the list. 
     * The new square has its center at the center of the 
     * drawing panel, a random radius (within a reasonable range) 
     * and the current drawing color. The new square is designated 
     * as the “active shape.”
     * 
     */
    public void addSquare()
    {
        // adds a new square to the shapes list
        shapes.add(new Square(new Point2D.Double(FRAME_WIDTH/2, FRAME_HEIGHT/2), 50, drawingColor));
        this.repaint(); // repaints the canvas
    }
    /**
     * Draws all the shapes in the list. The shapes should 
     * be drawn in reverse from the order in which they were 
     * added to the list. However, if one of the shapes is “picked,” 
     * then this “active shape” should be drawn last, in outline only.
     * 
     * @param g    the Graphics object
     */
    public void paintComponent(Graphics g)
    {
        // initialized the parent class
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g; // casts the Graphics object to a Graphics2D object
        
        for(Shape shape : shapes) // goes through all the shapes in the shapes list
        {
            if(shape == activeShape) // if the shape is the activeShape
            {
                shape.draw(g2, false); // draw the shape
            }
            else // if the shape is not the active shape
            {
                shape.draw(g2, true); // outline the shape
            }
            repaint(); // repaint the canvas
        }
    }
    
     /**
     * This class deals with all things having to do with the mouse
     * 
     * @author Kristopher Koepcke
     * @version 3/4/2016
     * 
     */
    public class MyMouseListener implements MouseListener
    {
         /**
         * deals with what happens when the mouse is pressed
         * 
         * @param  event   this is the event that happened, it has lots of info including 
         * where it happened. 
         */
        public void mousePressed(MouseEvent event)
        {
            for(int i = shapes.size()-1; i >= 0; i--) // goes through the shapes in the shapes list backwards
            {
                // creates a new Point2D.Double to keep track of where the mouse is
                Point2D.Double eventPoint = new Point2D.Double(event.getX(), event.getY());
                
                if(shapes.get(i).isNear(eventPoint)) // if the mouse clicked 'near' the shape
                {
                    shapeToBeResized = i; // the shape will be resized
                    mouseWas = eventPoint; // the point where the mouse clicked
                }  
            }
        }
        /**
         * deals with what happens when the mouse is released
         * 
         * @param  event   this is the event that happened, it has lots of info including 
         * where it happened. 
         */
        public void mouseReleased(MouseEvent event) 
        { 
            shapeToBeResized = -1; // the index of the shape that needs resizing (if no shape needs resizing, then it equals -1)
                        
            for(int i = shapes.size()-1; i >= 0; i--) // goes through the shapes list backwards
            {
                // creates a new Point2D.Double to keep track of where the event occured
                Point2D.Double eventPoint = new Point2D.Double(event.getX(), event.getY());
                
                if(activeShape != null && !(shapes.get(i).isInside(eventPoint))) // if there is an active shape and the event did not occur in any of the shapes
                {
                     activeShape = null; // make the active shape null (this deselects the shape)
                }
                else if(shapes.get(i).isInside(eventPoint) || shapes.get(i).isNear(eventPoint)) // if the event occured inside the shape or 'near' the shape
                {
                    activeShape = shapes.get(i); // the active shape is now that shape
                    shapes.remove(i); // remove that shape from the list
                    shapes.add(activeShape); // add the shape back to the list, it is now the last object in the list
                    break; // break out of the loop otherwise it will run through all the shapes and only the last shape will be able to be pressed
                }
            }
        }
        
        // do-Nothing methods
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }    
    public class MyMouseMotionListener implements MouseMotionListener
    {
        /**
         * deals with what happens when the mouse moves
         * 
         * @param  event   this is the event that happened, it has lots of info including 
         * where it happened. 
         */
        public void mouseMoved(MouseEvent event) 
        {
            // creates a new Point2D.Double to keep track of where the event occured
            Point2D.Double eventPoint = new Point2D.Double(event.getX(), event.getY());
            for(int i = shapes.size()-1; i >= 0; i--) // goes through the list backwards
            {
                if(shapes.get(i) == activeShape && shapes.get(i).isNear(eventPoint)) // if the shape is the active shape and the event is 'near' the shape
                {
                    setCursor(new Cursor(shapes.get(i).getCursor())); // set the cursor to the appropriate type (stored in the shape class)
                    break; // end the loop
                }
                else if(shapes.get(i) != activeShape && shapes.get(i).isInside(eventPoint)) // if the shape is not the active shape and the event occured inside the shape
                {
                    setCursor(new Cursor(Cursor.HAND_CURSOR)); // set the cursor to the hand type
                    break; // end the loop
                }
                else // if the event occurs anywhere else at any other time
                {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // the default cursor is used
                }
            }
        }
        /**
         * deals with what happens when the mouse is dragged
         * 
         * @param  event   this is the event that happened, it has lots of info including 
         * where it happened. 
         */
        public void mouseDragged(MouseEvent event) 
        {
            // creates a new Point2D.Double to keep track of where the event occured
            Point2D.Double eventPoint = new Point2D.Double(event.getX(), event.getY());
            for(int i = shapes.size()-1; i >= 0; i--) // goes through the shapes list backwards
            {          
                if(activeShape != null && shapeToBeResized == -1) // if their is an active shape and there isn't a shape to be resized
                {
                    activeShape.move(event.getX(), event.getY()); // move the shape to where the event occured
                }
                else if (shapeToBeResized != -1) // if there is a shape to be resized
                {
                    shapes.get(shapeToBeResized).resize(eventPoint); // get the shape that needs to be resized and resize it
                    mouseWas = eventPoint; // sets the new position of where the mouse is
                    repaint(); // repaints the canvas
                }
            }
        }        
    }
}