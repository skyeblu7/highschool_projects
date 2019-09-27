import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

public class RandDistribution
{ 
  public static void main()
  {
      Scanner s = new Scanner(System.in);
      System.out.print("How many rolls? ");
      int rolls = s.nextInt();
      System.out.print("How many sides on die? ");
      int sides = s.nextInt();
      
      int die[] = new int[sides];
      
      for(int i = 0; i < rolls; i++)
      {
          int num = (int)(Math.random()*10);
          die[num] += 1;
      }
      
      System.out.println();
      
      for(int i = 0; i < die.length; i++)
      {
          System.out.println(i + ": " + die[i]);
      }
      
  }
}
