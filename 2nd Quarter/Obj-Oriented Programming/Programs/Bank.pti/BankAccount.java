package bank.pti;

/**
 * Abstract class for creating a bank account object 
 * with an accountNumber, accountBalance,
 * a Constructor, mutators, and accessors
 * 
 * @author Dylan Connor
 */
public abstract class BankAccount 
{
    protected int accountNumber;
    protected float accountBalance;
    
    /**
     * Constructor for a BankAccount using these parameters:
     * @param accountNumber
     * @param accountBalance 
     */
    public BankAccount(int accountNumber,
                       float accountBalance)
    {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }
    /**
     * Sets account balance to given parameter
     * @param balance 
     */
    public void setBalance(float balance){this.accountBalance = balance;}
    
    /**
     * Abstract methods for accessing the BankAccount constructor's information
     * @return 
     */
    public abstract float getBalance();
    public abstract int getAccountNumber();
    
    /**
     * Abstract method for displaying the BankAccount's fields
     * @return 
     */
    public abstract String getAccountInformation();
}
