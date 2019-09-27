import java.util.Scanner;

public class Rectangle
{
    Scanner s = new Scanner(System.in);
    double area;
    double perimeter;
    double diagonal;
    
    public Rectangle()
    {
        System.out.print("Enter the length: ");
        double length = s.nextDouble();
        System.out.print("Enter the width: ");
        double width = s.nextDouble();
        
        area = length*width;
        perimeter = 2*length + 2*width;
        diagonal = Math.sqrt(Math.pow(length,2)+Math.pow(width,2));
        
        System.out.print("\nArea: " + area + "\nPerimeter: " + perimeter + "\nDiagonal: " + diagonal);
    }
}