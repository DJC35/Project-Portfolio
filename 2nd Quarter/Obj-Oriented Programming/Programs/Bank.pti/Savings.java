package bank.pti;

/**
 * Extends BankAccount abstract class to create a savings account
 * @author Dylan Connor
 */
public class Savings extends BankAccount
{
    protected float interestRate;
    
    /**
     * Uses BankAccount constructor as base,
     * adding one parameter for a Savings account: interestRate
     * @param accountNumber
     * @param accountBalance
     * @param interestRate 
     */
    public Savings(int accountNumber,
                   float accountBalance,
                   float interestRate)
    {
       super(accountNumber, accountBalance);
       this.interestRate = interestRate;
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
     * Retrieves the interestRate value
     * @return 
     */
    public float getInterestRate(){return interestRate;}
    
    /**
     * Displays the Savings constructor's data fields
     * @return 
     */
    public String getAccountInformation()
    {
        return "Savings Account Information:\n"
            + "\tAccount Number:" + getAccountNumber() + "\n"
            + "\tAccount Balance:" + getBalance() + "\n"
            + "\tInterest Rate:" + getInterestRate();
    }
    
}
