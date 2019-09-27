import java.io.IOException;
import java.util.ArrayList;

// deals with most things that the user sees while playing the game
public class UserOutput {
    // All possible phases of the hanging man in order (index 0 = first phase, index 6 is the last)
    private final String[] hang = {"      _______   \n     |       |\n     |\n     |\n     |\n     |\n     |\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       \n     |\n     |\n     |\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       |\n     |       |\n     |       |\n     |\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       |\n     |       |\n     |       |\n     |      /\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       |\n     |       |\n     |       |\n     |      / \\\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       |\n     |      /|\n     |       |\n     |      / \\\n_____|_____ \n",
            "      _______ \n     |       |\n     |      ( )\n     |       |\n     |      /|\\\n     |       |\n     |      / \\\n_____|_____ \n"}; 
    private PossibleWords process;
    
    // constructs the process variable
    public UserOutput(int length) throws IOException
    {
       process = new PossibleWords(length);
    }
    // returns the appropriate hanging man phase based on the entered index
    public String getPhase(int index)
    {
        return hang[index];
    }
    // when the game ends, asks if the player would like to play again.
    public String getAgain()
    {
        return "Would you like to play again?(y/n): ";
    }
    // returns the list of unused letters and the message prompting the user to choose a letter
    public String getChooseLetters()
    {
        return process.getUnguessedLetters() + "\n\nChoose a letter: ";
    }
    // runs the PossibleWords method for guessLetter
    public int[] guessLetter(String letter)
    {
        return process.guessLetter(letter);
    }
    // returns the string below. used if the user guesses a letter that has been guessed already
    public String getYouAlreadyGuessed()
    {
        return "You already guessed that letter!";
    } 
    
    public String getWord()
    {
        return process.getWord();
    }
}
