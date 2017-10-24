
package pti.bank;

/**
 * Abstract class for a bank account object
 * @author Dylan Connor
 */
public abstract class Account 
{
    private int userID;
    private float balance;
    private String nameOnAccount;
    
    /**
     * Constructs an Account object using these parameters:
     * @param userID
     * @param nameOnAccount
     * @param initialBalance 
     */
    public Account(int userID,
            String nameOnAccount,
            float initialBalance)
    {
        this.userID = userID;
        this.balance = initialBalance;
        this.nameOnAccount = nameOnAccount;
    }
    
    /**
     * Sets nameOfAccount value to the value of the given parameter
     * @param newName 
     */
    public void setNameOnAccount(String newName)
    {
        this.nameOnAccount = newName;
    }
    
    /**
     * Retrieves value of userID
     * @return 
     */
    public int getUserID(){return userID;}
    
    /**
     * Retrieves value of nameOnAccount
     * @return 
     */
    public String getNameOnAccount(){return nameOnAccount;}
    
    /**
     * Retrieves value of balance
     * @return 
     */
    public float getAccountBalance(){return balance;}
    
    /**
     * Abstract equals method for child classes
     * @param object
     * @return 
     */
    public abstract boolean equals(Object object);
    
    /**
     * Abstract toString method for child classes
     * @return 
     */
    public abstract String toString();
}
