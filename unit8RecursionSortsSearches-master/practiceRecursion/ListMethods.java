package practiceRecursion;

import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = new ArrayList<Integer>();
      tempList.add(n);
      if (n > 1)   // All other size lists are created here
      {
          tempList.addAll(0, makeList(n-1));
          return tempList;
      }
      else       // The smallest list we can make
      {
          return tempList;
      }
   }
   public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
   {
       
   }
   public static ArrayList<Integer> even(ArrayList<Integer> tList)
   {
       
   }
   public static ArrayList<Integer> odd(ArrayList<Integer> tList)
   {
       
   }
   public static ArrayList<Integer> merge(ArrayList<Integer> tList1, ArrayList<Integer> tList2)
   {
       
   }
   public static void main(String[] args)
   {
       System.out.println(makeList(10));
   }
}