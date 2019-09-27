package practiceRecursion;

import java.util.ArrayList;

public class ListMethodsRunner
{
   public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(21);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
   }
}