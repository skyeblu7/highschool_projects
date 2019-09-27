package PalindromeTester;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
   public static void main (String[] args)
   {
      String str, newStr = "", another = "y";
      int left, right;
      Scanner s = new Scanner(System.in);
      
      while (another.equalsIgnoreCase("y")) // allows y or Y
      {
         System.out.println ("Enter a potential palindrome:");
         str = s.nextLine();
         newStr = "";
         
         char[] stuffWeDontWant = {' ', '\'', ':', '.', ',', '/', '"', '!', '?', '\\', '-', ';', '{', '}', '[', ']', '_', '+', '=', '|', '&', '*', '(', ')', '^', '%', '$', '#', '@', '`', '~', '<', '>', '“', '”', '’'};

         
         int i = 0;
         while (i < str.length())
         {
             if(contains(stuffWeDontWant, str.charAt(i)))
             {
                 i++;
                 continue;
             }
             else
             {
                 newStr += Character.toString(str.charAt(i));
             }
             i++;
         }
         
         newStr = newStr.toLowerCase();
         
         if(isPalindrome(newStr) == true)
         {
            System.out.println("that string IS a palindrome");
         }
         else
         {  
             System.out.println("That string is NOT a palindrome.");
         }
            
         System.out.println();
         System.out.print ("Test another palindrome (y/n)? ");
         another = s.nextLine();
      }  
   }
   
   public static boolean contains(char[] list, char key)
   {
       for(char c : list)
       {
           if(c == key)
           {
               return true;
            }
       }
       return false;
   }
   
   public static boolean isPalindrome(String str)
   {
       if (str.length() <= 1)
       {
           return true;
       }
       String substr = str.substring(1, str.length() - 1);
        
       return ((str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(substr));
   }
}

