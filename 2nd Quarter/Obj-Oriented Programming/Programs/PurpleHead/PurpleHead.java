
package purplehead;

/**
 *
 * @author Dylan Connor
 */
import PTI.edu.*;
public class PurpleHead 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Student s1 = new Student("Tom",
                                "Jones",
                                "3 Tanny Ln.",
                                1345,
                                "123-456-7890",
                                "Programming",
                                3.6f);
        
        System.out.println("" + Student.toString(s1));
    }
    
}
