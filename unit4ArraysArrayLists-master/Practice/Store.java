import java.util.ArrayList;
import java.util.Scanner;


public class Store
{
    ArrayList[][] customer = new ArrayList[][](); 
    Scanner s = new Scanner(System.in);
    
    public Store()
    {
        System.out.print("Name of customer: ");
        String name = s.next();
        System.out.println("Price: ");
        String price = s.next();
        
        addSale();
    }
    
    public void addSale(String customerName, double amount)
    {
        customer.add({customerName, (Double)amount});
    }
    
    public String nameOfBestCustomer()
    {
        int winner = 0;
        for(int i = 0; i < customer.size(); i++)
        {
            
        }
    }
}
