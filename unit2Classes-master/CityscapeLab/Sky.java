import java.awt.Color;

/**
 * does the day/night cycle
 * 
 * @author kris k 
 * @version 10/11/15
 */
public class Sky
{
    private int day = 1;
    private int night = 0;
    private int time = night;
    private int r1 = 80, g1 = 150, b1 = 250; //day
    private int r0 = 15, g0 = 15, b0 = 80; //night
    private int r = r1, g = g1, b = b1;
    private int dayFrame = 0, dayTime = 700;
    private int changeFrame = 0, changeTime = 1;
    private Color color = Color.CYAN;

    /**
     * Constructor for objects of class Sky
     */
    public Sky()
    {
        day = 1;
        night = 0;
        time = night;
        r1 = 80 ;
        g1 = 150;
        b1 = 250; //day
        r0 = 15;
        g0 = 15;
        b0 = 80; //night
        r = r1;
        g = g1;
        b = b1;
        dayFrame = 0;
        dayTime = 700;
        changeFrame = 0;
        changeTime = 1;
        color = Color.CYAN;

        if(time == day)
        {
            r = r1;
            g = g1;
            b = b1;
        }
        else if(time == night)
        {
            r = r0;
            g = g0;
            b = b0;
        }
    }
    
        /**
         * changes the color of the sky
         *
         * @param  none
         * @return     none
         */
        public void tick()
        {
        if (dayFrame >= dayTime)  
        {
            if(time == day)
            {
                time = night;
            }
            else if (time == night)
            {
                time = day;
            }
            dayFrame = 0;
        }
        else
        {
            dayFrame += 1;
        }
        if (changeFrame >= changeTime)
        {
            if (time == day)
            {
                if (r > r0)
                {
                    r -= 1;
                }
                if (g > g0)
                {
                    g -= 1;
                }
                if (b > b0)
                {
                    b -= 1;
                }
            }
            if (time == night)
            {
                if (r < r1)
                {
                    r += 1;
                }
                if (g < g1)
                {
                    g += 1;
                }
                if (b < b1)
                {
                    b += 1;
                }
            }
            changeFrame = 0;
        }
        else
        {
            changeFrame += 1;
        }
        
        color = new Color(r, g, b);
    }
    

    /**
     * returns the color that the sky should be
     *
     * @param  none
     * @return     the sum of x and y
     */
    public Color getSkyColor()
    {
       return color;
    }
}
