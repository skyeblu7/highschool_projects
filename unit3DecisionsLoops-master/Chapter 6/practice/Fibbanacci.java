 


import java.util.Scanner;

public class Fibbanacci
{
   public static void main(String[] args)
   {
        int first = 1;
        int next = 1;
        Scanner s = new Scanner(System.in);
        
        System.out.print("To what term do you want to see the Fibbanacci Sequence? ");
        int term = s.nextInt();
        
        for(int i = 1; i <= term;i++)
        {
            if (i%2 != 0)
            {
                System.out.println(first);
                first += next;
            }
            else
            {
                System.out.println(next);
                next += first;
            }
        }
    }
}
