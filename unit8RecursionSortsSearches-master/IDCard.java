

public class IDCard extends Card
{
    private int idNum;
    
    public IDCard(String n, int id)
    {
        super(n);
        idNum = id;
    }
    
     public int getID()
    {
        return idNum;
    }
    
    public String format()
    {
        return  "Card holder: " + getName() + "\nID number: " + idNum;
    }
    
    public boolean equals(IDCard other)
    {
        // first, check if this object and the other object are of the same class
        if(this.getClass() == other.getClass())
        {
            // if so, cast the other onject to an IDCard
            IDCard otherIDCard = (IDCard) other;
            
            // second, check if the superclass (Card) determines that this object and 
            // the other onject are equal
            boolean isEqual = super.equals(otherIDCard);
            
            // third, check if the instance variables of this object and the other object are equal
            return isEqual && this.idNum.equals(otherIDCard,idNum);
        }
        
        return false;
    }
}
