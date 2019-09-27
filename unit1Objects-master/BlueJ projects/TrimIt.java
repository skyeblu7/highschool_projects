public class TrimIt
{
    public static void main(String[] args)
    {
        String sentence1 = "      abc   ";
        String sentence2 = "   def";
        String sentence3 = "ghi         ";
        
        /*my work goes here*/
        String message = sentence1.trim().concat(sentence2.trim().concat(sentence3.trim()));
        System.out.println(message);
    }
}