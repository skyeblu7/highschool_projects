 

import java.util.Random;
import java.util.Scanner;


public class MonteyCarlos
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        double total = 0; 
        double y = 0;
        
        System.out.print("Enter the min: ");
        double min = s.nextDouble();
        
        System.out.print("Enter the max: ");
        double max = s.nextDouble();
        
        System.out.print("Enter how many points will be used to estimate the area: ");
        int points = s.nextInt();
        
        for(int i = 0; i < points; i++ )
        {
            y = (max-min)*r.nextDouble() + min;
            
            total += y;
        }
        System.out.println("\nArea: "+(total/points)*(max-min)); 
        
        /*
         (total/points) = height (max-min) = base
         */ 
    }
}
