package pti.edu;

/**
 *
 * @author Dylan Connor
 */
public class Car 
{
    private String make;
    private String model;
    private String owner;
    private String licensePlate;
    
    /**
     * Creates a Car object with these given parameters:
     * @param make
     * @param model
     * @param owner
     * @param licensePlate 
     */
    public Car(String make,
               String model,
               String owner,
               String licensePlate)
    {
       this.make = make;
       this.model = model;
       this.owner = owner;
       this.licensePlate = licensePlate;
    }
    /**
     * Retrieves Make of the Car
     * @return 
     */
    public String getMake(){return this.make;}
    /**
     * Retrieves Model of the Car
     * @return 
     */
    public String getModel(){return this.model;}
    /**
     * Retrieves Owner of the Car
     * @return 
     */
    public String getOwner(){return this.owner;}
    /**
     * Retrieves LicensePlate of the Car
     * @return 
     */
    public String getLicensePlate(){return this.licensePlate;}
    /**
     * Checks to see if the license plate of this car is the same as another car
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof Car)
        {
            Car otherCar = (Car)object;
           if(this.getLicensePlate().equalsIgnoreCase(otherCar.getLicensePlate())) 
           {
               return true;
           }
        }
        return false;
    }
}
