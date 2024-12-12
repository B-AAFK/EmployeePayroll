package employeepayroll;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PartTimeEmployeeClassIT
{

    private PartTimeEmployeeClass partTimeEmployee;

//----------------------------------------------------------------------------//
    @Before
    public void setUpClass()
    {
        //Initialize PartTimeEmployeeClass
        partTimeEmployee = new PartTimeEmployeeClass();
    }
//----------------------------------------------------------------------------//

    /**
     * Test of getHours method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testGethours()
    {
        System.out.println("getHours");
        //hours has not been set yet so it should be 0
        int expResult = 0;
        //Calls the getter
        int result = partTimeEmployee.getHours();
        assertEquals(expResult, result);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of getPartGrossPay method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testGetPartGrossPay()
    {
        System.out.println("getPartGrossPay");
        // Passes 10 through the hours setter
        partTimeEmployee.setHours(10);
        // Passes 15 through the rate setter
        partTimeEmployee.setRate(15.0);
        // Expected result is  10 * 15 = 150
        double expResult = 150.0;
        double result = partTimeEmployee.getPartGrossPay();
        assertEquals(expResult, result, 0.01);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of getHourlyRate method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testGetHourlyRate()
    {
        System.out.println("getHourlyRate");
        //Expected result is expecting 0 as hourly rate has not be set
        double expResult = 0.0;
        //Calls getter
        double result = partTimeEmployee.getHourlyRate();
        assertEquals(expResult, result, 0.01);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of setHours method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testSetHours()
    {
        System.out.println("setHours");
        // hours is set to 20
        int hours = 20;
        //Passes hours through setHours methods
        partTimeEmployee.setHours(hours);
        assertEquals(hours, partTimeEmployee.getHours());
    }

//----------------------------------------------------------------------------//
    /**
     * Test of setRate method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testSetRate()
    {
        System.out.println("setRate");
        //rate is set to 25
        double rate = 25.0;
        //Passes rate through setRate method
        partTimeEmployee.setRate(rate);
        assertEquals(rate, partTimeEmployee.getHourlyRate(), 0.01);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of calculateGrossPay method, of class PartTimeEmployeeClass.
     */
    @Test
    public void testCalculateGrossPay()
    {
        System.out.println("calculateGrossPay");
        // Set the employees hours
        partTimeEmployee.setHours(5);
        // Set hourly rate to 27.5
        partTimeEmployee.setRate(27.5);
        // Result: 27.5 * 5 = 137.5
        double expResult = 137.5;
        // Calls getter
        double result = partTimeEmployee.getPartGrossPay();
        assertEquals(expResult, result, 0.01);
    }
//----------------------------------------------------------------------------//
}
//---------------------------END OF FILE--------------------------------------//
