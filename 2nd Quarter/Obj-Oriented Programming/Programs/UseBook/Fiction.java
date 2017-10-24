package usebook;
/**
 *
 * @author Dylan Connor
 */
public class Fiction extends Book implements BookConstants
{
    /**
     * Creates a fiction book object with price of 24.99
     * @param title 
     */
    public Fiction(String title)
    {
        super(title);
        
    }
    
    /**
     * Overrides the Book class setPrice with price given in
     * FictionConstants interface
     */
    public void setPrice(){this.price = fictionCost;}
}
