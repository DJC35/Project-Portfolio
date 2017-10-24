
package pti.edu;

/** Creates an object called Person, containing a first name, last name,
 * address, zip code, and a phone number
 *
 * Dylan Connor
 */
public class Person 
{
    protected String firstName;
    protected String lastName;
    protected String streetAddress;
    protected int zipCode;
    protected String phoneNumber;
    
    /** Constructs a Person object with the following parameters:
     * 
     * @param fN - First Name
     * @param lN - Last Name
     * @param sA - Street Address
     * @param zC - Zip Code
     * @param phNum - Phone Number
     */
    public Person(String fN,
                  String lN,
                  String sA,
                  int zC,
                  String phNum)
    {
        this.firstName = fN;
        this.lastName = lN;
        this.streetAddress = sA;
        this.zipCode = zC;
        this.phoneNumber = phNum;
        
    }
    
    /** Sets the Person's firstName value
     * 
     * @param fN 
     */
    public void setFirstName(String fN){this.firstName = fN;}
    
    /** Retrieves the Person's firstName value
     * 
     * @return 
     */
    public String getFirstName(){return firstName;}
    
    /** Sets the Person's lastName value
     * 
     * @param lN 
     */
    public void setLastName(String lN){this.lastName = lN;}
    
    /** Retrieves the Person's lastName value
     * 
     * @return 
     */
    public String getLastName(){return lastName;}
    
    /**Sets the Person's streetAddress value
     * 
     * @param sA 
     */
    public void setStreetAddress(String sA){this.streetAddress = sA;}
    
    /** Retrieves the Person's streetAddress value
     * 
     * @return 
     */
    public String getStreetAddress(){return streetAddress;}
    
    /** Sets the Person's zipCode value
     * 
     * @param zC 
     */
    public void setZipCode(int zC){this.zipCode = zC;}
    
    /** Retrieves the Person's zipCode value
     * 
     * @return 
     */
    public int getZipCode(){return zipCode;}
    
    /** Sets the Person's phoneNumber value
     * 
     * @param fN 
     */
    public void setPhoneNumber(String fN){this.firstName = fN;}
    
    /** Retrieves the phoneNumber value
     * 
     * @return 
     */
    public String getPhoneNumber(){return phoneNumber;}
    
    /** Prints out the Person object's data in readable format
     * 
     * @return 
     */
    public String toString()
    {
        return "First Name: " + firstName + 
               "\nLast Name: " + lastName +
               "\nAddress: " + streetAddress +
               "\nZip Code: " + zipCode +
               "\nPhone Number: " + phoneNumber;
    }
}
