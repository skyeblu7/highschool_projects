 

import java.util.Random;

public class MontyHall
{
    public static void main(String[] args)
    {
        
        
        int strategy1 = 0;
        int strategy2 = 0;
        
        Random rand = new Random();

        while (strategy1/1000 != .333 & strategy2/1000 != .666)
        {
            
            strategy1 = 0;
            strategy2 = 0;
            
        for (int games = 0; games <= 1000; games++)
        {
            int choice = rand.nextInt(3) + 1;
            int carDoor = rand.nextInt(3) + 1;
            
            if (choice == carDoor)
            {
            strategy1++;
            }
        }
        System.out.println("Strategy 1: " + strategy1/1000.0 + "\n");
        
        for (int games = 0; games <= 1000; games++)
        {
            int choice = rand.nextInt(3) + 1;
            int carDoor = rand.nextInt(3) + 1;
            
            if (choice != carDoor)
            {
            strategy2++;
            }
        }
        System.out.println("Strategy 2: " + strategy2/1000.0);
    }
}

}
        
 