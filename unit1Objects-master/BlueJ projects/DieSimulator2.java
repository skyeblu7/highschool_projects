import java.util.Random;
public class DieSimulator2
{
    public static void main(String[] args)
    throws InterruptedException
    {
        // Option A
        Random generator = new Random();
        int dieValue = generator.nextInt(6);
        dieValue += 1;
        System.out.println(dieValue);
        
        // Option B
        double dieValue2 = Math.random(); //returns [0,1)
        dieValue2 *= 6; // returns [0,6)
        dieValue2 += 1;  // returns [1,7)
        System.out.println(dieValue2);
    }
}