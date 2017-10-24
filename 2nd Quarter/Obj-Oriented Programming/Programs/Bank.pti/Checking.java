package bank.pti;

/**
 * Extends BankAccount abstract class to create a checking account
 * @author Dylan Connor
 */
public class Checking extends BankAccount
{
    /**
     * Uses the BankAccount constructor to create a Checking Account
     * using these parameters:
     * @param accountNumber
     * @param accountBalance 
     */
    public Checking(int accountNumber,
                    float accountBalance)
    {
        super(accountNumber, accountBalance);
        
    }
    
    /**
     * Retrieves the accountBalance value
     * @return 
     */
    public float getBalance(){return accountBalance;}
    
    /**
     * Retrieves the accountNumber value
     * @return 
     */
    public int getAccountNumber(){return accountNumber;}
    
    /**
     * Displays the Checking constructor's data fields
     * @return 
     */
    public String getAccountInformation()
    {
        return "Checking Account Information:\n"
                + "\tAccount Number:" + getAccountNumber() + "\n"
                + "\tAccount Balance:" + getBalance();
    }
}
