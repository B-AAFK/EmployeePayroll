package employeepayroll;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FullTimeEmployeeClassIT
{

    private FullTimeEmployeeClass fullTimeEmployee;

//----------------------------------------------------------------------------//
    @Before
    public void setUpClass()
    {
        //Initialize FullTimeEmployeeClass
        fullTimeEmployee = new FullTimeEmployeeClass();
    }

//----------------------------------------------------------------------------//    
    /**
     * Test of getBonus method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testGetBonus()
    {
        System.out.println("getBonus");
        //Bonus has not been calculated so its value will be 0
        double expResult = 0.0;
        //Set results value to the value of bonus using getter which has a value of 0
        double result = fullTimeEmployee.getBonus();
        assertEquals(expResult, result, 0);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of getSalary method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testGetSalary()
    {
        System.out.println("getSalary");
        //Salary has not been set so value is 0
        double expResult = 0.0;
        //Sets results value to of salary using the getter which has a value of 0
        double result = fullTimeEmployee.getSalary();
        assertEquals(expResult, result, 0);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of getFullGrossPay method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testGetFullGrossPay()
    {
        System.out.println("getFullGrossPay");
        //Passes 50000 to setSalary
        fullTimeEmployee.setSalary(50000);
        //Calculates the bonus using salary
        fullTimeEmployee.calculateBonus();
        // Gross Pay will 50000 + 5000 bonus
        double expResult = 55000.0;
        double result = fullTimeEmployee.getFullGrossPay();
        assertEquals(expResult, result, 0);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of calculateBonus method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testCalculateBonus()
    {
        System.out.println("calculateBonus");
        //Sets salary
        fullTimeEmployee.setSalary(50000);
        //Calculate the bonus
        fullTimeEmployee.calculateBonus();
        // Result is 10% of 50000 which is 5000
        double expResult = 5000.0;
        double result = fullTimeEmployee.getBonus();
        assertEquals(expResult, result, 0);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of calculateGrossPay method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testCalculateGrossPay()
    {
        System.out.println("calculateGrossPay");
        //Sets salary as 50000
        fullTimeEmployee.setSalary(50000);
        //Calculates the bonus using the salary
        fullTimeEmployee.calculateBonus();
        //Calculate the gross pay using bonus and salary
        fullTimeEmployee.calculateGrossPay();
        // Gross Pay will 50000 + 5000 bonus
        double expResult = 55000.0;
        double result = fullTimeEmployee.getFullGrossPay();
        assertEquals(expResult, result, 0);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of setSalary method, of class FullTimeEmployeeClass.
     */
    @Test
    public void testSetSalary()
    {
        System.out.println("setSalary");
        double salary = 50000.0;
        //Sets salary as 50000
        fullTimeEmployee.setSalary(salary);
        //Result will get the return value of 50000 from the getter
        double result = fullTimeEmployee.getSalary();
        assertEquals(salary, result, 0);

    }

}
//-------------------------END OF FILE----------------------------------------//
