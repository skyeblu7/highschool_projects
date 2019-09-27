import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/*
 *  Write a program that asks the user for a file 
 *  name and prints the number of characters, words, 
 *  and lines in that file.
 */
public class WC
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File manifesto = new File("Manifesto.txt");
        Scanner s = new Scanner(manifesto);
        s.useDelimiter(" ");
        int words = 0;
        
        while(s.hasNext())
        {
            // System.out.println(s.next());
            words++;
        }
        
        System.out.println(words);
        s.close();
    }
}
