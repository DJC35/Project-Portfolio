
package pti.bank;

import java.text.DateFormat;
import java.util.Date;


/**
 * implements TransactionTypes to create a new transaction object
 * @author Dylan Connor
 */
public class Transaction implements TransactionTypes
{
    private int checkNumber;
    private TransactionType transactionType;
    private Date date;
    private String recipient;
    private float amount;
    
    /**
     * Constructs a Transaction using these parameters:
     * @param checkNumber
     * @param transactionType
     * @param date
     * @param recipient
     * @param amount 
     */
    public Transaction(int checkNumber,
            TransactionType transactionType,
            String recipient,
            float amount)
    {
        this.checkNumber = checkNumber;
        this.transactionType = transactionType;
        this.date = new Date();
        this.recipient = recipient;
        this.amount = amount;
    }
    
    /**
     * Retrieves value of checkNumber
     * @return 
     */
    public int getCheckNumber(){return this.checkNumber;}
    
    /**
     * Retrieves value of transactionType
     * @return 
     */
    public TransactionType getTransactionType(){return this.transactionType;}
    
    /**
     * Retrieves value of date
     * @return 
     */
    public Date getDate()
    {
        return this.date;
    }
    
    /**
     * Retrieves value of recipient
     * @return 
     */
    public String getRecipient(){return this.recipient;}
    
    /**
     * Retrieves value of amount
     * @return 
     */
    public float getAmount(){return this.amount;}
    
    /**
     * Displays the data of Transaction in written format
     * @return 
     */
    public String toString()
    {
        return "CheckNumber:\t" + this.getCheckNumber() +
               "\nRecipient:\t" + this.getRecipient() +
               "\tDate:\t" + DateFormat.getDateInstance(DateFormat.MEDIUM).format(date) +
               "\nAmount:\t" + this.getAmount();
    }
}
