 



/**
 * Write a description of class toStringTesting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class toStringTesting
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    /**
     * Default constructor for objects of class toStringTesting
     */
    public toStringTesting()
    {
        // initialise instance variables
        x = 0;
    }
    
    public void printPennies(int pennies)
    {
        double inDollars;
        String toString;
        inDollars = pennies;
        toString = "$" + inDollars/100;
        System.out.print(toString);
        
    }
}


