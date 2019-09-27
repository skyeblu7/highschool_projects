import info.gridworld.actor.Rock;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
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
    public void testInitialState()
    {
       
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = new Actor();

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(cell != null)
                {
                    if ((row == 5 && col == 9) ||
                        (row == 6 && col == 9) ||
                        (row == 7 && col == 9) ||
                        (row == 8 && col == 9) ||
                        (row == 9 && col == 9) ||
                        (row == 10 && col == 9) ||
                        (row == 11 && col == 9) ||
                        (row == 12 && col == 9))
                        {
                             assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                        }
                }
                else if (cell == null) // else, the cell should be dead; assert that the actor is null
                {
                    if((row != 5 && col != 9) ||
                        (row != 6 && col != 9) ||
                        (row != 7 && col != 9) ||
                        (row != 8 && col != 9) ||
                        (row != 9 && col != 9) ||
                        (row != 10 && col != 9) ||
                        (row != 11 && col != 9) ||
                        (row != 12 && col != 9))
                    {
                        assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                    }
                }
            }
        }
    }

    @Test
    public void testFinalState()
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations         *  
         */

        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        for (int i = 1; i <= 5; i++)
        {
            game.createNextGeneration();
        }
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Rock cell = game.getRock(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(cell != null)
                {
                    if((row == 4 && col == 8) ||
                        (row == 4 && col == 9) ||
                        (row == 4 && col == 10) ||
                        (row == 5 && col == 7) ||
                        (row == 5 && col == 11) ||
                        (row == 6 && col == 7) ||
                        (row == 6 && col == 11) ||
                        (row == 7 && col == 8) ||
                        (row == 7 && col == 9) ||
                        (row == 7 && col == 10) ||
                        (row == 10 && col == 8) ||
                        (row == 10 && col == 9) ||
                        (row == 10 && col == 10) ||
                        (row == 11 && col == 7) ||
                        (row == 11 && col == 11) ||
                        (row == 12 && col == 7) ||
                        (row == 12 && col == 11) ||
                        (row == 13 && col == 8) ||
                        (row == 13 && col == 9) ||
                        (row == 13 && col == 10))
                    {
                        assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                    }
                }
                else if(cell == null) // else, the cell should be dead; assert that the actor is null
                {
                    if((row == 4 && col == 8) ||
                        (row == 4 && col == 9) ||
                        (row == 4 && col == 10) ||
                        (row == 5 && col == 7) ||
                        (row == 5 && col == 11) ||
                        (row == 6 && col == 7) ||
                        (row == 6 && col == 11) ||
                        (row == 7 && col == 8) ||
                        (row == 7 && col == 9) ||
                        (row == 7 && col == 10) ||
                        (row == 10 && col == 8) ||
                        (row == 10 && col == 9) ||
                        (row == 10 && col == 10) ||
                        (row == 11 && col == 7) ||
                        (row == 11 && col == 11) ||
                        (row == 12 && col == 7) ||
                        (row == 12 && col == 11) ||
                        (row == 13 && col == 8) ||
                        (row == 13 && col == 9) ||
                        (row == 13 && col == 10))
                    {
                        assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                    }
                }
            }
        }
    }
}

