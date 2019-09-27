


public class BillfoldTester
{
   public static void main(String[] args)
   {
       Billfold cards = new Billfold();
       cards.addCard(new Card("Kris"));
       cards.addCard(new Card("NotKris"));
       
       System.out.print(cards.formatCards());
   }
}
