

public class ArrayOps2
{
    private int[] values;
    public ArrayOps2(int[] initialValues){ values = initialValues; }
    public void swapFirstAndLast()
    {
        int first = values[0];        
        values[0] = values[values.length-1];
        values[values.length-1] = first;
    }
    public void shiftRight() 
    {
        int last = values[values.length-1];
        for(int i = 1; i < values.length; i++)
        {
            values[i] = values[i-1];
        }
        values[0] = last;
    }
    public void replaceEvenWith0()
    {
        for(int i = 0; i < values.length; i++)
        {
            if (values[i] % 2 == 0)
            {
                values[i] = 0;
            }
        }
    }
    public void PlaceAllButFirstandLastWithTheLargerOfItsTwoNeighbors()
    {
        for(int i = 1; i < values.length-1; i++)
        {
            if(values[i-1] > values[i+1])
            {
                values[i] = values[i-1];
            }
            else if(values[i-1] < values[i+1])
            {
                values[i] = values[i+1];
            }
        }
    }
    public void RemoveMiddleTwoOrOneElement()
    {
        if(values.length % 2 == 0)
        {
            int toDel = values.length / 2;
            for(int i = toDel-1; i < values.length; i++)
            {
                values[i] = values[i+2];
            }
        }
        else
        {
            int toDel = values.length-1 / 2;
            for(int i = toDel+1; i < values.length; i++)
            {
                values[i] = values[i+1];
            }
        }
    }
    public void moveAllEvenElementsToFront() //ambiguous
    {
        System.out.println();
    }
    public int returnSecondLargestElementInArray()
    {
        int largest = 0;
        int secondLargest = 0;
        for(int i = 0; i < values.length; i++)
        {
            if(values[i] > largest)
            {
                secondLargest = largest;
                largest = values[i];
            }
        }
        return secondLargest;
    }
    public boolean returnTrueIfArraySortedInIncreasingOrder()
    {
        for(int i = values.length-1; i > 0; i--)
        {
            if(values[i-1] > values[i])
            {
                return false;
            }
        }
        if(values[0] > values[1])
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean returnTrueIfArrayContainsTwoAdjacentDuplicateElements()
    {
        for(int i = 1; i < values.length-1; i++)
        {
            if(values[i-1] == values[i] || values[i+1] == values[i])
            {
                return true;
            }
        }
        if(values[0] == values[1] || values[values.length-1] == values[values.length-2])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean returnTrueIfArrayContainsDuplicateElements()
    {
        for(int i = 0; i < values.length; i++)
        {
            int duplicate = i;
            for(int j = 0; j < values.length; j++)
            {
                if (duplicate == values[j] && !(i == j))
                {
                    return true;
                }
            }
        }
        return false;
    }
}