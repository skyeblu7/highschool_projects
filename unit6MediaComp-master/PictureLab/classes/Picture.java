import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the green to 0 */
  public void zeroGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
        [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.print(count);
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
   
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    }
  
  /**
   * An example of a method - replace this comment with your own
   *  that describes the operation of the method
   *
   */
    public void mirrorVerticalRightToLeft()
    {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for(int row = 0; row < pixels.length; row++)
    {
      for(int col = 0; col < width/2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width-1-col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**
   * Mirrors the top half of a picture to the bottom half
   *
   */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for(int row = 0; row < height / 2; row++)
        {
        for(int col = 0; col < pixels[0].length; col++)
        {
            topPixel = pixels[row][col];
            bottomPixel = pixels[height-1-row][col];
            bottomPixel.setColor(topPixel.getColor());
        }
    }
  }
  
  /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  public void mirrorHorizontalBotToTop()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      int height = pixels.length;
      for(int row = 0; row < height / 2; row++)
      {
          for(int col = 0; col < pixels[0].length; col++)
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[height-1-row][col];
              topPixel.setColor(bottomPixel.getColor());
          }
      }
  }
  
  public void mirrorArms()
  {
      int mirrorPoint = 191;
      Pixel bottomPixel = null;
      Pixel topPixel = null;
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      // loop through the rows
      for (int row = 158; row < mirrorPoint; row++)
      {
        // loop from 13 to just before the mirror point
        for (int col = 104; col < 170; col++)
        {
          topPixel = pixels[row][col];      
          bottomPixel = pixels[row+2*(mirrorPoint-row)][col];
          bottomPixel.setColor(topPixel.getColor());
          count++;
        }
      }
      mirrorPoint = 193;
      for (int row = 163; row < mirrorPoint; row++)
      {
        // loop from 13 to just before the mirror point
        for (int col = 238; col < 294; col++)
        {
          topPixel = pixels[row][col];      
          bottomPixel = pixels[row+2*(mirrorPoint-row)][col];
          bottomPixel.setColor(topPixel.getColor());
          count++;
        }
      }
  }

  /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }


  /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
      }
    }
  }


  /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
