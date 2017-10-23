
package pti.edu;

/** Extends the CollegeEmployee class, which extends Person,
 * and adds boolean tenure to determine if the employee has tenure pay.
 *
 * Dylan Connor
 */
public class Faculty extends CollegeEmployee
{
    private boolean tenure;
    
    /** Constructs a Faculty object with the following parameters:
     * 
     * @param fN - First Name
     * @param lN - Last Name
     * @param sA - Street Address
     * @param zC - Zip Code
     * @param phNum - Phone Number
     * @param socialSecurityNumber - Social Security Number
     * @param departmentName - Department Name
     * @param annualSalary - Annual Salary
     * @param tenure - Tenure
     */
    public Faculty(String fN,
                   String lN,
                   String sA,
                   int zC,
                   String phNum,
                   String socialSecurityNumber,
                   String departmentName,
                   float annualSalary,
                   boolean tenure)
    {
        super(fN,
              lN,
              sA,
              zC,
              phNum,
              socialSecurityNumber,
              departmentName,
              annualSalary);
        this.tenure = tenure;
        
    }
    
    /** Sets faculty tenure value
     * 
     * @param t 
     */
    public void setTenure(boolean t){this.tenure = t;}
    
    /** Retrieves the Faculty's true/false tenure value
     * 
     * @return 
     */
    public boolean getTenure(){return tenure;}
    
    /** Prints out the Faculty object's data in readable format
     * 
     * @return 
     */
    public String toString()
    {
        return super.toString() +
               "\nIs Tenured?: " + tenure;
    }
}
