
/**
 * Write a description of class Vending here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vending
{
    // instance variables - replace the example below with your own
    private int MAX_CANS = 200;
    private int totalCans;
    private int coins;

    /**
     * Constructor for objects of class Vending
     */
    public Vending()
    {
        // initialise instance variables
        this.totalCans = 10;
        this.coins = 0;
        
    }
    
    public Vending(int startCans)
    {
        this.totalCans = startCans;
        this.coins = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void insertCoin()
    {
        if (totalCans > 0)
        {
            this.totalCans--;
            this.coins++;
        }
        else
        {
            System.out.println("Out of cans, sorry.");
        }
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void fillUp(int cans)
    {
        // put your code here
        if (cans + totalCans > MAX_CANS)
        {
            System.out.println("Can't fit that many cans in the machine.");
        }
        else if (cans < 0)
        {
            System.out.println("Can't put negative cans in.");
        }
        else
        {
            this.totalCans += cans;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int getCanCount()
    {
        // put your code here
        return this.totalCans;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int getCoinCount()
    {
        // put your code here
        return this.coins;
    }

}

