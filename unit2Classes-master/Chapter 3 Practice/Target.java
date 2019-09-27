import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class Target
{
    private int xLeft;
    private int yTop;
    private int width;
    private int height;
    private Color color;
    
    public Target(int x, int y, int w, int h, Color c)
    {
        xLeft = x;
        yTop = y;
        width = w;
        height = h;
        color = c;
    }
    public void draw(Graphics2D g2)
    {
        
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}
