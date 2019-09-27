import java.util.Arrays;


public class ArrayOperations
{
    public static void main(String[] args)
    {
        double x[] = {8, 4, 5, 21, 7, 9, 18, 2, 100};
        
        System.out.print("Number of Items: " + x.length + "\n\n");
        
        System.out.print("The first item: " + x[0]);
        
        System.out.print("\n\nThe last item: " + x[x.length-1]);
        
        System.out.print("\n\nIndex x[x.length-1]: " + x[x.length-1] + "\n\n"); // because the last index is always one less than the number of elements in the array
        
        for (int i = 0; i < x.length; i++)
        {
            System.out.println(x[i]);
        }

    }
}