/*  public void fixUnderwater()
  {
     Pixel[][] pixels = this.getPixels2D();
     double[][] kernel = {{1/9,1/9,1/9},{1/9,1/9,1/9},{1/9,1/9,1/9}};
    for (int row = 1; row < pixels[0].length-1; row++)
    {
      for (int col = 1; col < pixels.length-1; col++)
      {
        int[] total = {0,0,0};
      }
    }
  }*/

  /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  public void mirrorGull()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int mirrorPoint = 345;
    for(int row = 233; row < 326; row++)
    {
      for(int col = 236; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+2*(mirrorPoint - col) - 220];
        rightPixel.setColor(leftPixel.getColor());
      }
    }  
  }
  
   /**
   * copies the region defined by rows and columns of piture1 into picture2
   *
   * @pre     preconditions for the method
   *          (what the method assumes about the method's parameters and class's state)
   * @post    postconditions for the method
   *          (what the method guarantees upon completion)
   * @param   y   description of parameter y
   * 
   */
  public void cropAndCopy(Picture sourcePicture, int startSourceRow, 
         int endSourceRow, int startSourceCol, int endSourceCol,
         int startDestRow, int startDestCol)
  {
      Pixel[][] destPixels = this.getPixels2D();
      Pixel[][] sourcePixels = sourcePicture.getPixels2D();
      Pixel sourcePixel = null;
      Pixel destPixel = null;
      int countRow = 0;
      int countCol = 0;
      for(int row = startDestRow; row <= startDestRow + endSourceRow - startSourceRow; row++)
      {
          for(int col = startDestCol; col <= startDestCol + endSourceCol - startSourceCol; col++)
          {
              sourcePixel = sourcePixels[startSourceRow + countRow][startSourceCol + countCol];
              destPixel = destPixels[row][col];
              destPixel.setColor(sourcePixel.getColor());
              countCol++;
          }
          countRow++;
          countCol = 0;
      }
  }
  
 /* public void scale(double factor)
  {
      Pixel[][] image = this.getPixels2D();
      Pixel[][] scaled = new Pixel[(int).5*image[0].length][(int).5*image.length];
      
      int r = 0;
      int b = 0;
      int g = 0;
      
      int scaledRow = 0;
      int scaledCol = 0;
      
      for(int row = 0; row < image[0].length - 1; row+=2)
      {
          for(int col = 0; col < image.length - 1; col+=2)
          {
             if(row == 0 && col == 0)
             {
                r = image[row][col].getColor().getRed();
                r += image[row+1][col].getColor().getRed();
                r += image[row+1][col+1].getColor().getRed();
                r += image[row][col+1].getColor().getRed();
                r /= 4;
                
                g = image[row][col].getColor().getGreen();
                g += image[row+1][col].getColor().getGreen();
                g += image[row+1][col+1].getColor().getGreen();
                g += image[row][col+1].getColor().getGreen();
                g /= 4;
                
                b = image[row][col].getColor().getBlue();
                b += image[row+1][col].getColor().getBlue();
                b += image[row+1][col+1].getColor().getBlue();
                b += image[row][col+1].getColor().getBlue();
                b /= 4;
             }
             else if(row == 0)
             {
                r = image[row][col].getColor().getRed();
                r += image[row+1][col].getColor().getRed();
                r += image[row+1][col+1].getColor().getRed();
                r += image[row][col+1].getColor().getRed();
                r += image[row+1][col-1].getColor().getRed();
                r += image[row][col-1].getColor().getRed();
                r /= 6;
                
                g = image[row][col].getColor().getGreen();
                g += image[row+1][col].getColor().getGreen();
                g += image[row+1][col+1].getColor().getGreen();
                g += image[row][col+1].getColor().getGreen();
                g += image[row+1][col-1].getColor().getGreen();
                g += image[row][col-1].getColor().getGreen();
                g /= 6;
                
                b = image[row][col].getColor().getBlue();
                b += image[row+1][col].getColor().getBlue();
                b += image[row+1][col+1].getColor().getBlue();
                b += image[row][col+1].getColor().getBlue();
                b += image[row+1][col-1].getColor().getBlue();
                b += image[row][col-1].getColor().getBlue();
                b /= 6;
             }
             else if(col == 0)
             {
                r = image[row][col].getColor().getRed();
                r += image[row+1][col].getColor().getRed();
                r += image[row+1][col+1].getColor().getRed();
                r += image[row][col+1].getColor().getRed();
                r += image[row-1][col].getColor().getRed();
                r += image[row-1][col+1].getColor().getRed();
                r /= 6;
                
                g = image[row][col].getColor().getGreen();
                g += image[row+1][col].getColor().getGreen();
                g += image[row+1][col+1].getColor().getGreen();
                g += image[row][col+1].getColor().getGreen();
                g += image[row-1][col].getColor().getGreen();
                g += image[row-1][col+1].getColor().getGreen();
                g /= 6;
                
                b = image[row][col].getColor().getBlue();
                b += image[row+1][col].getColor().getBlue();
                b += image[row+1][col+1].getColor().getBlue();
                b += image[row][col+1].getColor().getBlue();
                b += image[row-1][col].getColor().getBlue();
                b += image[row-1][col+1].getColor().getBlue();
                b /= 6;
             }
             else
             {
                r = image[row][col].getColor().getRed();
                r += image[row+1][col].getColor().getRed();
                r += image[row+1][col+1].getColor().getRed();
                r += image[row][col+1].getColor().getRed();
                r += image[row-1][col].getColor().getRed();
                r += image[row-1][col-1].getColor().getRed();
                r += image[row][col-1].getColor().getRed();
                r += image[row-1][col+1].getColor().getRed();
                r += image[row+1][col-1].getColor().getRed();
                r /= 9;
                
                g = image[row][col].getColor().getGreen();
                g += image[row+1][col].getColor().getGreen();
                g += image[row+1][col+1].getColor().getGreen();
                g += image[row][col+1].getColor().getGreen();
                g += image[row-1][col].getColor().getGreen();
                g += image[row-1][col-1].getColor().getGreen();
                g += image[row][col-1].getColor().getGreen();
                g += image[row-1][col+1].getColor().getGreen();
                g += image[row+1][col-1].getColor().getGreen();
                g /= 9;
             
                b = image[row][col].getColor().getBlue();
                b += image[row+1][col].getColor().getBlue();
                b += image[row+1][col+1].getColor().getBlue();
                b += image[row][col+1].getColor().getBlue();
                b += image[row-1][col].getColor().getBlue();
                b += image[row-1][col-1].getColor().getBlue();
                b += image[row][col-1].getColor().getBlue();
                b += image[row-1][col+1].getColor().getBlue();
                b += image[row+1][col-1].getColor().getBlue();
                b /= 9;
             }
             Color pixelColor = new Color(r,g,b);             
             scaled[scaledRow][scaledCol] = image[0][0].setColor(pixelColor);
             r = 0;
             b = 0;
             g = 0;
          }
          scaledCol = 0;
      }
  }
  
  
   /**
   * An example of a method - replace this comment with your own
   *
   * @param  y   a sample parameter for a method
   * @return     the sum of x and y
   */
  /*public void Diagonal()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel Pixel = null;
      Pixel shiftedPixel = null;
      
      int countRow = 0;
      int countCol = 0;
      
      for(int row = 0; row < pixels.length - 1; row++)
      {
          for(int col = 0; col < pixels[0].length - 1; col++)
          {
              Pixel = pixels[row][col];
              shiftedPixel = pixels[pixels.length-1 + countRow][pixels[0].length-1 + countCol];
              Pixel.setColor(shiftedPixel.getColor());
              countRow--;
          }
          countCol--;
          countRow = 0;
      }
  }*/

 
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture normalPMS = new Picture("PMS.png");
    Picture negatedPMS = new Picture("PMS.png");
    Picture grayscalePMS = new Picture("PMS.png");
    Picture zeroGreenPMS = new Picture("PMS.png");
    negatedPMS.negate();
    grayscalePMS.grayscale();
    zeroGreenPMS.negate();
    zeroGreenPMS.zeroGreen();
    
    this.copy(negatedPMS,0,0);
    
    this.mirrorHorizontal();
    
    this.copy(zeroGreenPMS,0,0);
    
    this.mirrorVerticalRightToLeft();
    
    this.copy(grayscalePMS,0,0);
    
    this.copy(normalPMS,240,0);
            
    this.write("collage.jpg");    
  }
  
  /* Main method for testing - each class in Java can have a main 
  * method 
  */
  public static void main(String[] args) 
  {
     Picture blank = new Picture("640x480.jpg");
     blank.createCollage();
     blank.explore();
  }
} // this } is the end of class Picture, put all new methods before this
