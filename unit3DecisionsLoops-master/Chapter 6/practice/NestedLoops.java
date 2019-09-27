 




public class NestedLoops
{
    public static void main(String[] args)
    {
        int outer = 1;
        int inner = 1;
        while (outer < 3)
        {
            while (inner < 5)
            {
                System.out.println(outer + " " + inner);
                inner++;
            }
            outer++;
            inner = 1;
        }
        
        
        
        for(outer = 1; outer <= 2; outer++)
        {
            for (inner = 1; inner <=4; inner++)
            {
                System.out.println(outer + " " + inner);
            }
        }
    }
}
