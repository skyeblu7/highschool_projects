public class DistanceConverter
{
    private double FEET_IN_YARDS = 3;
    private double INCHES_IN_FEET = 12;
    
    
    
   
   public static void main(String[] args)
   {
      double yards = 3.5;
      double feet = yards * 3;
      double inches = feet * 12;
      
      System.out.println(yards + "yards are" + feet + "feet");
      System.out.println(yards + "yards are" + inches + "inches");
   }
}