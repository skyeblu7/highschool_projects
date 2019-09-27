import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * The building class that all buildings will be made from in the
 * cityscape.
 * 
 * @author Kristopher K
 * @version 10/11/2015
 */
public class Building2D
{
    private int x;
    private int y;
    private int height;
    private int width;
    private int buildingHeight;
    private int buildingWidth;
    private Color buildingColor;
    private int windowHeight;
    private int windowWidth;
    private Color windowColor;
    private int k; //distance from outside building to window horizontally
    private int i; //distance between windows horizontally
    private int l; //distance from outisde building to window veritcally
    private int m; //distance between window horizontally
    
    public Building2D(int xc, int yc, int w, int h, Color bc, int wH, int wW, Color wc)
    {
        x = xc;
        y = yc;
        width = w;
        height = h;
        buildingHeight = y+height; 
        buildingWidth = x+width;
        buildingColor = bc;
        windowHeight = wH;
        windowWidth = wW;
        windowColor = wc;
        k = 5;
        i = 5;
        l = 5;
        m = 5;
    }
    /**
     * This method draws the building in the frame
     * 
     * @param  g2   The graphics object that allows me to make graphics
     * @return     none 
     */
    public void draw(Graphics2D g2)
    {
        g2.setColor(buildingColor);
        Rectangle building = new Rectangle(x, y, width, height);
        g2.fillRect(x,y,width,height);
        
        Window w0 = new Window(x+k + (i+windowWidth)*0,y+l + (m+windowHeight)*0,windowWidth,windowHeight,windowColor);
        Window w1 = new Window(x+k + (i+windowWidth)*1,y+l + (m+windowHeight)*0,windowWidth,windowHeight,windowColor);
        Window w2 = new Window(x+k + (i+windowWidth)*2,y+l + (m+windowHeight)*0,windowWidth,windowHeight,windowColor);
        Window w3 = new Window(x+k + (i+windowWidth)*3,y+l + (m+windowHeight)*0,windowWidth,windowHeight,windowColor);
        Window w4 = new Window(x+k + (i+windowWidth)*4,y+l + (m+windowHeight)*0,windowWidth,windowHeight,windowColor);
        
        Window w5 = new Window(x+k + (i+windowWidth)*0,y+l + (m+windowHeight)*1,windowWidth,windowHeight,windowColor);
        Window w6 = new Window(x+k + (i+windowWidth)*1,y+l + (m+windowHeight)*1,windowWidth,windowHeight,windowColor);
        Window w7 = new Window(x+k + (i+windowWidth)*2,y+l + (m+windowHeight)*1,windowWidth,windowHeight,windowColor);
        Window w8 = new Window(x+k + (i+windowWidth)*3,y+l + (m+windowHeight)*1,windowWidth,windowHeight,windowColor);
        Window w9 = new Window(x+k + (i+windowWidth)*4,y+l + (m+windowHeight)*1,windowWidth,windowHeight,windowColor);
        
        Window w10 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*2,windowWidth,windowHeight,windowColor);
        Window w11 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*2,windowWidth,windowHeight,windowColor);
        Window w12 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*2,windowWidth,windowHeight,windowColor);
        Window w13 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*2,windowWidth,windowHeight,windowColor);
        Window w14 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*2,windowWidth,windowHeight,windowColor);
        
        Window w15 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*3,windowWidth,windowHeight,windowColor);
        Window w16 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*3,windowWidth,windowHeight,windowColor);
        Window w17 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*3,windowWidth,windowHeight,windowColor);
        Window w18 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*3,windowWidth,windowHeight,windowColor);
        Window w19 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*3,windowWidth,windowHeight,windowColor);
        
        Window w20 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*4,windowWidth,windowHeight,windowColor);
        Window w21 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*4,windowWidth,windowHeight,windowColor);
        Window w22 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*4,windowWidth,windowHeight,windowColor);
        Window w23 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*4,windowWidth,windowHeight,windowColor);
        Window w24 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*4,windowWidth,windowHeight,windowColor);
        
        Window w25 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*5,windowWidth,windowHeight,windowColor);
        Window w26 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*5,windowWidth,windowHeight,windowColor);
        Window w27 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*5,windowWidth,windowHeight,windowColor);
        Window w28 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*5,windowWidth,windowHeight,windowColor);
        Window w29 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*5,windowWidth,windowHeight,windowColor);
        
        Window w30 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*6,windowWidth,windowHeight,windowColor);
        Window w31 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*6,windowWidth,windowHeight,windowColor);
        Window w32 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*6,windowWidth,windowHeight,windowColor);
        Window w33 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*6,windowWidth,windowHeight,windowColor);
        Window w34 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*6,windowWidth,windowHeight,windowColor);
        
        Window w35 = new Window(x+k +(i+windowWidth)*0,y+l + (m+windowHeight)*7,windowWidth,windowHeight,windowColor);
        Window w36 = new Window(x+k +(i+windowWidth)*1,y+l + (m+windowHeight)*7,windowWidth,windowHeight,windowColor);
        Window w37 = new Window(x+k +(i+windowWidth)*2,y+l + (m+windowHeight)*7,windowWidth,windowHeight,windowColor);
        Window w38 = new Window(x+k +(i+windowWidth)*3,y+l + (m+windowHeight)*7,windowWidth,windowHeight,windowColor);
        Window w39 = new Window(x+k +(i+windowWidth)*4,y+l + (m+windowHeight)*7,windowWidth,windowHeight,windowColor);
        
        w0.draw(g2);
        w1.draw(g2);
        w2.draw(g2);
        w3.draw(g2);
        w4.draw(g2);
        w5.draw(g2);
        w6.draw(g2);
        w7.draw(g2);
        w8.draw(g2);
        w9.draw(g2);
        w10.draw(g2);
        w11.draw(g2);
        w12.draw(g2);
        w13.draw(g2);
        w14.draw(g2);
        w15.draw(g2);
        w16.draw(g2);
        w17.draw(g2);
        w18.draw(g2);
        w19.draw(g2);
        w20.draw(g2);
        w21.draw(g2);
        w22.draw(g2);
        w23.draw(g2);
        w24.draw(g2);
        w25.draw(g2);
        w26.draw(g2);
        w27.draw(g2);
        w28.draw(g2);
        w29.draw(g2);
        w30.draw(g2);
        w31.draw(g2);
        w32.draw(g2);
        w33.draw(g2);
        w34.draw(g2);
        w35.draw(g2);
        w36.draw(g2);
        w37.draw(g2);
        w38.draw(g2);
        w39.draw(g2);
        
        
    }
    /**
     * Returns the width of the building
     * 
     * @param  none
     * @return     The width of the building 
     */
    public int getWidth()
    {
        return buildingWidth;
    }
    /**
     *returns the height of the building
     * 
     * @param  none
     * @return     The height of the building
     */
    public int getHeight()
    {
        return buildingHeight;
    }
}
