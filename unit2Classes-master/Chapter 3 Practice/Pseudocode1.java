import java.util.Scanner;

public class Pseudocode1
{
    Scanner s = new Scanner(System.in);
    String num;
    String first3;
    String second3;
    String last4;
    
    public Pseudocode1()
    {
        System.out.print("Enter a 10-digit phone number: ");
        num = s.next();
        first3 = num.substring(0,3);
        second3 = num.substring(3,6);
        last4 = num.substring(6,10);
        System.out.print("(" + first3 + ") " + second3 + "-" + last4);
    }
}
