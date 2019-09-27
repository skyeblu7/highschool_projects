import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Rectangle;
import java.lang.Math;


/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class CityscapeComponent extends JComponent
{
    // define the objects in your Cityscape as instance variables
    private Sphere sun;
    private Sphere moon;
    private Building2D building0;
    private Building2D building1;
    private Rectangle grass;
    private Graphics2D g2;
    private Rectangle background;
    private Sky sky;
    
    // define the CityscapeComponent contructor and intiailize all instance variables
    // ...
    public CityscapeComponent(Color c)
    {
        sun = new Sphere(-40, 500, 80, Color.YELLOW);
        moon = new Sphere(700, 500, 60, Color.WHITE);
        building0 = new Building2D(135,175,230,425,Color.WHITE,40,40,c);
        building1 = new Building2D(400,175,230,425,Color.BLACK,40,40,c);
        background = new Rectangle(0,0,800,700);
        sky = new Sky();
        grass = new Rectangle(0,500,800,200);
    }
    
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     */
    public void paintComponent(Graphics g)
    {
        g2 = (Graphics2D) g;
        
        g2.setColor(sky.getSkyColor());
        g2.fill(background);
        
        sun.draw(g2);
        moon.draw(g2);
        
        g2.setColor(Color.GREEN);
        g2.fill(grass);
        
        building0.draw(g2);
        building1.draw(g2);
        
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when they are next drawn.
     *
     */
    public void nextFrame(double time)
    {
        // update the objects in the cityscape so they are animated
       
        
        if (sun.getY() < 500)
        {
            sun.setX(sun.getX()+ 1);
        }
        else
        {
            sun.setX(sun.getX()- 1);
        }
        if (moon.getY() < 500)
        {
            moon.setX(moon.getX()+ 1);
        }
        else
        {
            moon.setX(moon.getX()- 1);
        }
        
        sun.setY(sun.getY()- (2.0*Math.cos(0.004*time)));
        moon.setY(moon.getY()+ (2.0*Math.cos(0.004*time)));
        
        
        sky.tick();
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        repaint();
    }

}