 

import java.util.Scanner;

public class CompareAdjacentValues
{
    public static void detectAdjacentDuplicates()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a series of number and a character to quit.\n");
        
        double input = scan.nextDouble();
        while(scan.hasNextDouble())
        {
            double previousInput = input;
            input = scan.nextDouble();
            
            if(previousInput == input)
            {
                System.out.println("You put in the same number twice, you idiot!");
            }
        }
    }
}
