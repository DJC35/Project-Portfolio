
package pti.bank;

/**
 * Extends Account class for creating a savings account object
 * @author Dylan Connor
 */
public class SavingsAccount extends Account
{
    private float interestRate;
    
    /**
     * Constructs a SavingsAccount object using the given parameters:
     * @param userID
     * @param nameOnAccount
     * @param initialBalance 
     */
    public SavingsAccount(int userID,
            String nameOnAccount,
            float initialBalance,float interestRate)
    {
        super(userID,
              nameOnAccount,
              initialBalance);
        this.interestRate = interestRate;
    }
    
    /**
     * Sets value of interestRate to given parameter:
     * @param newInterestRate 
     */
    public void setInterestRate(float newInterestRate)
    {this.interestRate = newInterestRate;}
    
    /**
     * Retrieves value of interestRate
     * @return 
     */
    public float getInterestRate(){return interestRate;}
    
    /**
     * Takes an object cast as SavingsAccount 
     * to determine if two SavingsAccounts are the same
     * @param object
     * @return 
     */
    public boolean equals(Object object)
    {
        SavingsAccount sA = (SavingsAccount)object;
        if(object instanceof SavingsAccount)
            if(sA.getUserID() == this.getUserID())
                return true;
        return false;
    }
    
    /**
     * Displays SavingsAccount object's data in written form
     * @return 
     */
    public String toString()
    {
        return "UserID:\t" + this.getUserID() +
               "\nName On Account:\t"+this.getNameOnAccount() + 
               "\nBalance:\t"+this.getAccountBalance() + 
               "\nInterest Rate:\t" + this.getInterestRate();
    }
}
