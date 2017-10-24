package usebook;
/**
 *
 * @author Dylan Connor
 */
public abstract class Book 
{
    public String title;
    public double price;
    
    /**
     * Constructs a Book object
     * @param title 
     */
    public Book(String title)
    {
        this.title = title;
    }
    
    /** Retrieves the Book title and Price
     * @return 
     */
    public String getTitle(){return this.title;}
    public double getPrice(){return this.price;}
    
    /**
     * Abstract method for setting the price of a book
     */
    public abstract void setPrice();
}
