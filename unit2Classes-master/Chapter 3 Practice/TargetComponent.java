import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Rectangle;

public class TargetComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        int x = getWidth()/2;
        int y = getHeight()/2;
        
        Target target1 = new Target((x-25), (y-25), 50, 50, Color.BLACK);
        Target target2 = new Target((x-50), (y-50), 100, 100, Color.RED);
        Target target3 = new Target((x-75), (y-75), 150, 150, Color.BLACK);
        Target target4 = new Target((x-100), (y-100), 200, 200, Color.RED);
        
        Rectangle background = new Rectangle(0,0,500,500);
        g2.setColor(Color.WHITE);
        g2.fill(background);
        
        target4.draw(g2);
        target3.draw(g2);
        target2.draw(g2);
        target1.draw(g2);
    }
}
