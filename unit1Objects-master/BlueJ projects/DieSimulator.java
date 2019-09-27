import java.util.Random;
public class DieSimulator
{
    public static void main(String[] args)
    throws InterruptedException
    {
        Random generator = new Random();
        double trial = 0;
        double threes = 0;
        double twos = 0;
        double ones = 0;
        double result = 0;
        while(trial < 10000)
        {
            result = generator.nextInt(3)+1;
            System.out.println(result);
            trial += 1;
            if(result == 3)
            {
                threes += 1;
            }
            else if(result == 2)
            {
                twos += 1;
            }
            else
            {
                ones += 1;
            }
            Thread.sleep(5);
        }
        
        System.out.println("Results:");
        System.out.println("1's: " + Double.toString(ones/10000));
        System.out.println("2's: " + Double.toString(twos/10000));
        System.out.println("3's: " + Double.toString(threes/10000));
    }
}