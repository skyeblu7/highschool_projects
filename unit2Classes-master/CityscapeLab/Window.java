import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;


/**
 * A window that will be used in a building. 
 * will change color as time goes on
 * 
 * @author Kristopher K
 * @version 10/11/2015
 */
public class Window
{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    /**
     * Constructor for objects of class Window
     */
    public Window(int xc, int yc, int windowW, int windowH, Color c)
    {
        x = xc;
        y = yc;
        width = windowW;
        height = windowH;
        color = c;
    }

    /**
     * draws the window in the frame
     * 
     * @param  g2   the graphics object that allows me to make graphics
     * @return     none
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(color);
        Rectangle window = new Rectangle(x, y, width, height);
        g2.fillRect(x,y,width,height);
    }
    
    /**
     * Returns the bottom left most point of the window
     *
     * @param  none
     * @return     the Bottom left-most point of the window
     */
    public int getBottomLeft()
    {
        return this.y+this.height;
    }
    
    /**
     * returns the upper right most point of the window
     *
     * @param  y   a sample parameter for a method
     * @return     returns the Upper right-most point of the window
     */
    public int getUpperRight()
    {
        return this.x+this.width;
    }

    /**
     * returns the x coordinate of the window
     *
     * @param  none
     * @return     returns the x coordinate of the window
     */
    public int getX()
    {
        // put your code here
        return this.x;
    }

    /**
     * returns the y coordinate of the window
     *
     * @param  none
     * @return     returns the y coordinate of the window
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * returns the width of the window
     *
     * @param none
     * @return     returns the width of the window
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * returns the height of the window
     *
     * @param  none
     * @return     returns the height of the window
     */
    public int getHeight()
    {
        return this.height;
    }

        /**
     * returns the color of the window
     *
     * @param  none
     * @return     the color of the window
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * Changes the x coordinate of the window
     *
     * @param newX the new x coordinate
     * @return     none
     */
    public void setX(int newX)
    {
        this.x = newX;
    }

    /**
     * Changes the y coordinate of the window
     *
     * @param  newY  the new y coordinate
     * @return     none
     */
    public void setY(int newY)
    {
        this.y = newY;
    }

    /**
     * changes the color of the window
     *
     * @param  newC   the new color
     * @return     none
     */
    public void setColor(Color newC)
    {
        this.color = newC;
    }

}
