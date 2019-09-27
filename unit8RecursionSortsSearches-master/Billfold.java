
public class Billfold
{
    Card card1;
    Card card2;
    
    public Billfold()
    {
        card1 = null;
        card2 = null;
    }
    
    public void addCard(Card c)
    {
        if(card1 != null)
        {
            card1 = c;
        }
        else if(card2 != null)
        {
            card2 = c;
        }
    }
    
    public void printCard()
    {
        
    }
    
    public String formatCards()
    {
        if(card1 != null && card2 != null)
        {
            return "Card 1: " + card1.format() + "\n\nCard 2:" + card2.format(); 
        }
        else if(card1 != null && card2 == null)
        {
            return "Card 1: " + card1.format(); 
        }
        else if(card1 == null && card2 != null)
        {
            return card2.format(); 
        }
        else
        {
            return "Cards not initialized";
        }
    }
}
