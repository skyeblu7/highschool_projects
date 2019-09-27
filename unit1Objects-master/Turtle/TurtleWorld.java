import java.awt.Color;

public class TurtleWorld
{
    public static void main(String[] args)
    throws InterruptedException
    {
        {
            Thread.sleep(1);
        }
    
        int num;
        double angle;
        World turtleWorld = new World();
        Turtle turtle = new Turtle(turtleWorld);
        //turtle.turn(90);
        //turtle.forward(100);
        turtle.clearPath();
        num = 0;
        angle = 0;
        while (num < (900)) {
            turtle.forward(15);
            turtle.turn(4 + angle);
            num += 1;
            angle = angle + 2;
            Thread.sleep(5);
        }
        //turtle.forward(100);
        //turtle.turn(10);
        //turtle.forward(200);
        
    }

}