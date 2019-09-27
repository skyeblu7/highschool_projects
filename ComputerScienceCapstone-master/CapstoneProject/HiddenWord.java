


// deals with the hidden word
public class HiddenWord
{
    // the variable that stores initially a list of "_" to represent
    // unguessed letters
    private String[] hidden;
    
    // initiallizes the 'hidden' variable
    public HiddenWord(int length)
    {
        hidden = new String[length];
        for(int i = 0; i < hidden.length; i++)
        {
            hidden[i] = "_";
        }
    }
    
    // sets given positions of the 'hidden' variable to a given letter
    public void setChar(int[] index, String letter)
    {
        for(int i = 0; i < index.length; i++)
        {
            hidden[index[i]] = letter;
        }
    }
    
    // puts the 'hidden' variable into a usable string for the user to see
    public String toString()
    {
        String temp = "";
        for(String letter : hidden)
        {
            temp += letter + " ";
        }
        return temp;
    }
    
    // returns true if all of the letters in the 'hidden' variable are not "_"
    public boolean isFound()
    {
        for(String string : hidden)
        {
            if(string == "_")
            {
                return false;
            }
        }
        return true;
    }
}