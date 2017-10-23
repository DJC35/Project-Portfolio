
package pti.edu;

/** Extends Person class into a CollegeEmployee with an annual salary,
 * Social Security Number, and a Department Name.
 *
 * Dylan Connor
 */
public class CollegeEmployee extends Person
{
    protected String socialSecurityNumber;
    protected float annualSalary;
    protected String departmentName;
    
    /** Constructs a CollegeEmployee object with the following parameters:
     * 
     * @param fN - First Name
     * @param lN - Last Name
     * @param sA - Street Address
     * @param zC - Zip Code
     * @param phNum - Phone Number
     * @param socialSecurityNum - Social Security Number
     * @param dN - Department Name
     * @param aS - Annual Salary
     */
    public CollegeEmployee(String fN,
                           String lN,
                           String sA,
                           int zC,
                           String phNum,
                           String socialSecurityNum,
                           String dN,
                           float aS)
    {
        super(fN,
              lN,
              sA,
              zC,
              phNum);
        this.annualSalary = aS;
        this.departmentName = dN;
        this.socialSecurityNumber = socialSecurityNum;
    }
    
    /** Sets the Employee's social security number value
     * 
     * @param sSN 
     */
    public void setSocialSecurityNumber(String socialSecurityNum)
    {this.socialSecurityNumber = socialSecurityNum;}
    
    /** Retrieves the Employee's social security number value
     * 
     * @return 
     */
    public String getSocialSecurityNumber(){return socialSecurityNumber;}
    
    /** Sets the Employee's annual salary value
     * 
     * @param aS 
     */
    public void setAnnualSalary(float aS){this.annualSalary = aS;}
    
    /** Retrieves the Employee's annual salary value
     * 
     * @return 
     */
    public float getAnnualSalary(){return annualSalary;}
    
    /** Sets the Employee's Department Name value
     * 
     * @param dN 
     */
    public void setDepartmentName(String dN){this.departmentName = dN;}
    
    /** Retrieves the Employee's Department name value
     * 
     * @return 
     */
    public String getDepartmentName(){return departmentName;}
    
    /** Prints out the CollegeEmployee object's data in readable format
     * 
     * @return 
     */
    public String toString()
    {
        return super.toString() +
               "\nSocial Security Number: " + socialSecurityNumber +
               "\nAnnual Salary: $" + annualSalary +
               "\nDepartment Name: " + departmentName;
    }
}
