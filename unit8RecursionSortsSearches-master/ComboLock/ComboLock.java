package ComboLock;

import java.util.Scanner;

public class ComboLock
{
    private final int PASS1;
    private final int PASS2;
    private final int PASS3;
    private int currentNum = 0;
    private int timesTurned = 0;
    private int num1;
    private int num2;
    private int num3;
    private static  final Scanner s = new Scanner(System.in);
   public ComboLock(int secret1, int secret2, int secret3) {
       this.PASS1 = secret1;
       this.PASS2 = secret2;
       this.PASS3 = secret3;
    }
   public void reset() {
       this.currentNum = 0;
       this.timesTurned = 0;
    }
   public void turnLeft(int ticks) {
       if(currentNum + ticks > 39) {
           currentNum = currentNum + ticks - 40;
           timesTurned++;
           switch(timesTurned){
                case 2: num2 = currentNum;
            }
        }
       else {
           currentNum += ticks;
           timesTurned++;
           switch(timesTurned){
                case 2: num2 = currentNum;
            }
        }
    }
   public void turnRight(int ticks) {
       if(currentNum - ticks < 0) { 
           currentNum = currentNum - ticks + 40;
           timesTurned++;
           switch(timesTurned){
               case 1: num1 = currentNum;
               break;
               case 3: num3 = currentNum;
               break;
            }
        }
        else {
            currentNum -= ticks;
            timesTurned++;
            switch(timesTurned){
               case 1: num1 = currentNum;
               break;
               case 3: num3 = currentNum;
               break;
            }
        }
    }
   public boolean open() {
       if(num1 == PASS1 && num2 == PASS2 && num3 == PASS3){
           return true;
        }
       else {
           return false;
        }
    }
    
   public static void main(String[] args)
   {
       ComboLock lock = new ComboLock(1, 4, 39);
       boolean open = false;
       String again;
       
       while(!open) {
           lock.reset();
           System.out.print("How many ticks to the right? ");
           lock.turnRight(s.nextInt());
           System.out.println();
           System.out.print("How many ticks to the left? ");
           lock.turnLeft(s.nextInt());
           System.out.println();
           System.out.print("How many ticks to the right? ");
           lock.turnRight(s.nextInt());
           System.out.println();
           
           open = lock.open();
           if (open){
               System.out.print("Good job! You opened the lock!\n");
            }
           else {
               System.out.print("Invalid entry. The program will now exit.\n");
               return;
            }
            
           System.out.print("\nWould you like to guess again? ");
           again = s.next();
           System.out.print(again);
           if(again == "y"){
               open = !open;
            }
           else if(again == "n"){
               return;
            }
        }
	}
}

 
