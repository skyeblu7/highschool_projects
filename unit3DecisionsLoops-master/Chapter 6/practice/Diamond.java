 

import java.util.Scanner;


public class Diamond
{
   public static void main(String[] args)
   {
       Scanner s = new Scanner(System.in);
       System.out.print("Enter the size of the diamond: ");
       int size = s.nextInt();
       int totalChars = size*2-1;
       int stars = 1;
       
       for (int j = 1; j <= size+1; j++)
       {
           for(int i = 1; i < size;i++  )
           {
               System.out.print(" ");
           }
           for(int k = 0; k < stars; k++)
           {
               System.out.print("*");
           }
           System.out.println("");
           stars += 2;
           size -= 1;
       }
       for (int j = 1; j <= size+1 & stars >= 0; j++)
       {
           for(int i = 1; i < size; i++ )
           {
               System.out.print(" ");
           }
           for(int k = 0; k < stars; k++)
           {
               System.out.print("*");
           }
           System.out.println("");
           stars -= 2;
           size += 1;
       }
   }
}

