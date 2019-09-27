package FractalTreeLab;

//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class FractalTree extends JPanel
{
   private int PANEL_WIDTH;
   private int PANEL_HEIGHT;
   
   private int current;
   
   private double START_X;
   private double START_Y;
   
   // COOL NUMBERS: (190, 2.0), (15, 2.0), 
   private final double THETA = Math.toRadians(15);
   private final double THETA_SCALE_FACTOR1 = 2;
   private final double THETA_SCALE_FACTOR2 = 1;
   private final double THETA_STARTING_ANGLE = Math.toRadians(90);

   private final double PHI = Math.toRadians(25);
   private final double PHI_SCALE_FACTOR1 = 1.25;
   private final double PHI_SCALE_FACTOR2 = 1;
   private final double PHI_STARTING_ANGLE = Math.toRadians(270);
   
   private final Color START_COLOR_TREE = new Color(91,48,5); // brown
   private final Color END_COLOR_TREE = new Color(18,134,18); // green
   
   private final double ZETA = Math.toRadians(191);
   private final double ZETA_SCALE_FACTOR1 = 2;
   private final double ZETA_SCALE_FACTOR2 = 1;
   private final double ZETA_STARTING_ANGLE = Math.toRadians(90);
   private final double ZETA_START_X;
   private final double ZETA_START_Y;
   
   private final Color END_COLOR_ZETA = new Color(0, 255, 255); // blue (the start color is hard-coded to white)
   
   private final double SIZE = 75;
   private final double SCALE_FACTOR = .8;
   
   
       
    
   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public FractalTree (int c,int width,int height)
   {
      current = c;
      setBackground (Color.black);
      PANEL_WIDTH = width;
      PANEL_HEIGHT = height;
      setPreferredSize (new Dimension(width, height));
      
      START_X = PANEL_WIDTH*(1/2.0);
      START_Y = PANEL_HEIGHT*(2/4.0);
      ZETA_START_X = START_X - 300;
      ZETA_START_Y = START_Y - 140;
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (double startX, double startY, double size, double startAngle, int order, Graphics2D g2, Color startColor, 
                             double theta, double angleScaleFactor1, double angleScaleFactor2, Color endColor)
   {
       
       g2.setColor(startColor);
       if (order == 0)
       {      
           
       }
       else
       {
            Color newColor;
            
            double newSize = size;
            int newOrder = order;
           
            double newRightStartX = startX + size*Math.cos(startAngle);
            double newRightStartY = startY - size*Math.sin(startAngle);
           
            newSize = size*SCALE_FACTOR;
            newOrder--;
         
            g2.draw(new Line2D.Double(startX, startY, newRightStartX, newRightStartY));
            
            if(order % 7 == 0)
            {
                newColor = endColor;
            }
            else
            {
                newColor = new Color(startColor.getRed() + (int)((endColor.getRed()-startColor.getRed())*(Math.pow(order,2)/850.0)),
                                     startColor.getGreen() + (int)((endColor.getGreen()-startColor.getGreen())*(Math.pow(order,2)/850.0)),
                                     startColor.getBlue() + (int)((endColor.getBlue()-startColor.getBlue())*(Math.pow(order,2)/850.0)));
            }
           
            drawFractal(newRightStartX, newRightStartY, newSize, startAngle - angleScaleFactor1*theta, newOrder, g2, 
                    newColor, theta, angleScaleFactor1, angleScaleFactor2, endColor);
            
            drawFractal(newRightStartX, newRightStartY, newSize, startAngle + angleScaleFactor2*theta, newOrder, g2, 
                    startColor, theta, angleScaleFactor1, angleScaleFactor2, endColor);
            
       }
   }

   
   
   
   
   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics g)
   {
      super.paintComponent (g);
      Graphics2D g2 = (Graphics2D) g;
      
      // Theta fractal
      drawFractal(START_X, START_Y, SIZE, THETA_STARTING_ANGLE, current, g2, 
                  START_COLOR_TREE, THETA, THETA_SCALE_FACTOR1, THETA_SCALE_FACTOR2, END_COLOR_TREE);
                  
      // Phi fractal
      drawFractal(START_X, START_Y, SIZE, PHI_STARTING_ANGLE, current, g2, 
                    START_COLOR_TREE, PHI, PHI_SCALE_FACTOR1, PHI_SCALE_FACTOR2, END_COLOR_TREE);
                    
      //Zeta fractal
      drawFractal(ZETA_START_X, ZETA_START_Y - SIZE, SIZE, ZETA_STARTING_ANGLE, current, g2, 
                    Color.white, ZETA, ZETA_SCALE_FACTOR1, ZETA_SCALE_FACTOR2, END_COLOR_ZETA);
             
   }

   
   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setCurrent(int c)
   {
       this.current = c;
    }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getCurrent()
   {
       return this.current;
    }
}
