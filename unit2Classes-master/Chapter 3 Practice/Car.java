

/**
 * 
 * The ckass Car has a certain fuel efficiency and a certain amount of fuel in the gas tank. A Car may be driven a specified distance which reduces the amount of gas in the tank
 * 
 * Write a description of class Car here.
 * 
 * @author Kristopher
 * @version 10 Sep 2015
 */
public class Car
{
    /** specifies the fuel efficieny of the car in units of miles per gallon (mpg)) */
    private double fuelEfficiency;
    
    
    /** specifies the amount of fuel in the gas tank in units of gallons */
    private double fuelInTank;

    /**
     * Default constructor for objects of class Car that specifies the fuel efficiency of the car
     */
    public Car(double gasEfficiency)
    {
        this.fuelInTank = 0.0;
        this.fuelEfficiency = gasEfficiency;
    }

    /**
     *Simulates driving the car the specified distance in miles and reduces the amount of fuel in the car's tank
     *
     * @pre        The specified distance cannot consume more than the fuel available in the tank
     *       
     * @param    distance    the specified distance to drive in miles
     */
    public void drive(double distance)
    {
       double gas = this.getGasInTank();
        fuelInTank -= distance / fuelEfficiency;
    }
    
    /**
     * Returns the number of gallons of gas in the car's tank
     *
     * @return  Returns the number of gallons of gas in the car's tank
     */
    public double getGasInTank()
    {
        return fuelInTank;
    }

    /**
     * Increments the fuel stored in the car's tank by the specified amount in gallons
     *
     * @pre     gallonsOfGas must be positive
     * 
     * @param   gallonsOfGas    The amount of gas being added to the car
     */
    public void addGas(double gallonsOfGas)
    {
        fuelInTank += gallonsOfGas;
    }

    
}
