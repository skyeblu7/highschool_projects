

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door
{
    /** description of instance variable x (add comment for each instance variable) */
    private int length;
    private int width;
    private int height;
    private String open;
    private String name;

    /**
     * Default constructor for objects of class Door
     */
    public Door()
    {
        // initialise instance variables
        this.length = 5;
        this.width = 1;
        this.height = 10;
        this.open();
        this.name = "Fred";
    }
    
    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void open()
    {
        // put your code here
        this.open = "open";
    }
    
    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void close()
    {
        // put your code here
        this.open = "closed";
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
}
// 
//     public String getName()
//     {
//         return this.name;
//     }
//     
//     
//     public void setName(String newName)
//     {
//         this.name = newName;
//     }
// }
