package employeepayroll;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class EmployeeClassIT
{

    private EmployeeClass employee;

//----------------------------------------------------------------------------//
    @Before
    public void setUpClass()
    {
        //Initialize EmployeeClass
        employee = new EmployeeClass();
    }

//----------------------------------------------------------------------------//
    /**
     * Test of getEmployeeName method, of class EmployeeClass.
     */
    @Test
    public void testGetEmployeeName()
    {
        System.out.println("getEmployeeName");
        // Test data
        String name = "Matthew Bowes";
        EmployeeClass instance = new EmployeeClass(name, 1234567890123L, "Full-time");

        // Call method
        String testName = instance.getEmployeeName();

        // Result
        assertEquals(name, testName);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of setPay and getPay method, of class EmployeeClass.
     */
    @Test
    public void testSetAndGetPay()
    {
        System.out.println("setPay and getPay");
        // Test data
        double pay = 50000.0;
        employee.setPay(pay);

        // Call method
        double actualPay = employee.getPay();

        // Result
        assertEquals(pay, actualPay, 0.001);
    }

//----------------------------------------------------------------------------//
    /**
     * Test of getIDNumber method, of class EmployeeClass.
     */
    @Test
    public void testGetIDNumber()
    {
        System.out.println("getIDNumber");
        // Test data
        long id = 1234567890123L;
        EmployeeClass instance = new EmployeeClass("Matthew Bowes", id, "Full-time");

        // Call method
        long testID = instance.getIdNumber();

        // Result
        assertEquals(id, testID);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of getType method, of class EmployeeClass.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        // Test data
        String type = "Full-time";
        EmployeeClass instance = new EmployeeClass("Matthew Bowes", 1234567890123L, type);

        // Call method
        String testType = instance.getType();

        // Result
        assertEquals(type, testType);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of setTax and getTax method, of class EmployeeClass.
     */
    @Test
    public void testSetAndGetTax()
    {
        System.out.println("setTax and getTax");
        // Test data
        double tax = 5000;
        employee.setTax(tax);

        // Call method
        double actualTax = employee.getTax();

        // Result
        assertEquals(tax, actualTax, 0.001);
    }
//----------------------------------------------------------------------------//    

    /**
     * Test of addEmployee method, of class EmployeeClass.
     */
    @Test
    public void testAddEmployee()
    {
        System.out.println("addEmployee");
        //initial array size
        int initialSize = employee.employee.size();
        //Add employee
        EmployeeClass instance = new EmployeeClass("Matthew Bowes", 1234567890123L, "Full-time");
        employee.employee.add(instance);
        //Get size after adding object
        int newSize = employee.employee.size();

        //Check  initialSize which is -1 and add 1 to is making it 0 and then newSize which is 0
        assertEquals(initialSize + 1, newSize);

    }
//----------------------------------------------------------------------------//

    /**
     * Test of deleteEmployee method, of class EmployeeClass.
     */
    @Test
    public void testDeleteEmployee()
    {
        System.out.println("deleteEmployee");
        // Initial size of the employee list
        int initialSize = employee.employee.size();

        // Add an employee
        EmployeeClass instance = new EmployeeClass("Matthew Bowes", 1234567890123L, "Full-time");
        employee.employee.add(instance);

        // Size after adding the employee
        int sizeAfterAdd = employee.employee.size();
        assertEquals(initialSize + 1, sizeAfterAdd);

        // Delete the employee
        employee.employee.remove(sizeAfterAdd - 1);

        // Size after removing the employee
        int sizeAfterDelete = employee.employee.size();

        // Check that the size is back to the initial size
        assertEquals(initialSize, sizeAfterDelete);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of search method, of class EmployeeClass.
     */
    @Test
    public void testSearch()
    {
        System.out.println("search");
        //Add employee
        EmployeeClass instance = new EmployeeClass("Matthew Bowes", 1234567890123L, "Full-time");
        employee.employee.add(instance);
        // Search for an employee
        int index = employee.search("Matthew Bowes");

        // Return index of object
        assertEquals(0, index);

        // Employee that doesn't exist
        index = employee.search("Non Existent");

        // Confirm that index -1 is returned
        assertEquals(-1, index);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of calculateTax method, of class EmployeeClass.
     */
    @Test
    public void testCalculateTax()
    {
        System.out.println("calculateTax");
        // Test data
        employee.setPay(50000);

        // Calculate tax
        double tax = employee.calculateTax(employee);

        // Expected tax (20% of 50000) = 10000
        assertEquals(10000.0, tax, 0.001);
    }
//----------------------------------------------------------------------------//

    /**
     * Test of calculateNetPay method, of class EmployeeClass.
     */
    @Test
    public void testCalculateNetPay()
    {
        System.out.println("calculateNetPay");
        // Test data
        employee.setPay(50000);
        employee.setTax(10000.0);

        // Calculate net pay
        double netPay = employee.calculateNetPay(employee);

        // Expected net pay
        assertEquals(40000.0, netPay, 0.001);
    }
}
//--------------------------END OF FILE---------------------------------------//
