import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarTest. Makes sure the Radar class is working correctly
 *
 * @author  Kristopher
 * @version 12/16/2015
 */
public class RadarTest
{
    /**
     * To make sure the code works
     */
    @Test
    public void testRadar1()
    {
        Radar notRadar = new Radar(100,100);
        
        notRadar.setMonsterLocations(50,50, 75, 75);
        
        for(int i = 0; i < 50; i++)
        {
            notRadar.scan();
        }
                
        assertEquals(notRadar.getNumScans(), notRadar.getAccumulatedDetection(50,50));
        assertEquals(notRadar.getNumScans(), notRadar.getAccumulatedDetection(75,75));
    }
    /**
     * To make sure the test still works even if the last test was a false positive
     */
    @Test
    public void testRadar2()
    {
        Radar notRadar = new Radar(100,100);
        
        notRadar.setMonsterLocations(76,69, 1, 1);
        
        for(int i = 0; i < 100; i++)
        {
            notRadar.scan();
        }
                
        assertEquals(notRadar.getNumScans(), notRadar.getAccumulatedDetection(76,69));
        assertEquals(notRadar.getNumScans(), notRadar.getAccumulatedDetection(1,1));
    }
}
