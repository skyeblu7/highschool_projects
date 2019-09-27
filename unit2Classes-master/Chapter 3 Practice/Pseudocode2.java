import java.util.Scanner;

/**
 * Gives change to customer
 * 
 * @author  Kristopher
 * @version 10/1/2015
 */
public class Pseudocode2
{
    private double amountDue;
    private double amountGiven;
    private double change;
    private int dollars;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennys;
    private Scanner s = new Scanner(System.in);
    
    public Pseudocode2()
    {
        System.out.print("Enter the amount you need to pay: ");
        amountDue = s.nextDouble();
        System.out.print("Enter the amount you are giving: ");
        amountGiven = s.nextDouble();
        
        change = amountGiven - amountDue;
        
        /*
        dollars = (int) (change / 100);
        change = (float) (change - dollars*100);
        
        quarters = (int) (change / 25);
        change = (float) (change - quarters*25);
        
        dimes = (int) (change / 10);
        change = (float) (change - dimes*10);
            
        nickels = (int) (change / 5);
        change = (float) (change - nickels*5);
            
        pennys = (int) (change / 1);
        change = (float) (change - pennys*1);
        */
        
       
       
        if (change < 0)
        {
            System.out.println("You do not have enough money");
            while (change < 0)
            {
                System.out.print("Please enter " + (int) amountDue + " or more: ");
                amountGiven = s.nextDouble();
                change = amountGiven - amountDue;
            }
        }
        if (change / 100 >= 1)
        {
            dollars = (int) (change / 100);
            change = (float) (change - dollars*100);
        }
        if (change / 25 >= 1)
        {
            quarters = (int) (change / 25);
            change = (float) (change - quarters*25);
        }
        if (change / 10 >= 1)
        {
            dimes = (int) (change / 10);
            change = (float) (change - dimes*10);
        }
        if (change / 5 >= 1)
        {
            nickels = (int) (change / 5);
            change = (float) (change - nickels*5);
        }
        if (change / 1 >= 1)
        {
            pennys = (int) (change / 1);
            change = (float) (change - pennys*1);
        }
        
        
        System.out.println("\n\tChange\nDollars: " + dollars + "\nQuarters: " + 
        quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + 
        "\nPennys: " + pennys);
    }
}
