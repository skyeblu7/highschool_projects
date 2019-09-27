public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
  /**
   *returns how often a given integer is found in the matrix
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  public int getCount(int value)
  {
      int count = 0;
      for(int i = 0; i < matrix.length; i++)
      {
        for(int j = 0; j < matrix[0].length; j++ )
        {
            if(matrix[i][j] == value)
            {
                count++;
            }
        }
      }
      return count;
  }

  /**
   * returns largest value in a matrix
   *
   * @pre     preconditions for the method
   *          (what the method assumes about the method's parameters and class's state)
   * @post    postconditions for the method
   *          (what the method guarantees upon completion)
   * @param   y   description of parameter y
   * @return  description of the return value
   */
  public int getLargest()
  {
      int largest = 0;
      for(int i = 0; i < matrix.length; i++)
      {
        for(int j = 0; j < matrix[0].length; j++ )
        {
            if(matrix[i][j] > largest)
            {
                largest = matrix[i][j];
            }
        }
      }
      return largest;
  }
 
  /**
   * returns the total of all integers in a specified column
   *
   * @pre     preconditions for the method
   *          (what the method assumes about the method's parameters and class's state)
   * @post    postconditions for the method
   *          (what the method guarantees upon completion)
   * @param   y   description of parameter y
   * @return  description of the return value
   */
  public int getColTotal(int column)
  {
      int total = 0;
      for(int row = 0; row < matrix.length; row++)
      {
        total += matrix[row][column];
      }
      return total;
  }
    
}