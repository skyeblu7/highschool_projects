 

import java.util.Random;


public class DrunkardWalk
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < 1000; i++)
        {
            switch(rand.nextInt(4)+1)
            {
                case 1:
                x += 1;
                break;
                case 2:
                y += 1;
                break;
                case 3:
                x -= 1;
                break;
                case 4:
                y -= 1;
                break;
            }
        }
        System.out.println(x + " " + y);
    }
}
