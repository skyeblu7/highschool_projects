public class ConcatDemo
{
    public static void main(String[] args)
    {
        String animal1 = "quick brown fox ";
        String animal2 = "lazy dog";
        String article = "The ";
        String action = "jumps over ";
        
        String message = article.concat(animal1.concat(action).concat(article.toLowerCase()).concat(animal2).concat("."));
        
        System.out.println(message);
    }
}