import java.util.Scanner;

public class IntWithComma
{
    private String num;
    private String numWOcomma;
    Scanner s = new Scanner(System.in);

    public IntWithComma()
    {
        System.out.print("Enter an integer between 1,000 and 999,999: ");
        num = s.next();
        numWOcomma = num.substring(0, num.length()-4) + num.substring(num.length()-3, num.length());
        System.out.println(numWOcomma);
        
    }

}
