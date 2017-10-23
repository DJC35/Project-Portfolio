
package pti.bank;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Extends Account class and associates with Transaction for creating a Checking account object
 * @author Dylan Connor
 */
public class CheckingAccount extends Account
{
    private float minimumDailyBalance;
    private ArrayList<Transaction> register;
    
    /**
     * Creates a CheckingAccount object using these given parameters:
     * @param userID
     * @param nameOnAccount
     * @param initialBalance 
     */
    public CheckingAccount(int userID,
            String nameOnAccount,
            float initialBalance)
    {
        super(userID,nameOnAccount,initialBalance);
    }
    
    /**
     * Sets value of minimumDailyBalance
     * @param minimumDailyBalance 
     */
    public void setMinimumDailyBalance(float minimumDailyBalance)
    {this.minimumDailyBalance = minimumDailyBalance;}
    
    /**
     * Retrieves value of minimumDailyBalance
     * @return 
     */
    public float getMinimumDailyBalance(){return this.minimumDailyBalance;}
    
    /**
     * Iterates the Transaction object
     * @return 
     */
    public Iterator<Transaction> iterator()
    {
        return register.iterator();
    }

    /**
     * Creates a new Transaction object for CheckingAccount
     * @param transaction 
     */
    public void addTransaction(Transaction transaction){register.add(transaction);}
    
    /**
     * Takes an object cast as CheckingAccount 
     * to determine if two CheckingAccounts are the same
     * @param object
     * @return 
     */
    public boolean equals(Object object)
    {
        CheckingAccount cA = (CheckingAccount)object;
        if(object instanceof CheckingAccount)
            if(cA.getUserID() == this.getUserID())
                return true;
        return false;
    }
    
    /**
     * Displays CheckingAccount object's data in written form
     * @return 
     */
    public String toString()
    {
        return "UserID:\t" + this.getUserID() + 
               "\nName On Account:\t" + this.getNameOnAccount() +
               "\nBalance:\t" + this.getAccountBalance();
    }
    
}
