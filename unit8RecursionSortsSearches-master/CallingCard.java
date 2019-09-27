

public class CallingCard extends Card
{
    private int cardNum;
    private int pinNum;
    
    public CallingCard(String n, int card, int pin)
    {
        super(n);
        cardNum = card;
        pinNum = pin;
    }
    
     public int getCardNumber()
    {
        return cardNum;
    }
    
     public int getPIN()
    {
        return pinNum;
    }
    
    public String format()
    {
        return  "Card holder: " + getName() + "\nCard number: " + cardNum + "\nPIN number: " + pinNum;
    }
}
