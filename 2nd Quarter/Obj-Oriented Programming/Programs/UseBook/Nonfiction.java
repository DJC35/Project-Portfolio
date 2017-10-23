package usebook;
/**
 *
 * @author Dylan Connor
 */
public class Nonfiction extends Book implements BookConstants
{
    /**
     * Creates a non fiction book object with price of 34.99
     * @param title 
     */
    public Nonfiction(String title)
    {
        super(title);
        
    }
    /**
     * Overrides the Book class setPrice with price given in
     * NonfictionConstants interface
     */
    public void setPrice(){this.price = nonfictionCost;}
}
