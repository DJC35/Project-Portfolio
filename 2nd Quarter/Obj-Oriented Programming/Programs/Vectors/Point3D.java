
package vectors;

/**
 * Creates a point in 3D space
 * @author djc35
 */
public class Point3D extends Point2D
{
    private int z;
    
    
    public Point3D()
    {
        super();
        this.z = 0;
    }
    
    public Point3D(int xyz)
    {
        super(xyz);
        this.z = xyz;
    }
    
    public Point3D(int x, int y, int z)
    {
        super(x,y);
        this.z = z;
    }
    
    
    public void setZ(int z){this.z = z;}
    
    
    public int getZ(){return z;}
    
    @Override
    public boolean Equals(Object object)
    {
        if(object instanceof Point3D)
        {
            Point3D p = (Point3D)object;
            if(this.getX()==p.getX()&&this.getY()==p.getY()&&this.getZ()==p.getZ())
            {
                return true;
            }
        }
        return false;
    }
    
    public String toString(){return "(" + x + ", " + y + ", " + this.z + ")";}
}
