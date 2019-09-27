

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class VendingTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VendingTest
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    /**
     * Default constructor for objects of class VendingTest
     */
    public VendingTest()
    {
        // initialise instance variables
        x = 0;
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    
    @Test
    public void testFill()
    {
        Vending machine = new Vending();
        machine.fillUp(50);
        assertEquals(60, machine.getCanCount());
    }
   
    @Test
    public void testToken()
    {
        Vending machine = new Vending();
        machine.insertCoin();
        assertEquals(1, machine.getCoinCount());

    }
    
}
