 

import java.util.Scanner;

public class Substrings
{
   public static void main(String[] args)
   {
       Scanner s = new Scanner(System.in);
       System.out.println("Enter a word: ");
       String word = s.next();
       
       int start = 0;
       int end = 1;
       while (start <= word.length()-1)
       {
           while (end <= word.length())
           {
              System.out.println(word.substring(start, end));
              end++;
           }
           start++;
           end = start + 1;
       }       
   }
}
