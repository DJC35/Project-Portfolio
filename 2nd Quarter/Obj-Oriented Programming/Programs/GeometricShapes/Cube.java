
package pti.edu;

/** Creates a Cube geometric object
 *
 * @author Dylan Connor
 */
public class Cube extends Square
{
    protected float depth;
    
    /**
     * Constructs a Cube object using these parameters:
     * @param height
     * @param width
     * @param depth 
     */
    public Cube(float height, float width, float depth)
    {
        super(height, width);
        this.depth = depth;
    }
    
    /**
     * Sets the Cube object's depth value
     * @param depth 
     */
    public void setDepth(float depth){this.depth = depth;}
    
    /**
     * Retrieves the Cube object's depth value
     * @return 
     */
    public float getDepth(){return depth;}
    
    /** 
     * Computes the surface area of a Cube object
     * equation: Area = 2*(d*w + h*w + h*d)
     */
    
    public void computeSurfaceArea()
    {
        this.surfaceArea = 2*(depth * width + height * width + height * depth);
    }
    
    /**
     * Displays the Cube object's height, width and depth
     * @return 
     */
    
    public String toString()
    {
        Cube c1 = new Cube(5,7,9);
        return "Height:" + c1.getHeight()+ " Width:" + c1.getWidth() + " Depth:" + c1.getDepth();
    }
    /**
     * Compares to Cube objects to see if they are the same
     * @param object
     * @return 
     */
    
    public boolean equals(Object object)
    {
        
        if(object instanceof Cube)
        {
            Cube other = (Cube)object;
            if( this.getHeight() == other.getHeight()
               && this.getWidth() == other.getWidth()
               && this.getDepth() == other.getDepth() )
            {
                return true;
            }
        }
        return false;
    }
}
