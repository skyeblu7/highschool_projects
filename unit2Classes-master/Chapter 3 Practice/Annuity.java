import java.util.Scanner;

/**
 * Write a description of class Annuity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Annuity
{
    /** description of instance variable x (add comment for each instance variable) */
    static double annu;
    static double a;
    static double b;
    static double c;

    /**
     * Default constructor for objects of class Annuity
     */
    public static String main(double intrest, double years, double value)
    {
        a = Math.pow((1+intrest),(years-1)) - 1;
        b = a/intrest;
        c = b/(a+1) + 1;
        annu = value * c;
        String str = String.format("%.2f", annu);
        return str;
    }
}
