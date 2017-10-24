
package pti.edu;

/** Creates a square geometric shape
 *
 * @author Dylan Connor
 */
public class Square 
{
    protected float height;
    protected float width;
    protected float surfaceArea;
    
    /** Constructs a Square object 
     * using these Parameters:
     * @param height
     * @param width 
     */
    public Square(float height, float width)
    {
        this.height = height;
        this.width = width;
    }
    
    /** Sets the Square object's height
     * 
     * @param height 
     */
    public void setHeight(float height){this.height = height;}
    
    /** Sets the Square object's width
     * 
     * @param width 
     */
    public void setWidth(float width){this.width = width;}
    
    /** Retrieves class variable values
     * 
     * @return 
     */
    public float getHeight(){return height;}
    public float getWidth(){return width;}
    public float getSurfaceArea(){return surfaceArea;}
    
    /**
     * Calculates area of the Square
     */
    public void computeSurfaceArea()      
    {
        
        this.surfaceArea = height * width;
        
    }
    /**
     * Displays Height and width of the Square object
     * @return 
     */
    public String toString()
    {
        Square s1 = new Square(5,7);
        return "Height:" + s1.getHeight() + " Width:" + s1.getWidth();
    }
    
    /**
     * Compares two Square objects to see if they are the same
     * @param object
     * @return 
     */
    public boolean equals(Object object)
    {
        
        if(object instanceof Square)
        {
            Square other = (Square)object;
            if( this.getHeight() == other.getHeight() 
                && this.getWidth() == other.getWidth() )
            {
                return true;
            }
        }
        return false;
    }
}
