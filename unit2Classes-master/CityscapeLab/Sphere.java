import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * It brings light
 * 
 * @author Kris k
 * @version 10/11/15
 */
public class Sphere
{
    private int axis;
    private double x;
    private double y;
    private Color color;
    
    /**
     * Constructor for objects of class Sun
     */
    public Sphere(double xc,double yc, int size, Color c)
    {
        x = xc;
        y = yc;
        axis = size;
        color = c;
    }

    /**
     * Draws the sun
     * 
     * @param  g2   the graphics object that allows me to make graphics
     * @return     none
     * 
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(color.darker());
        Ellipse2D.Double boarder = new Ellipse2D.Double(x-3,y-3,axis+6,axis+6);
        g2.fill(boarder);
        g2.setColor(color);
        Ellipse2D.Double sphere = new Ellipse2D.Double(x, y, axis, axis);
        g2.fill(sphere);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  none
     * @return     the x coordinate
     */
    public double getX()
    {
        return x;
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param none
     * @return     the y coordinate
     */
    public double getY()
    {
        return y;
    }



    /**
     * Returns size of sphere
     *
     * @param  none
     * @return     returns the size of the sphere
     */
    public int getSize()
    {
        return axis;
    }

    /**
     * sets a new value for x
     *
     * @param newX the new value of x
     * @return     none
     */
    public void setX(double newX)
    {
        x = newX;
    }


    /**
     * sets the new value of y
     *
     * @param  newY the new value of y
     * @return     none
     */
    public void setY(double newY)
    {
        y = newY;
    }


    /**
     * sets a new color for color
     *
     * @param  newC  the new color
     * @return     none
     */
    public void setColor(Color newC)
    {
        color = newC;
    }

}
