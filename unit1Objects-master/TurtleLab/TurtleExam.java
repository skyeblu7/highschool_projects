import java.awt.Color;
public class TurtleExam
{
    public static void main(String[] args)
    throws InterruptedException
    {
        int num = 0;
        int num2 = 0;
        double angle = 0;
        double angle2 = 0;
        int distance = 0;
        double angleChange = 35; //the degrees by which the angle will change of the 1st turtle
        double angleChange2 = 2;
        int distanceChange = 2; 
        int maximum = 20; //number of triangles the 2nd turtle should make
        
        Color cyan = new Color(0, 255, 255);
        Color blue = new Color(0,0,255);
        Color yellow = new Color(245,253,11);
        Color red = new Color(255, 150, 150);
        Color green = new Color(0,255,0);
        
        World turtleWorld = new World();
        Turtle myFavTurtle = new Turtle(turtleWorld);
        Turtle myNonFavTurtle = new Turtle(turtleWorld);
        myFavTurtle.setColor(blue);
        myNonFavTurtle.setColor(cyan);
        
        myFavTurtle.forward(100);
        myNonFavTurtle.turn(180);
        myNonFavTurtle.forward(120);
        myNonFavTurtle.turn(270);
        myNonFavTurtle.forward(100);
        myNonFavTurtle.turn(270);
        myNonFavTurtle.clearPath();
        
        myFavTurtle.clearPath();
        while (num < (900)) {
            myFavTurtle.forward(15);
            myFavTurtle.turn(4 + angle);
            num += 1;
            angle = angle + angleChange; //every 15 pixels, the angle will change by this amount
            
            Thread.sleep(1);
        }
        
        while (num2 < maximum) {
            num2 += 1;
            
            myNonFavTurtle.forward(86);
            myNonFavTurtle.turn(151);
            myNonFavTurtle.forward(75);
            myNonFavTurtle.turn(120);
            myNonFavTurtle.forward(50);
            
            distance += distanceChange;
            angle2 += angleChange2;
            Thread.sleep(25);
        }
        
        num2 = 0;
        myNonFavTurtle.setColor(yellow);
        
        while (num2 < maximum) {
            num2 += 1;
            
            myNonFavTurtle.forward(86);
            myNonFavTurtle.turn(151);
            myNonFavTurtle.forward(75);
            myNonFavTurtle.turn(120);
            myNonFavTurtle.forward(50);
            
            distance += distanceChange;
            angle2 += angleChange2;
            Thread.sleep(25);
        }
        
        num2 = 0;
        myNonFavTurtle.setColor(red);
        
        while (num2 < maximum) {
            num2 += 1;
            
            myNonFavTurtle.forward(86);
            myNonFavTurtle.turn(151);
            myNonFavTurtle.forward(75);
            myNonFavTurtle.turn(120);
            myNonFavTurtle.forward(50);
            
            distance += distanceChange;
            angle2 += angleChange2;
            Thread.sleep(25);
        }
        
        num2 = 0;
        myNonFavTurtle.setColor(green);
        
        while (num2 < maximum) {
            num2 += 1;
            
            myNonFavTurtle.forward(86);
            myNonFavTurtle.turn(151);
            myNonFavTurtle.forward(75);
            myNonFavTurtle.turn(120);
            myNonFavTurtle.forward(50);
            
            distance += distanceChange;
            angle2 += angleChange2;
            Thread.sleep(25);
        }
    }
}