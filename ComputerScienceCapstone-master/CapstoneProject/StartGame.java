import java.io.IOException;
import java.util.Scanner;

// starts the game
public class StartGame 
{
    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(System.in);
        
        // welcome message
        System.out.print("Welcome to Evil Hangman!\nEnter how long the word should be(less than 8, must be an integer): ");
        int letters = s.nextInt();
        String again = "y";
        
        // main game loop
        while(again.equals("y"))
        {
            // initializes UserOutput class and the HiddenWord class
            UserOutput msg = new UserOutput(letters);
            HiddenWord hidden = new HiddenWord(letters);
            
            // guessing/phase loop. continues until the user runs out of guesses or finds all the letters in the hidden word
            int phase = 0;
            while(!hidden.isFound() && phase < 6)
            {
                // prints the hanging man, the hidden word (with underscores to represend unguessed letters) and letters to choose from
                System.out.println(msg.getPhase(phase));
                System.out.println(hidden.toString() + "\n");
                System.out.print(msg.getChooseLetters());
                String guess = s.next();
                // gets the index of the letters in the hidden word, -1 if the letter is not in the hidden word. -2 if the user already guessed the letter
                int[] index = msg.guessLetter(guess);
                
                if(index[0] == -1)
                {
                    phase++;
                }
                else if(index[0] == -2)
                {
                    System.out.println(msg.getYouAlreadyGuessed());
                }
                else
                {
                    // puts in the letter at the index
                    hidden.setChar(index, guess);
                }
                
                // lose
                if(phase >= 6)
                {
                    System.out.println(msg.getPhase(phase));
                    System.out.println(hidden.toString() + "\n");
                    System.out.print("You lose! " + "The word was: " + msg.getWord() + "\n" + msg.getAgain());
                    again = s.next();
                    if(again.equals("y"))
                    {
                        System.out.print("How many letters? ");
                        letters = s.nextInt();
                    }
                    else
                    {
                        System.out.println("Goodbye, thank you for playing!");
                        System.exit(5);
                    }
                }
            }
            // win
            System.out.print("You win!\n" + msg.getAgain());
            again = s.next();
            if(again.equals("y"))
            {
                System.out.println("How many letters? ");
                letters = s.nextInt();
            }
            else
            {
                System.out.println("Goodbye, thank you for playing!");
                System.exit(5);
            }
        }
    }
}
