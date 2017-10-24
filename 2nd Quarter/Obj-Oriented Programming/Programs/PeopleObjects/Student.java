
package pti.edu;

/** Extends Person class into a Student with a major field of study
 * and a Grade Point Average.
 *
 * Dylan Connor
 */
public class Student extends Person
{
    private String major;
    private float GPA;
    
    /** Constructs a Student object with the following parameters:
     * 
     * @param fN - First Name
     * @param lN - Last Name
     * @param sA - Street Address
     * @param major - Major Field of Study
     * @param zC - Zip Code
     * @param phNum - Phone Number
     * @param gpa  - Grade Point Average
     */
   public Student(String fN,
                  String lN,
                  String sA,
                  int zC,
                  String phNum,
                  String major,
                  float gpa)
   {
       super(fN,
             lN,
             sA,
             zC,
             phNum);
       this.major = major;
       this.GPA = gpa;
   }
   
   /** Sets the Student's major field of study value
    * 
    * @param m 
    */
   public void setMajor(String m){this.major = m;}
   /** Retrieves the Student's major field of study value
    * 
    * @return 
    */
   public String getMajor(){return major;}
   
   /** Sets the Student's grade point average value
    * 
    * @param gpa 
    */
   public void setGPA(float gpa){this.GPA = gpa;}
   /** Retrieves the Student's grade point average value
    * 
    * @return 
    */
   public float getGPA(){return GPA;}
   
   /** Prints out the Student object's data in readable format
    * 
    * @return 
    */
   public String toString()
   {
        return super.toString() + 
               "\nMajor:" + major + 
               "\nGrade Point Average:" + GPA;
   }
}
