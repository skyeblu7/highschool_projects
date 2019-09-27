import java.util.ArrayList;
import java.awt.Color;


/**
 * creates n number of windows
 * 
 * @author kristopher k
 * @version 10/11/15
 */
public class ListOfWindows
{
    private int n; // the number of windows that will be created
    private int x;
    private int y;
    private int width;
    private int height;
    private ArrayList<Window> windows = new ArrayList<Window>(n);
    
    /**
     * Constructor for objects of class ListOfObjects
     */
    public ListOfWindows(int n, int x, int y, int width, int height, Color color)
    {
        Window wN = new Window(x,y,width,height,color);
        System.out.print(n);
        
        for(int i = 0; i < n; i++) 
        {
           Window w = new Window(wN.getX(),wN.getY(),wN.getWidth(),wN.getHeight(),wN.getColor());
           windows.add(w);
           wN.setY(wN.getY()+height+4);
        }
    }

    /**
     * returns the objects as an arraylist
     *
     * @param  none
     * @return     the objects as an arraylist
     */
    public ArrayList getList()
    {
        return windows;
    }

}
