

public class DriverLicense extends Card
{
    private int expirationYear;
    
    public DriverLicense(String n, int y)
    {
        super(n);
        expirationYear = y;
    }
    
    public int getExpiration()
    {
        return expirationYear;
    }
    
    public String format()
    {
        return  "Card holder: " + getName() + "\nExpiration Year: " + expirationYear;
    }
}
