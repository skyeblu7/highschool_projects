import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Cursor;


/**
 * The abstract class Shape deals with the Circle and Square classes
 * 
 * @author Kristopher Koepcke
 * @version 3/4/2016
 * 
 * Instance Variables
 * radius   the radius of the shape (for the square it is the distance from the center to
 * the edge of the square where it is perpedicular to that edge)
 * color   the color of the shape
 * center   the center of the shape
 * cursor   the type of cursor that the mouse should be when hovering over the shape
 */
public abstract class Shape
{
    private double radius;
    private Color color;
    private Point2D.Double center;
    private int cursor;

    /**
     * Default constructor for objects of class Shape
     */
    public Shape(Point2D.Double center, double r, Color c)
    {
        // Creates a shape with the center at the specified point 
        // and with the specified radius and color. 
        this.center = center;
        this.radius = r;
        this.color = c;
        this.cursor = Cursor.DEFAULT_CURSOR;
    }
    
    /**
     * Sets the cursor to the appropriate type
     * 
     * @param  newCursor   this is the curosr that the mouse will be changed to 
     */
    public void setCursor(int newCursor)
    {
        this.cursor = newCursor; // sets the cursor of the mouse
    }
    
    /**
     * returns the current cursor being used
     * 
     * @return     returns the current cursor being used
     */
    public int getCursor()
    {
        return this.cursor; // returns the curent cursor being used
    }
    
    /**
     * returns the center of the shape
     *
     * @return    returns the center of the shape
     */
    public Point2D.Double getCenter()
    {
        return this.center; // Returns the the center of the shape.
    }

    /**
     * 
     * returns the radius of the shape
     * 
     * @return    returns the radius of the shape
     */
    public double getRadius()
    {
        return this.radius; // Returns the radius
    }
    
    /**
     * returns the current color of the shape
     * 
     * @return current  returns the color of the shape
     */
    public Color getColor()
    {
        return this.color; // returns the current color of the shape
    }


    /**
     * moves the shape to the location in the parameters
     *
     * @param  x   the x coordinate that the shape will move to
     * @param  y   the y coordinate that the shpae will move to
     */
    public void move(double x, double y)
    {
        this.center.setLocation(x, y); // sets the center to that location
    }

    /**
     * sets the radius to an new value
     *
     * @param  r   the new radius that shape will have
     */
    public void setRadius(double r)
    {
        this.radius = r; // Sets the radius of this shape to r.
    }

    /**
     * Returns true if the point lies inside this shape, false otherwise
     *
     * @param  point   the point we are checking if it is inside the shape
     * @return     true if the point is inside the shape, false otherwise
     */
    public abstract boolean isInside(Point2D.Double point);
    
    /**
    * this method checks to see if the point given in the parameter
    * is near the corners of the shape (for the circle if the point is
    * N45E, N45W, S45E, or S45W on the edge of the circle)
    *
    * @pre     the shape is the active shape
    * 
    * @post    the cursor will change and the method will return true
    * 
    * @param   point   the point that will be checked
    * 
    * @return  true if the point is near the corners of the shape
    */
    public abstract boolean isNear(Point2D.Double point);
    
     /**
     * will resize the shape
     *
     * @pre     the shape is the active shape and the mouse has selected 
     * a corner of the shape (for the circle the N45E, N45W, S45E, or S45W on 
     * the edge of the circle)
     * 
     * @post    the radius will change to make the edge of the shape stay with the mouse
     * 
     * @param   mouseIs   where the mouse currently is
     */
    public abstract void resize(Point2D.Double mouseIs);
    
    /**
     * Draws this shape. Draws a filled shape if filled is true, and a hollow shape 
     * otherwise. 
     *
     * @param  g2    the graphics object that paints the object
     * @param  filled     tells if the shape will be filled (if true) or not (if false)
     *
     */
    public abstract void draw(Graphics2D g2, boolean filled);

}
