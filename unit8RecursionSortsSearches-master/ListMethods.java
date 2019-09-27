import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      if (n <= 0)  // The smallest list we can make
      {
          return new ArrayList<Integer>();
      }
      else        // All other size lists are created here
      {
          ArrayList<Integer> list = new ArrayList<Ineger>(n);
          return tempList = makeList(list.get(0));
          
      }
      return tempList;
   }
   
   public static void main(Stirng[] args)
   {
       makeList(5);
   }
}