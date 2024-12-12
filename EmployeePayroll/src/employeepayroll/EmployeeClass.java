package employeepayroll;

import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeClass
{

    //Create Variables
    private String employeeName;
    private long employeeID;
    private String employeeType;
    private double pay;
    private double tax;
    //Create objects
    ArrayList<EmployeeClass> employee = new ArrayList<>();
    ArrayList<FullTimeEmployeeClass> fullTime = new ArrayList<>();
    ArrayList<PartTimeEmployeeClass> partTime = new ArrayList<>();

    //Create Scanner
    Scanner myScanner = new Scanner(System.in);

//----------------------------------------------------------------------------// 
    //Default Constructor
    public EmployeeClass()
    {

    }
//----------------------------------------------------------------------------//
    //Parameterised Constructor

    public EmployeeClass(String name, long id, String type)
    {
        this.employeeName = name;
        this.employeeID = id;
        this.employeeType = type;
    }
//----------------------------------------------------------------------------//
    //Getters

    //name
    protected String getEmployeeName()
    {
        return this.employeeName;
    }

    //pay
    protected double getPay()
    {
        return this.pay;
    }

    //id
    protected long getIdNumber()
    {
        return this.employeeID;
    }

    //type
    protected String getType()
    {
        return this.employeeType;
    }

    //tax
    protected double getTax()
    {
        return this.tax;
    }
//----------------------------------------------------------------------------//
    //Setter

    protected void setPay(double gross)
    {
        this.pay = gross;
    }

    protected void setTax(double tax)
    {
        this.tax = tax;
    }
//----------------------------------------------------------------------------//
    //Menu

    public void Menu()
    {
        //Display menu option
        System.out.print("""
                         Employee Payroll Application
                         -------------------------------
                         Please Select a menu option
                         1) Add Employee
                         2) Delete Employee
                         3) Full-time Employee
                         4) Part-Time Employee
                         5) Show Employee Report
                         6) Exit Application""");

        while (true)
        {
            String option = myScanner.nextLine();
            switch (option)
            {
                case "1" ->
                    addEmployee();
                case "2" ->
                    deleteEmployee();
                case "3" ->
                    displayFullTime();
                case "4" ->
                    displayPartTime();
                case "5" ->
                    showReport();
                case "6" ->
                    exitApplication();
                default ->
                    System.out.println("Invalid input");
            }

        }
    }
//----------------------------------------------------------------------------// 
    //Add new Employee

    protected void addEmployee()
    {
        //local variables
        String name;
        long id = 0;
        String type;

        //Capture Name
        System.out.println("Please enter the employee's name:");
        name = myScanner.nextLine();
        System.out.println("Employee name captured");

        //Capture ID
        System.out.print("Please enter the employee's ID number (13 digits):");
        while (true)
        {
            String idInput = myScanner.nextLine();
            //ChatGPT helped with Checking that idInput only contain 13 digits and checks that the string only contains digits
            if (idInput.length() == 13 && idInput.matches("\\d+"))
            {
                id = Long.parseLong(idInput);
                break;
            } else
            {
                System.out.println("Invalid ID, please enter  13 digits ");
            }

        }

        //Capture employee type 
        System.out.println("Please enter a number based on employee type 1)Full-time , 2)Part-time :");
        while (true)
        {
            String option = myScanner.nextLine();

            switch (option)
            {
                case "1":
                    type = "Full-time";
                    //Adds employee to ArrayList
                    employee.add(new EmployeeClass(name, id, type));
                    fullTime.add(new FullTimeEmployeeClass());
                    partTime.add(new PartTimeEmployeeClass());

                    //Confirmation message
                    System.out.println("Full-time employee added");

                    //Recalls the menu
                    Menu();

                case "2":
                    type = "Part-time";
                    //Adds employee to ArrayList
                    employee.add(new EmployeeClass(name, id, type));
                    partTime.add(new PartTimeEmployeeClass());
                    fullTime.add(new FullTimeEmployeeClass());

                    //Confirmation message
                    System.out.println("Part-time employee added");

                    //Recalls the menu
                    Menu();

                default:
                    System.out.println("Invalid input, please enter '1' for full-time and '2' for part-time ");
            }

        }

    }

//----------------------------------------------------------------------------//
    //Delete Employee
    protected void deleteEmployee()
    {

        //Set index to minus 1 for ArrayList 
        int index = -1;

        System.out.println("Please enter a employee name to search for");
        //get input
        String deleteInput = myScanner.nextLine();

        //Find the employee using the input
        for (EmployeeClass employee : employee)
        {
            if (employee.getEmployeeName().equalsIgnoreCase(deleteInput))
            {
                //Sets the index to the index of where the employee was found
                index = this.employee.indexOf(employee);
                //exits loop
                break;
            }
        }

        //if the employee is found
        if (index != -1)
        {
            System.out.println("Please enter (yes/no) if you would like to delete the employee");

            while (true)
            {
                String confirm = myScanner.nextLine();

                //if yes was entered
                if (confirm.equalsIgnoreCase("yes"))
                {
                    employee.remove(index);
                    fullTime.remove(index);
                    partTime.remove(index);

                    //Confirmation message
                    System.out.println("Employee has been deleted");
                    break;

                } //if no was entered
                else if (confirm.equalsIgnoreCase("no"))
                {
                    System.err.println("Employee was not deleted");
                    break;
                }

                //invalid option
                System.err.println("Invalid input, enter yes/no");
            }

        } //Employee not found
        else if (index == -1)
        {
            System.out.println("Employee was not found");

        }
        //Call menu
        Menu();
    }

//----------------------------------------------------------------------------//
    //Full-time Employee Display and Edit
    private void displayFullTime()
    {
        // Display headings
        System.out.println("----------------------FULL-TIME--EMPLOYEES---------------------------------");

        // Loop through every employee and display them 
        for (int i = 0; i < employee.size(); i++)
        {
            EmployeeClass emp = employee.get(i);

            // Check if the employee is full-time
            if (emp.getType().equalsIgnoreCase("Full-time"))
            {
                FullTimeEmployeeClass fullTimeEmp = fullTime.get(i);

                // Display employee information in a single line
                System.out.println("Employee Name: " + emp.getEmployeeName() + "\n"
                        + "ID number: " + emp.getIdNumber() + "\n"
                        + "Type: " + emp.getType() + "\n"
                        + "Salary: " + fullTimeEmp.getSalary() + "\n"
                        + "Bonus: " + fullTimeEmp.getBonus());
                System.out.println("------------------------------------------------------------------------------");
            }
        }

        System.out.print("Would you like to edit an employee's pay (yes/no)? ");
        String option = myScanner.nextLine();

        while (true)
        {
            switch (option.toLowerCase())
            {
                case "yes":
                    System.out.println("Please enter the employee's name whose pay you would like to edit:");
                    String inputName = myScanner.nextLine();
                    // Search for the name
                    int index = search(inputName);
                    // if employee is found and is Full-time
                    if (index != -1 && employee.get(index).getType().equalsIgnoreCase("Full-time"))
                    {

                        // Get the full-time employee object
                        FullTimeEmployeeClass fullTimeEmployee = fullTime.get(index);

                        System.out.println("Please enter the salary:");
                        double salary = myScanner.nextDouble();
                        // Set salary
                        fullTimeEmployee.setSalary(salary);

                        // Clear Scanner
                        myScanner.nextLine();

                        // Add employee bonus
                        System.out.println("Do you want to give a bonus (yes/no)? ");
                        option = myScanner.nextLine();
                        while (true)
                        {
                            switch (option.toLowerCase())
                            {
                                case "yes":
                                    fullTimeEmployee.calculateBonus();
                                    break;
                                case "no":
                                    break;
                                default:
                                    System.out.println("Invalid input, enter yes/no: ");
                                    option = myScanner.nextLine();
                                    continue;
                            }
                            break;
                        }

                        // Confirmation
                        System.out.println("Details have been changed.");
                        // Recall method to show updated info
                        displayFullTime();

                    } else
                    {
                        System.out.println("Employee not found.");
                        // Call menu
                        Menu();
                    }
                    break;

                case "no":
                    // Call Menu
                    Menu();
                    break;

                default:
                    System.out.println("Invalid option, please enter yes/no: ");
                    option = myScanner.nextLine();
                    break;
            }
        }
    }
//----------------------------------------------------------------------------//

    //Part-Time Employee Display and Edit
    private void displayPartTime()
    {
        // Display headings

        System.out.println("----------------------PART-TIME--EMPLOYEES---------------------------------");

        // Loop through every employee and display them 
        for (int i = 0; i < employee.size(); i++)
        {
            EmployeeClass emp = employee.get(i);

            // Check if the employee is Part-time
            if (emp.getType().equalsIgnoreCase("Part-time"))
            {
                PartTimeEmployeeClass partTimeEmp = partTime.get(i);

                // Display employee information in a single line
                System.out.println("Employee Name: " + emp.getEmployeeName() + "\n"
                        + "ID number: " + emp.getIdNumber() + "\n"
                        + "Type: " + emp.getType() + "\n"
                        + "Hours worked: " + partTimeEmp.getHours() + "\n"
                        + "Hourly rate: " + partTimeEmp.getHourlyRate());
                System.out.println("------------------------------------------------------------------------------");
            }
        }

        System.out.print("Would you like to edit an employee's pay (yes/no)? ");
        String option = myScanner.nextLine();

        while (true)
        {
            switch (option.toLowerCase())
            {
                case "yes":
                    System.out.println("Please enter the employee's name whose pay you would like to edit:");
                    String inputName = myScanner.nextLine();
                    // Search for the name
                    int index = search(inputName);
                    // if employee is found and is Part-time
                    if (index != -1 && employee.get(index).getType().equals("Part-time"))
                    {

                        //Create and get the part-time employee object
                        PartTimeEmployeeClass partTimeEmployee = partTime.get(index);

                        System.out.println("Please enter the amount of full hours the employee has worked:");
                        int hours = myScanner.nextInt();
                        // Set hours worked
                        partTimeEmployee.setHours(hours);

                        System.out.println("Please enter the employee's hourly wage:");
                        double wage = myScanner.nextDouble();
                        // Set hourly pay
                        partTimeEmployee.setRate(wage);

                        // Confirmation
                        System.out.println("Details have been changed.");
                        // Clear the buffer
                        myScanner.nextLine();
                        // Recall method to show updated info
                        displayPartTime();

                    } else
                    {
                        System.out.println("Employee not found.");
                        // Call menu
                        Menu();
                    }
                    break;

                case "no":
                    // Call Menu
                    Menu();
                    break;

                default:
                    System.out.println("Invalid option, please enter yes/no: ");
                    option = myScanner.nextLine();
                    break;
            }
        }
    }

//----------------------------------------------------------------------------//    
//Search Employee and return its Array index 
    protected int search(String name)
    {
        //Set index to minus 1 for ArrayList 
        int index = -1;

        //Find the employee using the method parameter
        for (EmployeeClass employee : employee)
        {
            if (employee.getEmployeeName().equalsIgnoreCase(name))
            {
                //Sets the index to the index of where the employee was found
                index = this.employee.indexOf(employee);
                //exits loop
                break;
            }
        }

        return index;
    }

//----------------------------------------------------------------------------//  
    //Calculate tax for eployee based on salary, object gets passed through method
    protected double calculateTax(EmployeeClass emp)
    {
        double salary = emp.getPay();
        double taxable;

        // basic 20% to make it a simple calculation(not realistic on condition of threshold)
        taxable = salary * 0.20;

        // Set the calculated tax to the employee
        emp.setTax(taxable);

        return taxable;
    }

//----------------------------------------------------------------------------// 
    //Calculate employee net pay (pay - tax ),object gets passed through method
    protected double calculateNetPay(EmployeeClass emp)
    {
        double netPay = emp.getPay() - emp.getTax();
        return netPay;
    }

//----------------------------------------------------------------------------// 
    //Display all employee details
    private void showReport()
    {
        // Display headings
        System.out.println("---------------------EMPLOYEE-DETAILS---------------------------------");

        // Loop through every employee and display them 
        for (int i = 0; i < employee.size(); i++)
        {
            EmployeeClass emp = employee.get(i);

            if (emp.getType().equals("Full-time"))
            {
                FullTimeEmployeeClass fullTimeEmp = fullTime.get(i);
                //Set the pay for full-time
                employee.get(i).setPay(fullTimeEmp.getFullGrossPay());
                // Display full-time employee information separated by hyphen
                System.out.println("Employee Name: " + emp.getEmployeeName() + "\n"
                        + "ID number: " + emp.getIdNumber() + "\n"
                        + "Type: " + emp.getType() + "\n"
                        + "Gross Income: " + fullTimeEmp.getFullGrossPay() + "\n"
                        + "Taxable Income: " + calculateTax(emp) + "\n"
                        + "Net Income: " + calculateNetPay(emp) + "\n"
                        + "Hours worked (Part-Time): " + "N/A\n" // No hours worked for full-time
                        + "Hourly rate (Part-Time): " + "N/A"); // No hourly rate for full-time
            } else if (emp.getType().equals("Part-time"))
            {
                PartTimeEmployeeClass partTimeEmp = partTime.get(i);
                //Set the pay for part-time
                employee.get(i).setPay(partTimeEmp.getPartGrossPay());

                // Display part-time employee information separated by hyphen
                System.out.println("Employee Name: " + emp.getEmployeeName() + "\n"
                        + "ID number: " + emp.getIdNumber() + "\n"
                        + "Type: " + emp.getType() + "\n"
                        + "Gross Income: " + partTimeEmp.getPartGrossPay() + "\n"
                        + "Taxable Income: " + calculateTax(emp) + "\n"
                        + "Net Income: " + calculateNetPay(emp) + "\n"
                        + "Hours worked (Part-Time): " + partTimeEmp.getHours() + "\n"
                        + "Hourly rate (Part-Time): " + partTimeEmp.getHourlyRate());
            }
            System.out.println("------------------------------------------------------------------------------");
        }
        //Call menu
        Menu();
    }

//----------------------------------------------------------------------------//
    //Exit Application
    private void exitApplication()
    {
        System.exit(0);
    }

//----------------------------------------------------------------------------//    
}
//-------------END OF FILE----------------------------------------------------//
