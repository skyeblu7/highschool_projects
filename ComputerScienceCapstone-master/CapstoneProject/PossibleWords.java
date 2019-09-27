import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

// deals with splitting the large list of words into organized lists and finds the index of the given letter for the largest list of words
public class PossibleWords
{
    ArrayList<String> listOfPossibleWords;
    ArrayList<String> allWords;
    ArrayList<String> unguessedLetters;
    
    public PossibleWords(int letters) throws IOException
    {
        allWords = new ArrayList<String>();
        listOfPossibleWords = new ArrayList<String>();
        unguessedLetters = new ArrayList<String>();
        File txtFile = new File("words.txt");
        Scanner s = new Scanner(txtFile);
        s.useDelimiter("\n");
        // iterates through the large list and adds them to an arraylist to use
        while(s.hasNext())
        {
            allWords.add(s.next());
        }
        // adds all guessable letters
        for(int i = 97; i <= 122; i++)
        {
            unguessedLetters.add(Character.toString((char) i));
        }
        // puts all words with the specified length in the list
        for(String word : allWords)
        {
            if(word.length() == letters)
            {
                listOfPossibleWords.add(word);
            }
        }
    }
    
    // for guessing a letter, returns the indexs of the letter that has been guessed, -1 if not in the word. -2 if the guessed letter was already guessed
    public int[] guessLetter(String letter)
    {
        if(unguessedLetters.contains(letter))
        {

            //My attempt at dealing with repeating letters, it's not working
//             // sorts all relavent words into the format: [[["word1"],["indexOfLetter1", "indexOfLetter2"]],[["word2"],["indexOfLetter1"]],[["word3"],[]]]
//             ArrayList<ArrayList<ArrayList<String>>> wordsWithLetterIndexs = new ArrayList<ArrayList<ArrayList<String>>>();
//             // keeps tack of how many words have a certain number of the specified letter(kept track by the index number of the numOccuringLetters)
//             int[] numOccuringLetters = new int[10];
//             ArrayList<ArrayList<String>> organizedWords = new ArrayList<ArrayList<String>>();
//             
//             for(int i = 0; i < listOfPossibleWords.size(); i++)
//             {
//                 ArrayList<ArrayList<String>> wordInfo = new ArrayList<ArrayList<String>>();
//                 ArrayList<String> word = new ArrayList();
//                 ArrayList<String> indexs = new ArrayList();
//                 
//                 word.add(listOfPossibleWords.get(i));
//                 for(int j = 0; j < listOfPossibleWords.get(i).length(); j++)
//                 {
//                     if(Character.toString(listOfPossibleWords.get(i).charAt(j)).equals(letter))
//                     {
//                         indexs.add(j+"");
//                     }
//                 }
//                 numOccuringLetters[indexs.size()]++;
//                 
//                 wordInfo.add(word);
//                 wordInfo.add(indexs);
//                 wordsWithLetterIndexs.add(wordInfo);
//             }
//             
//             // goes through 
//             for(int j = 0; j < numOccuringLetters.length; j++)
//             {
//                 for(int i = 0; i < wordsWithLetterIndexs.size(); i++)
//                 {   
//                     if(wordsWithLetterIndexs.get(i).get(1).size() == j)
//                     {
//                         // deals with each case of repeating letters. 0 = zero instances of the specified letter, 1 = 1 instance of the specified letter, 2 = 2 intances of the specified letter, etc. 
//                         switch (j)
//                         {
//                             case 0:
//                             
//                             break;
//                             case 1:
//                             
//                             break;
//                             case 2:
//                             
//                             break;
//                             case 3:
//                             
//                             break;
//                             case 4:
//                             
//                             break;
//                             case 5:
//                             
//                             break;
//                             case 6:
//                             
//                             break;
//                             case 7:
//                             
//                             break;
//                             case 8:
//                             
//                             break;
//                             case 9:
//  
//                             break;
//                         }
//                     }
//                 }
//             }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            unguessedLetters.remove(letter);
            ArrayList<ArrayList<String>> noDoubleLetterWords = getListOfListsOfWords(letter);
            
            // finds the index of the largest list in the list of words without double letters
            int largest = 0;
            for(int i = 0; i < noDoubleLetterWords.size(); i++)
            {
                if(noDoubleLetterWords.get(i).size() > noDoubleLetterWords.get(largest).size())
                {
                    largest = i;
                }
                else if(noDoubleLetterWords.get(i).size() == noDoubleLetterWords.get(largest).size() && 
                        !(noDoubleLetterWords.get(i).size() == 0))
                {
                    if(!noDoubleLetterWords.get(i).get(0).contains(letter))
                    {
                        largest = i;
                    }
                }
            }
            
            // the largest of the lists is now the list of words that the user may or may not guess
            listOfPossibleWords = noDoubleLetterWords.get(largest);
            System.out.println(listOfPossibleWords);
            
            // retruns the index of the letter, -1 if the letter is not contained in the largest list
            if(noDoubleLetterWords.size()-1 == largest)
            {
                int[] index = {-1};
                return index;
            }
            else
            {
                int[] index = {largest};
                return index;
            }
        }
        else
        {
            int[] index = {-2};
            return index;
        }
    }
   
    // returns a list of lists of strings where the lists are organized by the letter position.
   public ArrayList<ArrayList<String>> getListOfListsOfWords(String letter)
   {
        ArrayList<ArrayList<String>> noDoubleLetterWords = new ArrayList<ArrayList<String>>();
            
        // goes through all indexes that the letter could be at
        for(int j = 0; j < listOfPossibleWords.get(0).length(); j++)
        {
             ArrayList<String> temp1 = new ArrayList<String>();
             // goes through every index of every word and adds the words that have the letter of interest into a temperary list, that is later added to a larger list of lists
             for(int i = 0; i < listOfPossibleWords.size(); i++)
             {
                 // if the letter at this index equals the letter of interest, count how many times the letter shows up in the word
                 if(Character.toString(listOfPossibleWords.get(i).charAt(j)).equals(letter))
                 {
                     // gets the index of the letters in the word that are the same as the letter we are looking for
                     ArrayList<Integer> index = new ArrayList<Integer>();
                     for(int k = 0; k < listOfPossibleWords.get(i).length(); k++)
                     {
                         if(Character.toString(listOfPossibleWords.get(i).charAt(k)).equals(letter))
                         {
                             index.add(k);
                         }
                     }
                     // if it only shows up once, just add it to the normal list
                     switch(index.size())
                     {
                        case 1:
                        temp1.add(listOfPossibleWords.get(i));
                        
                     }
                 }
             }
             noDoubleLetterWords.add(temp1);
        }
                    
        // finds all words that do not contain the specified letter
        ArrayList<String> temp1 = new ArrayList<String>();
        for(int i = 0; i < listOfPossibleWords.size(); i++)
        {
            if(!listOfPossibleWords.get(i).contains(letter))
            {
                temp1.add(listOfPossibleWords.get(i));
            }
        }
        noDoubleLetterWords.add(temp1);
        
        return noDoubleLetterWords;
   }
    
   // returns the letters that have not been guessed so far in the game.
    public ArrayList<String> getUnguessedLetters()
    {
        return unguessedLetters;
    }
    
    public String getWord()
    {
        return listOfPossibleWords.get((int)(Math.random()*listOfPossibleWords.size()));
    }
}