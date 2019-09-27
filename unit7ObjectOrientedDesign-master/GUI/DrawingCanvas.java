import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawingCanvas extends JPanel
{
    public int FRAME_WIDTH;
    public int FRAME_HEIGHT;
    
    private ArrayList<Ellipse2D.Double> points;
    private Color drawingColor;
    
    public DrawingCanvas(int width, int height)
    {
         FRAME_WIDTH = width;
         FRAME_HEIGHT = height;
         
         this.setBackground(Color.white);
         drawingColor = Color.black;
         
         points = new ArrayList<Ellipse2D.Double>();
         
         this.addMouseListener(new MyMouseListeners());
         this.addMouseMotionListener(new MyMouseListeners());         
    }
    public void pickColor()
    {
        JColorChooser colorChooser = new JColorChooser(drawingColor);
        Color hopefullyAColor = colorChooser.showDialog(this, "Choose a color!", drawingColor);
        
        if(hopefullyAColor != null)
        {
            drawingColor = hopefullyAColor;
            this.repaint();
        }
        else
        {
            drawingColor = this.drawingColor;
        }
    }
    public void clearCanvas()
    {
        //
        
        
    }
    public Color getColor()
    {
        return this.drawingColor;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(drawingColor);
        
        for(int i = 0; i < points.size(); i++)
        {
            g2.draw(points.get(i));
        }
        repaint();
    }
    
    public class MyMouseListeners implements MouseListener, MouseMotionListener
    {
        public void mousePressed(MouseEvent event) 
        {
            points.add(new Ellipse2D.Double(event.getX(), event.getY(), 1, 1));
        }
        public void mouseReleased(MouseEvent event) 
        {
            
        }
        public void mouseDragged(MouseEvent event) 
        {
            points.add(new Ellipse2D.Double(event.getX(), event.getY(), 1, 1));
        }
        
        
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        public void mouseMoved(MouseEvent event) {}
    }
}
