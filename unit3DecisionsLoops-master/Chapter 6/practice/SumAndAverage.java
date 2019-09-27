 

import java.util.Scanner;

public class SumAndAverage
{
    
    public static double averageOfValues()
    {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        
        System.out.println("Enter a series of double or a character to quit.");
        
        while(scan.hasNextDouble())
        {
            double input = scan.nextDouble();
            sum += input;
            count++;
        }
        
        double average = 0;
        if (count > 0)
        {
            average = sum / count;
        }
        
        return average;
    }
    
}