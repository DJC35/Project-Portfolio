
package utility;

/**
 * User defined exception created to inform the user that the 
 * given date is invalid
 * 
 * Valid domains of the Date class are as follows
 *      0 < year <= 9999
 *      0 < month <= 12
 *      0 < day <= 31
 *      0 < hour <= 12
 *      0 <= minute <= 59
 *      0 <= second <= 59
 *
 * @author djc35
 */
public class DateOutOfRangeException extends Exception
{
    public DateOutOfRangeException()
    {
        super();
    }
    
    public DateOutOfRangeException(String message)
    {
        super(message);
    }
}
