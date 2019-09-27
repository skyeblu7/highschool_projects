 

import java.util.Scanner;

/**
 * Write a description of class LeapYear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeapYear
{
    static Scanner s = new Scanner(System.in);
    static double year = 0;
    
    public static void main(String[] args)
    {
        System.out.print("\t\t\tTo be or not to be a Leap-Year\n\n");
        System.out.print("Enter a year: ");
        year = s.nextDouble();
        
        if (Math.abs(0 - year%4) < 1e-8  & !(Math.abs(0 - year%100) < 1e-8) || Math.abs(0 - year%400) < 1e-8)
        {
            System.out.println("\nThis is a Leap year");
        }
        else
        {
            System.out.println("\nThis is not a Leap year");
        }
    }
    
}
