 

import java.util.Scanner;

public class CircleOverlap
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble(); 
      System.out.print("\nEnter the x-coordinate of the first circle ");
      double xcenter1 = in.nextDouble();
      System.out.print("\nEnter the y-coordinate of the first circle ");
      double ycenter1 = in.nextDouble();
      
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble();
      System.out.print("\nEnter the x-coordinate of the second circle ");
      double xcenter2 = in.nextDouble();
      System.out.print("\nEnter the y-coordinate of the second circle ");
      double ycenter2 = in.nextDouble();
      
      double distance = Math.sqrt(Math.pow(xcenter2-xcenter1,2)+Math.pow(ycenter2-ycenter1,2));

      if(radius1+radius2 < distance)
      {
          System.out.println("\nThe circles are disjoint");
      }
       else if(radius1 > radius2 & radius1 > distance+radius2 || radius2 > radius1 & radius2 > distance+radius1)
      {
           System.out.println("\nThe circles are mutually contained");
      }
     //  else if(Math.abs((radius1+radius2)-(distance)) < 1e-7 ) || (radius1+radius2) > distance)  radius1 > radius2 & Math.abs((distance+radius2) - radius1) < 1e-7 || radius2 > radius1 & Math.abs((distance+radius1) - radius2) < 1e-7))
    //  {
    //       System.out.println("\nThe circles are overlapping");
     // }
        
   }
}