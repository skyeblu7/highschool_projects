
public class PartialArray
{
    private int[] values;
    private int currentSize;
  
    public PartialArray()
    {
        this.values = new int[100];
        for( this.currentSize = 0; this.currentSize < 20; this.currentSize++ )
        {
            this.values[this.currentSize] = this.currentSize * this.currentSize;
        }
    }

    public void remove(int pos)
    {
        for(int i = pos + 1; i < this.currentSize; i++)
        {
            this.values[i - 1] = this.values[i];
        }
        this.currentSize--;
    }
    
    public void insert(int pos, int newValue)
    {
        if(this.currentSize == this.values.length)
        {
            this.grow();
        }
        for(int i = currentSize; i > pos; i--)
        {
            this.values[i] = this.values[i-1];
        }
        
        this.values[pos] = newValue;
        currentSize++;
    }
    
    public void swap(int posA, int posB)
    {
        int temp = this.values[posA];
        this.values[posA] = this.values[posB];
        this.values[posB] = temp;
    }
    
    private void grow()
    {
        int[] newValues = new int[this.currentSize * 2];
        for (int i = 0; i < this.currentSize; i++)
        {
            newValues[i] = this.values[i];
        }
        
        this.values = newValues;
    }
    
    public static void main(String[] args)
    {
        
    }
}
