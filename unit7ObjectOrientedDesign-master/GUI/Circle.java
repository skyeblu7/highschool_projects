import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Cursor;


/**
 * This class deals with all things to do with circles
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 * 
 */
public class Circle extends Shape
{
    /**
     * Default constructor for objects of class Circle
     */
    public Circle(Point2D.Double center, double r, Color c)
    {
        super(center, r, c);
    }
    
    /**
     * This checks if the point of interest is inside the circle
     * 
     * @param  point  this is the location of interest, to be checked whether
     * it is inside the circle or not
     * @return     true if the point of interest is inside the circle, false otherwise
     */
    public boolean isInside(Point2D.Double point)
    {
        // distance from the center of the circle to the point of interet
        double fromCenterToPoint = Math.sqrt(Math.pow(point.getX()-super.getCenter().getX(),2.0)
                           + Math.pow(point.getY()-super.getCenter().getY(), 2.0));
        if(fromCenterToPoint <= super.getRadius()) // if the distance to the point is shorter than the radius of the circle
        {
            return true; // then return true
        }
        else // if the distance to the point is longer than the radius
        {
            return false; // return false
        }        
    }
    
    /**
     * This method tells if a point is near the south-east 45 degrees, 
     * south-west 45 degrees, north-east 45 degrees, or north-west 45 degrees
     * 
     * @param  point   this is the location of interest
     * @return     true if the point is near N45E, N45W, S45E, S45W of the circle
     */
    public boolean isNear(Point2D.Double point)
    {
        // distance from the center of the circle to the x/y coordinate of the point on the 
        // circle that is N45E, N45W, S45E, S45W about the center
        double toEdgeOfCircle = super.getRadius()*Math.cos(Math.PI/4);
        
        double offset = -5; // how much the small circles will be shifted to make their center on the edges of the active circle
        double size = 10; // the size of the small circles on the edges of the active circle
        
        // created 4 small circles that are placed N45E, N45W, S45E, S45W on the edges of the circle
        Ellipse2D.Double upperLeft = new Ellipse2D.Double(super.getCenter().getX()-toEdgeOfCircle+offset,super.getCenter().getY()-toEdgeOfCircle+offset,size,size);
        Ellipse2D.Double upperRight = new Ellipse2D.Double(super.getCenter().getX()+toEdgeOfCircle+offset,super.getCenter().getY()-toEdgeOfCircle+offset,size,size);
        Ellipse2D.Double lowerLeft = new Ellipse2D.Double(super.getCenter().getX()-toEdgeOfCircle+offset,super.getCenter().getY()+toEdgeOfCircle+offset,size,size);
        Ellipse2D.Double lowerRight = new Ellipse2D.Double(super.getCenter().getX()+toEdgeOfCircle+offset,super.getCenter().getY()+toEdgeOfCircle+offset,size,size);
        
        if(upperLeft.contains(point.getX(), point.getY(), 1, 1)) // if the point is within the small circle
        {   
            super.setCursor(Cursor.NW_RESIZE_CURSOR); // set the cusor to the appropriate type
            return true; // return true
        }
        else if(upperRight.contains(point.getX(), point.getY(), 1, 1))// if the point is within the small circle
        {
            super.setCursor(Cursor.NE_RESIZE_CURSOR); // set the cusor to the appropriate type
            return true; // return true
        }
        else if(lowerLeft.contains(point.getX(), point.getY(), 1, 1))// if the point is within the small circle
        {
            super.setCursor(Cursor.SW_RESIZE_CURSOR); // set the cusor to the appropriate type
            return true; // return true
        }
        else if(lowerRight.contains(point.getX(), point.getY(), 1, 1))// if the point is within the small circle
        {
            super.setCursor(Cursor.SE_RESIZE_CURSOR); // set the cusor to the appropriate type
            return true; // return true
        }
        else // else if the point is not within any of the small circls
        {
            return false; // return false
        }
    }
    
    /**
     * draws the circle
     * 
     * @param  g2   the Graphics2D object that draws/outlines the circle depending on the
     * filled parameter
     * @param  filled  is true if the circle should be filled, false if it should be outlined
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        // creates a new ellipse with the approprate center and radius (specified by the constructor)        
        Ellipse2D.Double circle = new Ellipse2D.Double(super.getCenter().getX()-super.getRadius(), super.getCenter().getY()-super.getRadius(), super.getRadius()*2, super.getRadius()*2);
        g2.setColor(super.getColor()); // sets the Graphics2D object to the appropriate color (specified by the constructor)
        
        if(filled == true) // if the circle should be filled
        {
            g2.fill(circle); // fill the circle
        }
        else // else if the circle should not be filled
        {
            g2.draw(circle); // outline the circle
        }
    }
    
    /**
     * Resizes the circle
     * 
     * @param  mouseIs   this is the current location of the mouse 
     */
    public void resize(Point2D.Double mouseIs)
    {
        // distance from the center to the mouse
        double fromCenterToPoint = Math.sqrt(Math.pow(mouseIs.getX()-super.getCenter().getX(),2.0)+ Math.pow(mouseIs.getY()-super.getCenter().getY(), 2.0));
        // sets the radius to the distance the mouse is from the center
        super.setRadius(fromCenterToPoint); 
    }
}
