import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Cursor;

/**
 * This class deals with making a square and keeping track of the square's components
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 */
public class Square extends Shape
{
    /**
     * Default constructor for objects of class Square
     */
    public Square(Point2D.Double cent, double r, Color c)
    {
        super(cent, r, c); // initilized the parent class (Shape)
    }
    
    /**
     * This method returns true if the point passed in as a parameter is inside the square,
     * false otherwise
     * 
     * @param  point  this is the location of interest
     * @return    true if the point of interest is inside the square, otherwise false
     */
    public boolean isInside(Point2D.Double point)
    {
        if(point.getX() >= super.getCenter().getX() - super.getRadius() && // if x coordinate is farther to the right than the left-most x corrdinate in the square
                    point.getX() <= super.getCenter().getX() + super.getRadius()&& // if the x coordinate is farther to the left than the right-most x coordinate of the square
                    point.getY() >= super.getCenter().getY() - super.getRadius() && // if the y coordinate is farther down than the top-most y coordinate in the square
                    point.getY() <= super.getCenter().getY() + super.getRadius()) // if the y coordinate is farther up than the bottom-most y coordinate in the square
        {
            return true; // then the point is in the square
        }
        else
        {
            return false; // otherwise it is not in the square
        }
    }
    
    /**
     * This will check if the point passed in as a parameter is on the corners of the square
     * 
     * @param  point   this is the location of interest
     * @return     true if the point of interest is in any of the four corners of the large rectangle, false otherwise
     */
    public boolean isNear(Point2D.Double point)
    {
        double size = 10; // the size of the squares on the corners of the active square
        
        // Created 4 squares that will be inside the large square. 
        // Two sides of each square will border two sides of the large square.
        // Each small square will be on the corners of the large square.
        Rectangle2D.Double upperLeft = new Rectangle2D.Double(super.getCenter().getX()-super.getRadius(),super.getCenter().getY()-super.getRadius(),size,size);
        Rectangle2D.Double upperRight = new Rectangle2D.Double(super.getCenter().getX()+super.getRadius()-size,super.getCenter().getY()-super.getRadius(),size,size);
        Rectangle2D.Double lowerLeft = new Rectangle2D.Double(super.getCenter().getX()-super.getRadius(),super.getCenter().getY()+super.getRadius()-size,size,size);
        Rectangle2D.Double lowerRight = new Rectangle2D.Double(super.getCenter().getX()+super.getRadius()-size,super.getCenter().getY()+super.getRadius()-size,size,size);
                
        if(upperLeft.contains(point.getX(), point.getY(), 1, 1)) // if the square in the upper left hand corner of the large square contains the point of interest
        {   
            // sets the cursor that corresponds with the corner and returns true
            super.setCursor(Cursor.NW_RESIZE_CURSOR);
            return true;
        }
        else if(upperRight.contains(point.getX(), point.getY(), 1, 1))
        {
            // sets the cursor that corresponds with the corner and returns true
            super.setCursor(Cursor.NE_RESIZE_CURSOR);
            return true;
        }
        else if(lowerLeft.contains(point.getX(), point.getY(), 1, 1))
        {
            // sets the cursor that corresponds with the corner and returns true
            super.setCursor(Cursor.SW_RESIZE_CURSOR);
            return true;
        }
        else if(lowerRight.contains(point.getX(), point.getY(), 1, 1))
        {
            // sets the cursor that corresponds with the corner and returns true
            super.setCursor(Cursor.SE_RESIZE_CURSOR);
            return true;
        }
        else // if the point is not in any of these four locations
        {
            return false; // return false
        }
    }
    
    /**
     * this will fill or draw the square on the canvas depending on the filled parameter
     * 
     * @param  g2   this is the Graphics2D object that will fill or 
     * draw the square depending on the filled parameter
     * @param  filled    this boolean variable will return true is the square
     * is to be filled, and false if the square is to be drawn (draw = to only be outlined)
     * 
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        // creates a new Rectangle2D with appropriate dimentions and center (specified by the constructor parameters)     
        Rectangle2D.Double square = new Rectangle2D.Double(super.getCenter().getX()-super.getRadius(), super.getCenter().getY()-super.getRadius(), super.getRadius()*2, super.getRadius()*2);
        g2.setColor(super.getColor()); // sets the Graphics2D object to the appropriate color (specified by the constructor parameters)
        
        if(filled == true) // if the square should be filled
        {
            g2.fill(square); // then fills the square      
        }
        else // else if the square should not be filled 
        {
            g2.draw(square); // then outlines the square
        }
    }
    
    /**
     * Resizes the square
     * 
     * @param  mouseIs   this is the point at which the mouse currently is.
     * It is used to see how much the radius of the square should be increased
     */
    public void resize(Point2D.Double mouseIs)
    {     
        // distance from the center of the square to the mouse
        double fromCenterToPoint = Math.sqrt(Math.pow(mouseIs.getX()-super.getCenter().getX(),2.0)+ Math.pow(mouseIs.getY()-super.getCenter().getY(), 2.0));
        // sets the radius to the size required to make the corners of the square stay
        // with the mouse
        super.setRadius(fromCenterToPoint*Math.sin(Math.PI/4)+1);
    }
}
