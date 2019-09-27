import java.util.Scanner;
import java.math.*;

/**
 * Write a description of class Epsilon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Epsilon
{
    // instance variables - replace the example below with your own
    private double EPSILON = 5e-9;
    static Scanner s = new Scanner(System.in); 
    static String str = "";
    static String num = "";
    
    
    static void main(String[] args)
    {
        System.out.print("Enter a number: ");
        num = s.next();
        while (Double.parseDouble(num) != Math.PI)
        {
            if (Double.parseDouble(num) > 0)
            {
                str = "Positive";
                if (Double.parseDouble(num) > 1000000)
                {
                    str += " and large";
                }
                else if (Double.parseDouble(num) < 1)
                {
                    str += " and small";
                }
                System.out.println(str+"\n");
            }
            
            else if (Double.parseDouble(num) < 0)
            {
                str = "Negative";
                if (Double.parseDouble(num) < -1000000)
                {
                    str += " and large";
                }
                else if (Double.parseDouble(num) > -1)
                {
                    str += " and small";
                }
                System.out.println(str+"\n");
            }
            else
            {
                System.out.println("Zero\n");
            }
            System.out.print("Enter a number: ");
            num = s.next();
        }
    }
}
