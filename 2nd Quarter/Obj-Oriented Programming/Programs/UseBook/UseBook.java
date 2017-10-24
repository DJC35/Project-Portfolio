package usebook;
/**
 * Instantiates two book objects as Fiction and Nonfiction
 * and displays their fields
 * @author Dylan Connor
 */
public class UseBook
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      
        //Creates Fiction object with title Hitch Hiker's Guide to the Galaxy
        Fiction fic = new Fiction("Hitch Hiker's Guide to the Galaxy Vol. 1");
        fic.setPrice();
        //Creates Nonfiction object with title JAVA Programming, Seventh Edition
        Nonfiction nonfic = new Nonfiction("JAVA Programming, Seventh Edition");
        nonfic.setPrice();
        //Displays the books' fields
        System.out.println(fic.getTitle() +" $"+fic.getPrice());
        System.out.println(nonfic.getTitle() +" $"+nonfic.getPrice());
        
    }
    
}
