import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Color;

public class Building3D
{
    private int x;
    private int y;
    private int height;
    private int width;
    private int depth;
    
    public Building3D(int xc, int yc, int w, int h, int d)
    {
        x = xc;
        y = yc;
        width = w;
        height = h;
        depth = d;
        
    }
    public void draw(Graphics2D g2)
    {
        Point2D.Double topLeft1 = new Point2D.Double(x,y);
        Point2D.Double topLeft2 = new Point2D.Double(x-depth, y-depth);
        Point2D.Double topRight1 = new Point2D.Double(x+width,y);
        Point2D.Double topRight2 = new Point2D.Double(x+width-depth,y-depth);
        Point2D.Double bottom1 = new Point2D.Double(x,y+height);
        Point2D.Double bottom2 = new Point2D.Double(x-depth,y+height-depth);
        
        Rectangle front = new Rectangle(x, y, width, height);
        Line2D.Double topLeft = new Line2D.Double(topLeft1, topLeft2);
        Line2D.Double topRight = new Line2D.Double(topRight1, topRight2);
        Line2D.Double bottom = new Line2D.Double(bottom1, bottom2);
        Line2D.Double backtop = new Line2D.Double(topRight2, topLeft2);
        Line2D.Double backleft = new Line2D.Double(topLeft2, bottom2);
        
        g2.draw(front);
        g2.draw(topLeft);
        g2.draw(topRight);
        g2.draw(bottom);
        g2.draw(backtop);
        g2.draw(backleft);
        
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public int getDepth()
    {
        return depth;
    }
}
