
/**
 * Write a description of class String_Compare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class String_Compare
{
    // instance variables - replace the example below with your own
    static String word1 = "catalog";
    static String word2 = "cat";

    static void main(String[] args)
    {
        if (word1.compareTo("aaa") > 0)
        {
            System.out.println("word1 is greater than 'aaa'\n");
        }
        if (word1.equals(word2))
        {
            System.out.println("word1 is equal to word2\n");
        }
        if (word1.compareTo(word2) < 0)
        {
            System.out.println("word1 is less than word2\n");
        }
        if (word1.substring(0,3).equals(word2.substring(0,3)))
        {
            System.out.println("word1 and word2 have the same 3 letter prefix");
        }
    }
}
