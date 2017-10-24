
package utility;

/** Shows the Date in mm/dd/yyyy hr:min:sec format.
 *
 * Dylan Connor
 */
public class Date 
{
    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private int second;
    
    
    /** Parameter-less Constructor with variables initialized to 
     * 5/10/1951 10:05:00
     */
    public Date()
    {
        this.month = 5;
        this.day = 10;
        this.year = 1951;
        this.hour = 10;
        this.minute = 5;
        this.second = 0;
    }
    
    /** Creates constructor with Month,
     * Day, and Year as parameters that the user can input themselves
     * @param m is a user specified month as an integer from 1-12
     * @param d is a user specified day of the month as an integer from 1-31
     * @param y is a user specified year as an integer
     */
    public Date(int m, int d, int y)
    {
        this.month = m;
        this.day = d;
        this.year = y;
        this.hour = 10;
        this.minute = 5;
        this.second = 0;
    }
    
    /** Creates constructor with Month,
     * Day, Year, Hour, Minute,
     * and Second as parameters that the user can input themselves
     * @param m is a user specified month as an integer from 1-12
     * @param d is a user specified day of the month as an integer from 1-31
     * @param y is a user specified year as an integer
     * @param h is a user specified hour value as an integer from 1-12
     * @param min is a user specified minute value as an integer from 0-59
     * @param sec is a user specified second value as an integer from 0-59
    */
    public Date(int m, int d, int y, int h, int min, int sec)
    {
        this.month = m;
        this.day = d;
        this.year = y;
        this.hour = h;
        this.minute = min;
        this.second = sec;
    }
    
    /** Assigns value to the month
     * @param m
     * @throws utility.DateOutOfRangeException
     */
    public void setMonth(int m) throws DateOutOfRangeException
    {
        if(m < 1 || m > 12)
            throw new DateOutOfRangeException("The month value is invalid. Must be between 1 and 12 inclusive.");
        
        this.month = m;
    }
    
    /** Assigns value to the day
     * @param d
     * @throws utility.DateOutOfRangeException
     */
    public void setDay(int d) throws DateOutOfRangeException
    {
        if(d < 1 || d > 31)
            throw new DateOutOfRangeException("The day value is invalid. Must be between 1 and 31 inclusive.");
        
        this.day = d;
    }
    
    /** Assigns value to the year
     * @param y
     * @throws utility.DateOutOfRangeException
     */
    public void setYear(int y) throws DateOutOfRangeException
    {
        if(y < 0 || y > 9999)
            throw new DateOutOfRangeException("The year value is invalid. Must be between 1 and 9999 inclusive.");
        
        this.year = y;
    }
    
    /** Assigns value to the hour
     * @param h
     * @throws utility.DateOutOfRangeException
     */
    public void setHour(int h) throws DateOutOfRangeException
    {
        if(h < 1 || h > 12)
            throw new DateOutOfRangeException("The hour value is invalid. Must be between 1 and 12 inclusive.");
        
        this.hour = h;
    }
    
    /** Assigns value to the minute
     * @param min
     * @throws utility.DateOutOfRangeException
     */
    public void setMinute(int min) throws DateOutOfRangeException
    {
        if(min < 0 || min > 59)
            throw new DateOutOfRangeException("The minute value is invalid. Must be between 0 and 59 inclusive.");
        
        this.minute = min;
    }
    
    /** Assigns value to the second
     * @param sec
     * @throws utility.DateOutOfRangeException
     */
    public void setSecond(int sec) throws DateOutOfRangeException
    {
        if(sec < 0 || sec > 59)
            throw new DateOutOfRangeException("The seconds value is invalid. Must be between 0 and 59 inclusive.");
        
        this.second = sec;
    }
    
    
    /** Retrieves value of the month
     * @return 
     */
    public int getMonth(){return month;}
    
    /** Retrieves value of the day
     * @return 
     */
    public int getDay(){return day;}
    
    /** Retrieves value of the year
     * @return 
     */
    public int getYear(){return year;}
    
    /** Retrieves value of the hour
     * @return 
     */
    public int getHour(){return hour;}
    
    /** Retrieves value of the minute
     * @return 
     */
    public int getMinute(){return minute;}
    
    /** Retrieves value of the second
     * @return 
     */
    public int getSecond(){return second;}
    
    
    /** Compares two dates and returns a value,
     * if positive the invoking date is greater,
     * if 0 the Dates are the same,
     * and if negative the invoking date is less
     * 
     * @param thatDate
     * @return 
     */
    public int compair(Date thatDate)
    {
        if(this.year == thatDate.getYear())
        {
            if(this.month == thatDate.getMonth())
            {
                if(this.day == thatDate.getDay())
                {
                    return 0;
                }
                else 
                {
                    if(this.day > thatDate.getDay())
                    {
                        return 1;
                    }   
                    else
                    {
                        return -1;
                    }
                }
            }
            else 
            {
                if(this.month > thatDate.getMonth())
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        }
        else 
        {
            if(this.year > thatDate.getYear())
            {
                return 1;
            }
            else 
            {
                return -1;
            }
        }
        
        
        
    }
    /** Prints out the date in month/day/year hour:minute:second format
     * @return 
     */
    
    public String toString()
    {
        return this.month + 
                "/" + 
                this.day +
                "/" +
                this.year +
                " " +
                this.hour +
                ":" +
                this.minute +
                ":" +
                this.second;
    }
}
